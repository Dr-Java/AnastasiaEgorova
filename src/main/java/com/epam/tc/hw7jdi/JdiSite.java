package com.epam.tc.hw7jdi;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.tc.hw7jdi.entities.User;
import com.epam.tc.hw7jdi.pages.JdiHomePage;
import com.epam.tc.hw7jdi.pages.MetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @FindBy(css = "header ul.navbar-nav.m-l8 > li")
    public static Menu headerMenu;

    public static JdiHomePage jdiHomePage;

    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void open() {
        jdiHomePage.open();
    }

    public static void login(User user) {
        JdiHomePage.login(user);
    }

    public static String getUserName() {
        return jdiHomePage.getUserName();
    }
}
