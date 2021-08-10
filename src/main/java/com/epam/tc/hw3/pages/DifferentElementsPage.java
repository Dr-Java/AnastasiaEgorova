package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage {

    protected WebDriver driver;

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

    public void clickWaterCheckbox() {
        waterCheckbox.click();
    }

    public void clickWindCheckbox() {
        windCheckbox.click();
    }

    public void clickSelenRadioButton() {
        selenRadioButton.click();
    }

    public void clickYellowColorDropdownItem() {
        yellowColorDropdownItem.click();
    }

    public WebElement getWaterLogRow() {
        return waterLogRow;
    }

    public WebElement getWindLogRow() {
        return windLogRow;
    }

    public WebElement getSelenMetalLogRow() {
        return selenMetalLogRow;
    }

    public WebElement getYellowColorLogRow() {
        return yellowColorLogRow;
    }
}


