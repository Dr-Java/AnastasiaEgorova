package com.epam.tc.hw7jdi.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.tc.hw7jdi.entities.User;
import com.epam.tc.hw7jdi.forms.LoginForm;

@Url("/index.html")
public class JdiHomePage extends WebPage {

    @FindBy(css = "#login-form")
    public static LoginForm loginForm;

    @FindBy(id = "user-icon")
    public static Icon userIcon;

    @FindBy(id = "user-name")
    public Text userName;

    public static void login(User user) {
        userIcon.click();
        loginForm.loginAs(user);
    }

    public String getUserName() {
        return userName.getText();
    }

    public void userShouldBeLoggined() {
        userName.is().text(User.ROMAN.getFullName());
    }
}

