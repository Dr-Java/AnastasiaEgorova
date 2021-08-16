package com.epam.tc.egorova.hw3.bonus;

import java.util.List;
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

        differentElementsPage = homePage.clickServiceHeaderMenuItem()
                .clickDifferentElementsItem();
        differentElementsPage.clickWaterCheckbox()
                             .clickWindCheckbox()
                             .clickSelenRadioButton()
                             .clickYellowColorDropdownItem();
        softAssert.assertThat(differentElementsPage.logRowsAreDisplayed());

        bonusTestSteps.assertThatLogRowsAreDisplayed(List.of(
            "value changed to Yellow",
            "value changed to Selen",
            "condition changed to true",
            "condition changed to true"));

        softAssert.assertAll();
    }
}
