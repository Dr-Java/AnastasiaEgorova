package com.epam.tc.egorova.hw5.cucumber.context;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;

public class TestContext {

    private static TestContext instance;
    private WebDriver driver;

    private TestContext() {
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
