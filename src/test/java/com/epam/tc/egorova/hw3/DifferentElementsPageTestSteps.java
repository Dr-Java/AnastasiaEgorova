package com.epam.tc.egorova.hw3;

import com.epam.tc.hw3.pages.DifferentElementsPage;
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

    public void assertThatLogRowsAreDisplayed(List<String> expectedTexts) {
        List<WebElement> logRows = differentElementsPage.getLogRows();
        for (WebElement element : logRows) {
            softAssert.assertThat(element.isDisplayed());
        }
        for (int i = 0; i < logRows.size(); i++) {
            softAssert.assertThat(logRows.get(i).getText()).isEqualTo(expectedTexts.get(i));
        }
        softAssert.assertAll();
    }
}

