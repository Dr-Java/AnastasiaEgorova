package com.epam.tc.egorova.hw3.ex2;

import com.epam.tc.egorova.hw3.BaseTest;
import org.testng.annotations.Test;

public class ExerciseTwoTest extends BaseTest {

    @Test(groups = "jdiLightNew")
    public void testExerciseTwo() {
        //Assert Browser title
        homePageTests.assertBrowserTitle("Home Page");

        //Perform login
        homePageTests.performLogin(username, password);

        //Assert User name in the left-top side of screen that user is loggined
        homePageTests.assertUsernameLoggined(expectedUsername);

        //Open through the header menu Service -> Different Elements Page
        homePageTests.clickServiceMenuItem();
        homePageTests.clickDifferentElementsItem();

        //Select checkboxes (Water, Wind)
        differentElementsPageTests.selectWaterCheckbox();
        differentElementsPageTests.selectWindCheckbox();

        //Select radio (Selen)
        differentElementsPageTests.selectSelenRadioButton();

        //Select in dropdown (Yellow)
        differentElementsPageTests.selectYellowColorInDropdown();

        /*
         Assert that
         for each checkbox there is an individual log row and value is corresponded to the status of checkbox
         for radio button there is a log row and value is corresponded to the status of radio button
         for dropdown there is a log row and value is corresponded to the selected value.
         */

        differentElementsPageTests.assertWaterCheckboxIsSelectedAndLogRowDisplayed();
        differentElementsPageTests.assertWindCheckboxIsSelectedAndLogRowDisplayed();
        differentElementsPageTests.assertSelenRadioIsSelectedAndLogRowDisplayed();
        differentElementsPageTests.assertYellowColorIsSelectedAndLogRowDisplayed();

    }
}

