package com.epam.tc.egorova.hw3.ex1;

import com.epam.tc.egorova.hw3.BaseTest;
import org.testng.annotations.Test;

public class ExerciseOneTest extends BaseTest {

    @Test(groups = "jdiLightNew")
    public void testExerciseOne() {

        //Assert Browser title
        homePageTests.assertBrowserTitle("Home Page");

        //Perform login
        homePageTests.performLogin(username, password);

        //Assert Username is loggined
        homePageTests.assertUsernameLoggined(expectedUsername);

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        homePageTests.assertFourHeaderItemsHaveProperTexts();

        //Assert that there are 4 images on the Index Page and they are displayed
        homePageTests.assertFourIndexPageImagesDisplayed();

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePageTests.assertFourTextsUnderIconsHaveProperText();

        //Assert that there is the iframe with “Frame Button” exist
        homePageTests.assertIFrameWithFrameButtonExists();

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        homePageTests.switchToIFrameAndCheckFrameButtonDisplayed();

        //Switch to original window back
        homePageTests.switchToOriginalWindow();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        homePageTests.assertFiveLeftSectionItemsHaveProperText();
    }
}


