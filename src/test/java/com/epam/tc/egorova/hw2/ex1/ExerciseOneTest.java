package com.epam.tc.egorova.hw2.ex1;

import com.epam.tc.egorova.hw2.BaseTest;
import java.util.Arrays;
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

        List<String> expectedHeaderItems = Arrays
            .asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        for (WebElement item : headerItems) {
            softAssert.assertThat(item.isDisplayed())
                      .as("Items are not displayed");
        }

        for (int i = 0; i < headerItems.size(); i++) {
            softAssert.assertThat(headerItems.get(i).getText())
                      .as("Header item text is incorrect")
                      .isEqualTo(expectedHeaderItems.get(i));
        }

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

        int expectedIndexTextsUnderIconsNumber = 4;
        softAssert.assertThat(indexTextsUnderIcons.size())
                  .as("Texts number is incorrect")
                  .isEqualTo(expectedIndexTextsUnderIconsNumber);

        List<String> expectedIndexTextsUnderIcons = Arrays
            .asList("To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project", "To be flexible and\n"
                + "customizable", "To be multiplatform", "Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…");

        for (int i = 0; i < indexTextsUnderIcons.size(); i++) {
            softAssert.assertThat(indexTextsUnderIcons.get(i).getText())
                      .as("Text is incorrect")
                      .isEqualTo(expectedIndexTextsUnderIcons.get(i));
        }

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

        int expectedLeftSectionItemsNumber = 5;
        softAssert.assertThat(leftSectionItems.size())
                  .as("Left Section items number is incorrect")
                  .isEqualTo(expectedLeftSectionItemsNumber);

        List<String> expectedLeftSectionItems = Arrays
            .asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

        for (WebElement item : leftSectionItems) {
            softAssert.assertThat(item.isDisplayed())
                      .as("Left Section items are not displayed");
        }

        for (int i = 0; i < leftSectionItems.size(); i++) {
            softAssert.assertThat(leftSectionItems.get(i).getText())
                      .as("Text is incorrect")
                      .isEqualTo(expectedLeftSectionItems.get(i));
        }

        softAssert.assertAll();
    }
}
