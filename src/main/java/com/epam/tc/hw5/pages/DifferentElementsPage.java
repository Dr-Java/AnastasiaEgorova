package com.epam.tc.hw5.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage extends AbstractBasePage {

    @FindBy(xpath = "//label[text()[contains(.,'Water')]]/input")
    private WebElement waterCheckbox;

    @FindBy(xpath = "//label[text()[contains(.,'Wind')]]/input")
    private WebElement windCheckbox;

    @FindBy(xpath = "//label[text()[contains(.,'Selen')]]/input")
    private WebElement selenRadioButton;

    @FindBy(xpath = "//select[@class='uui-form-element']/option[text()='Yellow']")
    private WebElement yellowColorDropdownItem;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

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

    public boolean waterCheckBoxIsSelected() {
        return waterCheckbox.isSelected();
    }

    public boolean windCheckBoxIsSelected() {
        return windCheckbox.isSelected();
    }

    public boolean selenRadioIsSelected() {
        return selenRadioButton.isSelected();
    }

    public boolean yellowInDropdownIsSelected() {
        return yellowColorDropdownItem.isSelected();
    }

    public List<WebElement> getLogRowText() {
        return logsPanel.getLogRows();
    }
}
