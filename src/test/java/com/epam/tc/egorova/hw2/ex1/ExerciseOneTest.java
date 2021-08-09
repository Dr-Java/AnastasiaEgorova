package com.epam.tc.egorova.hw2.ex1;

import com.epam.tc.egorova.hw2.BaseTest;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExerciseOneTest extends BaseTest {

    private WebElement webElement;
    SoftAssertions softAssert = new SoftAssertions();

    @Test(groups = {"jdiLight"})
    public void testExerciseOne() {

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

        //Assert Username is loggined
        String expectedUsernameLoggined = "ROMAN IOVLEV";
        softAssert.assertThat(driver.findElement(By.id("user-name")).getText())
                  .as("Username is incorrect")
                  .isEqualTo(expectedUsernameLoggined);

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerItems = driver.findElements(By
            .xpath("//ul[contains(@class, 'm-l8')]/li"));
        int expectedHeaderItemsNumber = 4;
        softAssert.assertThat(headerItems.size())
                  .as("Header items number is incorrect")
                  .isEqualTo(expectedHeaderItemsNumber);
        for (WebElement item : headerItems) {
            softAssert.assertThat(item.isDisplayed())
                      .as("Items are not displayed");
        }

        softAssert.assertThat(driver.findElement(By
            .xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@href='index.html']")).getText())
                  .as("Header item text is incorrect")
                  .isEqualTo("HOME");

        softAssert.assertThat(driver.findElement(By
            .xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@href='contacts.html']")).getText())
                  .as("Header item text is incorrect")
                  .isEqualTo("CONTACT FORM");

        softAssert.assertThat(driver.findElement(By
            .xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@class='dropdown-toggle']")).getText())
                  .as("Header item text is incorrect")
                  .isEqualTo("SERVICE");

        softAssert.assertThat(driver.findElement(By
            .xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@href='metals-colors.html']")).getText())
                  .as("Header item text is incorrect")
                  .isEqualTo("METALS & COLORS");

        //Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> indexImages = driver.findElements(By.className("benefit-icon"));
        int expectedIndexImagesNumber = 4;
        softAssert.assertThat(indexImages.size())
                  .as("Images number is incorrect")
                  .isEqualTo(expectedIndexImagesNumber);
        for (WebElement image : indexImages) {
            softAssert.assertThat(image.isDisplayed()).as("Images are not displayed");
        }

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> indexTextsUnderIcons = driver.findElements(By.xpath("//span[@class='benefit-txt']"));
        int expectedIndexTextsUnderIcons = 4;
        softAssert.assertThat(indexTextsUnderIcons.size())
                  .as("Texts number is incorrect")
                  .isEqualTo(expectedIndexTextsUnderIcons);

        String expectedFirstIndexText = "To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project";
        softAssert.assertThat(driver.findElement(By.xpath("(//span[@class='benefit-txt'])[1]")).getText())
                  .as("Text is incorrect")
                  .isEqualTo(expectedFirstIndexText);

        String expectedSecondIndexText = "To be flexible and\n"
            + "customizable";
        softAssert.assertThat(driver.findElement(By.xpath("(//span[@class='benefit-txt'])[2]")).getText())
                  .as("Text is incorrect").isEqualTo(expectedSecondIndexText);

        String expectedThirdIndexText = "To be multiplatform";
        softAssert.assertThat(driver.findElement(By.xpath("(//span[@class='benefit-txt'])[3]")).getText())
                  .as("Text is incorrect")
                  .isEqualTo(expectedThirdIndexText);

        String expectedFourthIndexText = "Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…";
        softAssert.assertThat(driver.findElement(By.xpath("(//span[@class='benefit-txt'])[4]")).getText())
                  .as("Text is incorrect").isEqualTo(expectedFourthIndexText);

        //Assert that there is the iframe with “Frame Button” exist
        softAssert.assertThat(driver.findElement(By.xpath("//iframe[@id='frame']")).isDisplayed())
                  .as("Iframe with 'Frame Button' does not exist");

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        webElement = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(webElement);
        softAssert.assertThat(driver.findElement(By.xpath("//input[@class='btn btn-info']")).isDisplayed())
                  .as("There is no 'Frame Button' in the iframe");

        //Switch to original window back
        driver.switchTo().defaultContent();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSectionItems = driver.findElements(By
            .xpath("//ul[contains(@class,'left')]/li/a"));
        int expectedLeftSectionItems = 5;
        softAssert.assertThat(leftSectionItems.size())
                  .as("Left Section items number is incorrect")
                  .isEqualTo(expectedLeftSectionItems);
        for (WebElement item : leftSectionItems) {
            softAssert.assertThat(item.isDisplayed())
                      .as("Left Section items are not displayed");
        }

        softAssert.assertThat(driver.findElement(By
            .xpath("//ul[@class='sidebar-menu left']//a[@href='index.html']")).getText())
                  .as("Text is incorrect")
                  .isEqualTo("Home");

        softAssert.assertThat(driver.findElement(By
            .xpath("//ul[@class='sidebar-menu left']//a[@href='contacts.html']")).getText())
                  .as("Text is incorrect")
                  .isEqualTo("Contact form");

        softAssert.assertThat(driver.findElement(By
            .xpath("//ul[@class='sidebar-menu left']//span[text()='Service']")).getText())
                  .as("Text is incorrect")
                  .isEqualTo("Service");

        softAssert.assertThat(driver.findElement(By
            .xpath("//ul[@class='sidebar-menu left']//a[@href='metals-colors.html']")).getText())
                  .as("Text is incorrect")
                  .isEqualTo("Metals & Colors");

        softAssert.assertThat(driver.findElement(By
            .xpath("//ul[@class='sidebar-menu left']//span[text()='Elements packs']")).getText())
                  .as("Text is incorrect")
                  .isEqualTo("Elements packs");

        softAssert.assertAll();
    }
}
