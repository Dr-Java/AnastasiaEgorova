package com.epam.tc.egorova.hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ExerciseTwoTest {

    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private WebElement webElement;
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass(alwaysRun = true)
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(groups = {"jdiLight"})
    public void testExerciseTwo() {
        //Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        //Assert Browser title
        String browserTitle = driver.getTitle();
        String expectedBrowserTitle = "Home Page";
        softAssert.assertEquals(browserTitle, expectedBrowserTitle);

        //Perform login
        webElement = driver.findElement(By.id("user-icon"));
        webElement.click();

        String username = "Roman";
        webElement = driver.findElement(By.id("name"));
        webElement.sendKeys(username);

        String password = "Jdi1234";
        webElement = driver.findElement(By.id("password"));
        webElement.sendKeys(password);

        webElement = driver.findElement(By.xpath("//span[text()='Enter'][1]"));
        webElement.click();

        //Assert User name in the left-top side of screen that user is loggined
        String expectedUsernameLoggined = "ROMAN IOVLEV";
        softAssert.assertEquals(driver.findElement(By.xpath("//span[text()='Roman Iovlev']")),
            expectedUsernameLoggined);

        //Open through the header menu Service -> Different Elements Page
        webElement = driver.findElement(By
            .xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@class='dropdown-toggle']"));
        webElement.click();
        webElement = driver.findElement(By.xpath("//a[@href='different-elements.html']"));
        webElement.click();

        //Select checkboxes (Water, Wind)
        webElement = driver.findElement(By.xpath("//label[@class='label-checkbox'][1]"));
        webElement.click();

        webElement = driver.findElement(By.xpath("//label[@class='label-checkbox'][3]"));
        webElement.click();

        //Select radio (Selen)
        webElement = driver.findElement(By.xpath("//label[@class='label-radio'][4]"));
        webElement.click();

        //Select in dropdown (Yellow)
        webElement = driver.findElement(By.xpath("//select[@class='uui-form-element']/option[text()='Yellow']"));
        webElement.click();

        /*
         Assert that
         for each checkbox there is an individual log row and value is corresponded to the status of checkbox
         for radio button there is a log row and value is corresponded to the status of radio button
         for dropdown there is a log row and value is corresponded to the selected value.
         */

        softAssert.assertTrue(driver.findElement(By.xpath("//ul[@class='panel-body-list logs']")).isDisplayed());

        softAssert.assertTrue(driver.findElement(By
            .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Water: condition changed to true')]"))
                                    .isDisplayed());

        String expectedWaterLog = "Water: condition changed to true";
        softAssert.assertEquals(driver.findElement(By
            .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Water: condition changed to true')]")),
            expectedWaterLog);

        softAssert.assertTrue(driver.findElement(By
            .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Wind: condition changed to true')]"))
                                    .isDisplayed());

        String expectedWindLog = "Wind: condition changed to true";
        softAssert.assertEquals(driver.findElement(By
                .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Wind: condition changed to true')]")),
            expectedWindLog);

        softAssert.assertTrue(driver.findElement(By
            .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'metal: value changed to  Selen')]"))
                                    .isDisplayed());

        String expectedMetalLog = "metal: value changed to  Selen";
        softAssert.assertEquals(driver.findElement(By
            .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'metal: value changed to  Selen')]")),
            expectedMetalLog);

        softAssert.assertTrue(driver.findElement(By
            .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Colors: value changed to Yellow')]"))
                                    .isDisplayed());

        String expectedColorsLog = "Colors: value changed to Yellow";
        softAssert.assertEquals(driver.findElement(By
            .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Colors: value changed to Yellow')]")),
            expectedColorsLog);
    }

    //Close Browser
    @AfterClass(alwaysRun = true)
    public void tearDownDriver() {
        driver.close();
    }
}
