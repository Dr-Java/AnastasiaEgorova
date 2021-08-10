package com.epam.tc.egorova.hw3;

import com.epam.tc.hw3.pages.DifferentElementsPage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPageTests {

    private DifferentElementsPage differentElementsPage;
    SoftAssertions softAssert = new SoftAssertions();

    public DifferentElementsPageTests(WebDriver driver) {
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

    public void assertWaterCheckboxIsSelectedAndLogRowDisplayed() {
        softAssert.assertThat(differentElementsPage.getWaterLogRow().isDisplayed());
    }

    public void assertWindCheckboxIsSelectedAndLogRowDisplayed() {
        softAssert.assertThat(differentElementsPage.getWindLogRow().isDisplayed());
    }

    public void assertSelenRadioIsSelectedAndLogRowDisplayed() {
        softAssert.assertThat(differentElementsPage.getSelenMetalLogRow().isDisplayed());
    }

    public void assertYellowColorIsSelectedAndLogRowDisplayed() {
        softAssert.assertThat(differentElementsPage.getYellowColorLogRow().isDisplayed());
    }
}

