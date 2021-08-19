package com.epam.tc.egorova.hw4.teststeps;

import com.epam.tc.hw4.pages.HomePage;
import io.qameta.allure.Step;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePageTestSteps {

    private HomePage homePage;
    SoftAssertions softAssert = new SoftAssertions();

    public HomePageTestSteps(WebDriver driver) {
        homePage = new HomePage(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Assert Browser title")
    public void assertBrowserTitle(String browserTitle) {
        softAssert.assertThat(homePage.getBrowserTitle())
                  .as("Browser title is incorrect")
                  .isEqualTo(browserTitle);
    }

    @Step("Perform login")
    public void performLogin(String username, String password) {
        homePage.login(username, password);
    }

    @Step("Assert Username is loggined")
    public void assertUsernameLoggined(String username) {
        softAssert.assertThat(homePage.getLogginedUsername())
                  .as("Incorrect username").isEqualTo(username);
    }

    @Step("Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assertFourHeaderItemsHaveProperTexts() {
        List<WebElement> headerItems = homePage.getHeaderItems();

        int expectedHeaderItemsNumber = 4;
        softAssert.assertThat(headerItems.size())
                  .as("Incorrect texts number")
                  .isEqualTo(expectedHeaderItemsNumber);

        List<String> expectedHeaderItems = List
            .of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
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

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
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

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void assertFourTextsUnderIconsHaveProperText() {
        List<WebElement> indexTextsUnderIcons = homePage.getIndexTextsUnderIcons();

        int expectedIndexTextsUnderIconsNumber = 4;
        softAssert.assertThat(indexTextsUnderIcons.size())
                  .as("Texts number is incorrect")
                  .isEqualTo(expectedIndexTextsUnderIconsNumber);

        List<String> expectedIndexTextsUnderIcons = List
            .of("To include good practices\n"
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

    @Step("Assert that there is the iframe with 'Frame Button' exist")
    public void assertIFrameWithFrameButtonExists() {
        softAssert.assertThat(homePage.getiFrameWithFrameButton().isDisplayed());
    }

    @Step("Switch to the iframe and check that there is 'Frame Button' in the iframe")
    public void switchToIFrameAndCheckFrameButtonDisplayed() {
        homePage.switchToIFrame();
        softAssert.assertThat(homePage.getFrameButton().isDisplayed())
                  .as("Frame Button is not displayed");
    }

    @Step("Switch to original window back")
    public void switchToOriginalWindow() {
        homePage.switchToOriginalWindow();
    }

    @Step("Assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void assertFiveLeftSectionItemsHaveProperText() {
        List<WebElement> leftSectionItems = homePage.getLeftSectionItems();

        int expectedLeftSectionItemsNumber = 5;
        softAssert.assertThat(leftSectionItems.size())
                  .as("Left Section items number is incorrect")
                  .isEqualTo(expectedLeftSectionItemsNumber);

        List<String> expectedLeftSectionItems = List
            .of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

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

