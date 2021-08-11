package com.epam.tc.egorova.hw3;

import com.epam.tc.hw3.pages.DifferentElementsPage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPageTestSteps {

    private DifferentElementsPage differentElementsPage;
    SoftAssertions softAssert = new SoftAssertions();

    public DifferentElementsPageTestSteps(WebDriver driver) {
        differentElementsPage = new DifferentElementsPage(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectWaterCheckbox() {
        differentElementsPage.clickWaterCheckbox();
    }

    public void selectWindCheckbox() {
        differentElementsPage.clickWindCheckbox();
    }

    public void selectSelenRadioButton() {
        differentElementsPage.clickSelenRadioButton();
    }

    public void selectYellowColorInDropdown() {
        differentElementsPage.clickYellowColorDropdownItem();
    }

    public void assertIndividualLogRowsAreDisplayed(String option, String mode, String text) {
        softAssert.assertThat(differentElementsPage.isLogRowDisplayed(option, mode, text))
                  .as("Log row is not diplayed");
    }
}

