package com.epam.tc.egorova.hw6.teststeps;

import com.epam.tc.hw6.pages.DifferentElementsPage;
import io.qameta.allure.Step;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPageTestSteps {

    private DifferentElementsPage differentElementsPage;
    SoftAssertions softAssert = new SoftAssertions();

    public DifferentElementsPageTestSteps(WebDriver driver) {
        differentElementsPage = new DifferentElementsPage(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Select Water checkbox")
    public void selectWaterCheckbox() {
        differentElementsPage.clickWaterCheckbox();
    }

    @Step("Select Wind checkbox")
    public void selectWindCheckbox() {
        differentElementsPage.clickWindCheckbox();
    }

    @Step("Select Selen radiobutton")
    public void selectSelenRadioButton() {
        differentElementsPage.clickSelenRadioButton();
    }

    @Step("Select Yellow in dropdown")
    public void selectYellowColorInDropdown() {
        differentElementsPage.clickYellowColorDropdownItem();
    }

    @Step("Assert that individual log rows are displayed")
    public void assertThatLogRowsAreDisplayed() {
        List<WebElement> logRows = differentElementsPage.getLogRows();
        List<String> expectedTexts = List.of(
            "value changed to Yellow",
            "value changed to Selen",
            "condition changed to true",
            "condition changed to true");
        for (WebElement element : logRows) {
            softAssert.assertThat(element.isDisplayed());
        }
        for (int i = 0; i < logRows.size(); i++) {
            softAssert.assertThat(logRows.get(i).getText()).isEqualTo(expectedTexts.get(i));
        }
        softAssert.assertAll();
    }
}
