package com.epam.tc.hw5.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuComponent extends AbstractComponent {

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@class='dropdown-toggle']")
    private WebElement serviceHeaderMenuItemDropdown;

    @FindBy(xpath = "//a[@href='different-elements.html']")
    private WebElement differentElementsItem;

    @FindBy(xpath = "//a[@href='user-table.html']")
    private WebElement userTableItem;

    public HeaderMenuComponent(WebDriver driver) {
        super(driver);
    }

    public void clickServiceMenuItem() {
        serviceHeaderMenuItemDropdown.click();
    }

    public void clickDifferentElementsItem() {
        differentElementsItem.click();
    }

    public void clickUserTableItem() {
        userTableItem.click();
    }
}
