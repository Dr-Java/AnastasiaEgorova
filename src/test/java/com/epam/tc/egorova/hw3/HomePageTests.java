package com.epam.tc.egorova.hw3;

import com.epam.tc.hw3.pages.HomePage;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePageTests {

    private HomePage homePage;
    SoftAssertions softAssert = new SoftAssertions();

    public HomePageTests(WebDriver driver) {
        homePage = new HomePage(driver);
        PageFactory.initElements(driver, this);
    }

    public void assertBrowserTitle(String browserTitle) {
        softAssert.assertThat(homePage.getBrowserTitle())
                  .as("Browser title is incorrect")
                  .isEqualTo(browserTitle);
    }

    public void performLogin(String username, String password) {
        homePage.login(username, password);
    }

    public void assertUsernameLoggined(String username) {
        softAssert.assertThat(homePage.getLogginedUsername())
                 .as("Incorrect username").isEqualTo(username);
    }

    public void assertFourHeaderItemsHaveProperTexts() {
        List<WebElement> headerItems = homePage.getHeaderItems();

        int expectedHeaderItemsNumber = 4;
        softAssert.assertThat(headerItems.size())
                  .as("Incorrect texts number")
                  .isEqualTo(expectedHeaderItemsNumber);

        List<String> expectedHeaderItems = Arrays
            .asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        for (WebElement item : headerItems) {
            softAssert.assertThat(item.isDisplayed())
                      .as("Items are not displayed");
        }
        for (int i = 0; i < headerItems.size(); i++) {
            softAssert.assertThat(headerItems.get(i).getText())
                      .as("Text is incorrect")
                      .isEqualTo(expectedHeaderItems.get(i));
        }
        softAssert.assertAll();
    }

    public void assertFourIndexPageImagesDisplayed() {
        List<WebElement> indexImages = homePage.getIndexImages();

        int expectedIndexImagesNumber = 4;
        softAssert.assertThat(indexImages.size())
                  .as("Images number is incorrect")
                  .isEqualTo(expectedIndexImagesNumber);

        for (WebElement image : indexImages) {
            softAssert.assertThat(image.isDisplayed())
                      .as("Images are not displayed");
        }
        softAssert.assertAll();
    }

    public void assertFourTextsUnderIconsHaveProperText() {
        List<WebElement> indexTextsUnderIcons = homePage.getIndexTextsUnderIcons();

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
        softAssert.assertAll();
    }

    public void assertIFrameWithFrameButtonExists() {
        softAssert.assertThat(homePage.getiFrameWithFrameButton().isDisplayed());
    }

    public void switchToIFrameAndCheckFrameButtonDisplayed() {
        homePage.switchToIFrame();
        softAssert.assertThat(homePage.getFrameButton().isDisplayed())
                  .as("Frame Button is not displayed");
    }

    public void switchToOriginalWindow() {
        homePage.switchToOriginalWindow();
    }

    public void assertFiveLeftSectionItemsHaveProperText() {
        List<WebElement> leftSectionItems = homePage.getLeftSectionItems();

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

    public void clickServiceMenuItem() {
        homePage.clickServiceMenuItem();
    }

    public void clickDifferentElementsItem() {
        homePage.clickDifferentElementsItem();
    }
}
