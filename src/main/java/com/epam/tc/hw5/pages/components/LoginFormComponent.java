package com.epam.tc.hw5.pages.components;

import com.epam.tc.hw5.entity.User;
import com.epam.tc.hw5.entityutils.UserBuilder;
import com.epam.tc.hw5.pages.HomePage;
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
        User user = UserBuilder.returnNewUser();
        userIcon.click();
        loginUsernameField.sendKeys(user.getUsername());
        loginUserPasswordField.sendKeys(user.getPassword());
        enterButton.click();
        return new HomePage(driver);
    }

    public String getLogginedUsername() {
        return logginedUsername.getText();
    }
}
