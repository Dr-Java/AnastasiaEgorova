package com.epam.tc.hw5.pages.components;

import com.epam.tc.hw5.pages.HomePage;
import com.epam.tc.hw5.utils.UserProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFormComponent extends AbstractComponent {

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

    public LoginFormComponent(WebDriver driver) {
        super(driver);
    }

    public HomePage login() {
        userIcon.click();
        loginUsernameField.sendKeys(UserProperties.getUsername());
        loginUserPasswordField.sendKeys(UserProperties.getPassword());
        enterButton.click();
        return new HomePage(driver);
    }

    public String getLogginedUsername() {
        return logginedUsername.getText();
    }
}
