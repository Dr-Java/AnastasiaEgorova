package com.epam.tc.egorova.hw2.ex2;

import com.epam.tc.egorova.hw2.BaseTest;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExerciseTwoTest extends BaseTest {

    private WebElement webElement;
    SoftAssertions softAssert = new SoftAssertions();

    @Test(groups = {"jdiLight"})
    public void testExerciseTwo() {
        //Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        //Assert Browser title
        String browserTitle = driver.getTitle();
        String expectedBrowserTitle = "Home Page";
        softAssert.assertThat(browserTitle)
                  .as("Browser title is incorrect")
                  .isEqualTo(expectedBrowserTitle);

        //Perform login
        webElement = driver.findElement(By.id("user-icon"));
        webElement.click();

        String username = "Roman";
        webElement = driver.findElement(By.id("name"));
        webElement.sendKeys(username);

        String password = "Jdi1234";
        webElement = driver.findElement(By.id("password"));
        webElement.sendKeys(password);

        webElement = driver.findElement(By.id("login-button"));
        webElement.click();

        //Assert User name in the left-top side of screen that user is loggined
        String expectedUsernameLoggined = "ROMAN IOVLEV";
        softAssert.assertThat(driver.findElement(By.id("user-name")).getText())
                  .as("Username is incorrect")
                  .isEqualTo(expectedUsernameLoggined);

        //Open through the header menu Service -> Different Elements Page
        webElement = driver.findElement(By
            .xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@class='dropdown-toggle']"));
        webElement.click();
        webElement = driver.findElement(By.xpath("//a[@href='different-elements.html']"));
        webElement.click();

        //Select checkboxes (Water, Wind)
        webElement = driver.findElement(By.xpath("//label[text()[contains(.,'Water')]]/input"));
        webElement.click();

        webElement = driver.findElement(By.xpath("//label[text()[contains(.,'Wind')]]/input"));
        webElement.click();

        //Select radio (Selen)
        webElement = driver.findElement(By.xpath("//label[text()[contains(.,'Selen')]]/input"));
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

        softAssert.assertThat(driver.findElement(By.xpath("//ul[@class='panel-body-list logs']")).isDisplayed())
                  .as("Log rows are absent");

        softAssert.assertThat(driver.findElement(By
            .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Water: condition changed to true')]"))
                                    .isDisplayed()).as("Water log is not displayed");

        softAssert.assertThat(driver.findElement(By
            .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Wind: condition changed to true')]"))
                                    .isDisplayed())
                  .as("Wind log is not displayed");


        softAssert.assertThat(driver.findElement(By
            .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'metal: value changed to  Selen')]"))
                                    .isDisplayed())
                  .as("Selen log is not displayed");

        softAssert.assertThat(driver.findElement(By
            .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Colors: value changed to Yellow')]"))
                                    .isDisplayed())
                  .as("Yellow color log is not displayed");

        softAssert.assertAll();
    }
}
