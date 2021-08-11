package com.epam.tc.hw3.bonus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginUsernameField;

    @FindBy(id = "password")
    private WebElement loginUserPasswordField;

    @FindBy(id = "login-button")
    private WebElement enterButton;

    @FindBy(id = "user-name")
    private WebElement logginedUsername;

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@class='dropdown-toggle']")
    private WebElement serviceHeaderMenuItem;

    @FindBy(xpath = "//a[@href='different-elements.html']")
    private WebElement differentElementsItem;

    public HomePage clickUserIcon() {
        userIcon.click();
        return this;
    }

    public HomePage setUsername(String username) {
        loginUsernameField.sendKeys(username);
        return this;
    }

    public HomePage setPassword(String password) {
        loginUserPasswordField.sendKeys(password);
        return this;
    }

    public HomePage clickEnterButton() {
        enterButton.click();
        return this;
    }

    public String getLogginedUsername() {
        return logginedUsername.getText();
    }

    public HomePage clickServiceHeaderMenuItem() {
        serviceHeaderMenuItem.click();
        return this;
    }

    public DifferentElementsPage clickDifferentElementsItem() {
        differentElementsItem.click();
        return new DifferentElementsPage(driver);
    }
}


