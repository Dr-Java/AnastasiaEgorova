package com.epam.tc.egorova.hw3.ex2;

import com.epam.tc.egorova.hw3.BaseTest;
import org.testng.annotations.Test;

public class ExerciseTwoTest extends BaseTest {

    @Test(groups = "jdiLightNew")
    public void testExerciseTwo() {
        //Assert Browser title
        homePageTestSteps.assertBrowserTitle("Home Page");

        //Perform login
        homePageTestSteps.performLogin(username, password);

        //Assert User name in the left-top side of screen that user is loggined
        homePageTestSteps.assertUsernameLoggined(expectedUsername);

        //Open through the header menu Service -> Different Elements Page
        homePageTestSteps.clickServiceMenuItem();
        homePageTestSteps.clickDifferentElementsItem();

        //Select checkboxes (Water, Wind)
        differentElementsPageTestSteps.selectWaterCheckbox();
        differentElementsPageTestSteps.selectWindCheckbox();

        //Select radio (Selen)
        differentElementsPageTestSteps.selectSelenRadioButton();

        //Select in dropdown (Yellow)
        differentElementsPageTestSteps.selectYellowColorInDropdown();

        /*
         Assert that
         for each checkbox there is an individual log row and value is corresponded to the status of checkbox
         for radio button there is a log row and value is corresponded to the status of radio button
         for dropdown there is a log row and value is corresponded to the selected value.
         */

        differentElementsPageTestSteps.assertIndividualLogRowsAreDisplayed("Water", "condition",
            "true");
        differentElementsPageTestSteps.assertIndividualLogRowsAreDisplayed("Wind", "condition",
            "true");
        differentElementsPageTestSteps.assertIndividualLogRowsAreDisplayed("metal", "value",
            "selen");
        differentElementsPageTestSteps.assertIndividualLogRowsAreDisplayed("Colors", "value",
            "Yellow");
    }
}

