package com.epam.tc.hw3.bonus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage {

    private WebDriver driver;

    public DifferentElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li[contains(text(),'Water: condition changed to true')]")
    private WebElement waterLogRow;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li[contains(text(),'Wind: condition changed to true')]")
    private WebElement windLogRow;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li[contains(text(),'metal: value changed to  Selen')]")
    private WebElement selenMetalLogRow;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li[contains(text(),'Colors: value changed to Yellow')]")
    private WebElement yellowColorLogRow;

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

    public boolean waterCheckboxIsSelectedAndLogRowIsDisplayed() {
        return waterLogRow.isDisplayed();
    }

    public boolean windCheckboxIsSelectedAndLogRowIsDisplayed() {
        return windLogRow.isDisplayed();
    }

    public boolean selenMetalRadioButtonIsSelectedAndLogRowIsDisplayed() {
        return selenMetalLogRow.isDisplayed();
    }

    public boolean yellowColorIsSelectedAndLogRowIsDisplayed() {
        return yellowColorLogRow.isDisplayed();
    }
}

