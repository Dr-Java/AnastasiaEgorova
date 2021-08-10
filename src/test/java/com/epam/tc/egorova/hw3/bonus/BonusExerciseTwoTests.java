package com.epam.tc.egorova.hw3.bonus;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class BonusExerciseTwoTests extends BaseTests {

    SoftAssertions softAssert = new SoftAssertions();

    @Test(groups = "jdiLightBonus")
    public void testExTwoBonus() {
        softAssert.assertThat(homePage.getBrowserTitle())
                  .as("Browser Title is Incorrect")
                  .isEqualTo("Home Page");

        homePage.clickUserIcon()
                .setUsername(username)
                .setPassword(password)
                .clickEnterButton();
        softAssert.assertThat(homePage.getLogginedUsername())
                  .as("Username is incorrect")
                  .isEqualTo(expectedUsername);

        homePage.clickServiceHeaderMenuItem()
                .clickDifferentElementsItem();
        differentElementsPage.clickWaterCheckbox()
                             .clickWindCheckbox()
                             .clickSelenRadioButton()
                             .clickYellowColorDropdownItem();
        softAssert.assertThat(differentElementsPage.logRowsAreDisplayed());
        softAssert.assertThat(differentElementsPage.waterCheckboxIsSelectedAndLogRowIsDisplayed());
        softAssert.assertThat(differentElementsPage.windCheckboxIsSelectedAndLogRowIsDisplayed());
        softAssert.assertThat(differentElementsPage.selenMetalRadioButtonIsSelectedAndLogRowIsDisplayed());
        softAssert.assertThat(differentElementsPage.yellowColorIsSelectedAndLogRowIsDisplayed());

        softAssert.assertAll();
    }
}
