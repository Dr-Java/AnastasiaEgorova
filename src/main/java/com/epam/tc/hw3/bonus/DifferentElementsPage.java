package com.epam.tc.hw3.bonus;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage extends BasePage {

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[text()[contains(.,'Water')]]/input")
    private WebElement waterCheckbox;

    @FindBy(xpath = "//label[text()[contains(.,'Wind')]]/input")
    private WebElement windCheckbox;

    @FindBy(xpath = "//label[text()[contains(.,'Selen')]]/input")
    private WebElement selenRadioButton;

    @FindBy(xpath = "//select[@class='uui-form-element']/option[text()='Yellow']")
    private WebElement yellowColorDropdownItem;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']")
    private WebElement logsPanel;

    @FindBy(xpath = "//li[text()[contains(.,'%s: %s changed to %s')]]")
    private List<WebElement> logRows;

    public DifferentElementsPage clickWaterCheckbox() {
        waterCheckbox.click();
        return this;
    }

    public DifferentElementsPage clickWindCheckbox() {
        windCheckbox.click();
        return this;
    }

    public DifferentElementsPage clickSelenRadioButton() {
        selenRadioButton.click();
        return this;
    }

    public DifferentElementsPage clickYellowColorDropdownItem() {
        yellowColorDropdownItem.click();
        return this;
    }

    public boolean logRowsAreDisplayed() {
        return logsPanel.isDisplayed();
    }

    public boolean isLogRowDisplayed(String option, String mode, String text) {
        boolean display = false;
        for (WebElement logRow : logRows) {
            display = logRow.isDisplayed();
        }
        return display;
    }
}

