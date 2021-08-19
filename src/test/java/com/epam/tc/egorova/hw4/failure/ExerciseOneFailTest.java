package com.epam.tc.egorova.hw4.failure;

import com.epam.tc.egorova.hw4.teststeps.BaseTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class ExerciseOneFailTest extends BaseTests {

    @Test
    @Feature("Exercise one feature with failure")
    @Story("Exercise one failure: Home Page")
    public void testExerciseOne() {

        //Assert Browser title
        homePageTestSteps.assertBrowserTitle("Failure");

        //Perform login
        homePageTestSteps.performLogin(username, password);

        //Assert Username is loggined
        homePageTestSteps.assertUsernameLoggined(expectedUsername);

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        homePageTestSteps.assertFourHeaderItemsHaveProperTexts();

        //Assert that there are 4 images on the Index Page and they are displayed
        homePageTestSteps.assertFourIndexPageImagesDisplayed();

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePageTestSteps.assertFourTextsUnderIconsHaveProperText();

        //Assert that there is the iframe with “Frame Button” exist
        homePageTestSteps.assertIFrameWithFrameButtonExists();

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        homePageTestSteps.switchToIFrameAndCheckFrameButtonDisplayed();

        //Switch to original window back
        homePageTestSteps.switchToOriginalWindow();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        homePageTestSteps.assertFiveLeftSectionItemsHaveProperText();

    }
}
