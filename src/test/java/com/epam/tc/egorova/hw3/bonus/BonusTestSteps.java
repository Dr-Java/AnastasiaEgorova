package com.epam.tc.egorova.hw3.bonus;

import com.epam.tc.hw3.bonus.DifferentElementsPage;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BonusTestSteps {

    private DifferentElementsPage differentElementsPage;
    SoftAssertions softAssert = new SoftAssertions();

    public BonusTestSteps(WebDriver driver) {
        differentElementsPage = new DifferentElementsPage(driver);
        PageFactory.initElements(driver, this);
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
