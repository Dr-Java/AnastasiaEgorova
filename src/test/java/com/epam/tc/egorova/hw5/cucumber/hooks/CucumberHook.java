package com.epam.tc.egorova.hw5.cucumber.hooks;

import com.epam.tc.egorova.hw5.cucumber.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHook {

    private WebDriver driver;

    @Before
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        TestContext.getInstance().setDriver(driver);
    }

    @After
    public void tearDownDriver() {
        driver.quit();
    }
}
