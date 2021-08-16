package com.epam.tc.hw3.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage extends BasePage {

    protected WebDriver driver;

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

    public List<WebElement> getLogRows() {
        return logRows;
    }
}


