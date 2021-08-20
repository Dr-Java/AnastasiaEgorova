package com.epam.tc.hw5.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractComponent {

    protected WebDriver driver;
    protected Actions actions;

    protected AbstractComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }
}
