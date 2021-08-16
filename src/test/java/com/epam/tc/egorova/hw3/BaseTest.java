package com.epam.tc.egorova.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected HomePageTestSteps homePageTestSteps;
    protected DifferentElementsPageTestSteps differentElementsPageTestSteps;
    private String siteURL = "https://jdi-testing.github.io/jdi-light/index.html";
    private String userPropertiesFile = "src/test/resources/user.properties";
    protected String username;
    protected String password;
    protected String expectedUsername;

    @BeforeMethod(alwaysRun = true)
    public void prepare() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(siteURL);
        getUserData(userPropertiesFile);
        homePageTestSteps = new HomePageTestSteps(driver);
        differentElementsPageTestSteps = new DifferentElementsPageTestSteps(driver);
    }

    public void getUserData(String properties) {
        Properties userProperties = new Properties();
        try (FileInputStream fis = new FileInputStream(userPropertiesFile)) {
            userProperties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        username = userProperties.getProperty("siteusername");
        password = userProperties.getProperty("sitepassword");
        expectedUsername = userProperties.getProperty("expectedusername");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        driver.quit();
    }


}
