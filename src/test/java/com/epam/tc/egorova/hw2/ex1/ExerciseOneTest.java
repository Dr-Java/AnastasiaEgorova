package com.epam.tc.egorova.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ExerciseOneTest {

    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private WebElement webElement;
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass(alwaysRun = true)
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(groups = {"jdiLight"})
    public void testExerciseOne() {
        //Open test site by URL
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

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

        //Assert Username is loggined
        String expectedUsernameLoggined = "ROMAN IOVLEV";
        softAssert.assertEquals(driver.findElement(By.xpath("//span[text()='Roman Iovlev']")),
            expectedUsernameLoggined);

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerItems = driver.findElements(By
            .xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']"));
        int expectedHeaderItemsNumber = 4;
        softAssert.assertEquals(headerItems.size(), expectedHeaderItemsNumber);
        for (WebElement item : headerItems) {
            softAssert.assertTrue(item.isDisplayed());
        }

        softAssert.assertEquals(driver.findElement(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@href='index.html']"))
                                      .getText(), "HOME");
        softAssert.assertEquals(driver.findElement(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@href='contacts.html']"))
                                      .getText(), "CONTACT FORM");
        softAssert.assertEquals(driver.findElement(By
            .xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@class='dropdown-toggle']"))
                                      .getText(), "SERVICE");
        softAssert.assertEquals(driver.findElement(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@href='metals-colors.html']"))
                                      .getText(), "METALS & COLORS");

        //Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> indexImages = driver.findElements(By.xpath("//div[@class='main-content']"));
        int expectedIndexImagesNumber = 4;
        softAssert.assertEquals(indexImages.size(), expectedIndexImagesNumber);
        for (WebElement image : indexImages) {
            softAssert.assertTrue(image.isDisplayed());
        }

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> indexTextsUnderIcons = driver.findElements(By.xpath("//span[@class='benefit-txt']"));
        int expectedIndexTextsUnderIcons = 4;
        softAssert.assertEquals(indexTextsUnderIcons.size(), expectedIndexTextsUnderIcons);

        String expectedFirstIndexText = "To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project";
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class='benefit-txt'])[1]")).getText(),
            expectedFirstIndexText);

        String expectedSecondIndexText = "To be flexible and\n"
            + "customizable";
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class='benefit-txt'])[2]")).getText(),
            expectedSecondIndexText);

        String expectedThirdIndexText = "To be multiplatform";
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class='benefit-txt'])[3]")).getText(),
            expectedThirdIndexText);

        String expectedFourthIndexText = "Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…";
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class='benefit-txt'])[4]")).getText(),
            expectedFourthIndexText);

        //Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(driver.findElement(By.xpath("//iframe[@id='frame']")).isDisplayed());

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        webElement = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(webElement);
        softAssert.assertTrue(driver.findElement(By.xpath("//input[@class='btn btn-info']")).isDisplayed());

        //Switch to original window back
        driver.switchTo().defaultContent();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSectionItems = driver.findElements(By.xpath("//ul[@class='sidebar-menu left']"));
        int expectedLeftSectionItems = 5;
        softAssert.assertEquals(leftSectionItems.size(), expectedLeftSectionItems);
        for (WebElement item : leftSectionItems) {
            softAssert.assertTrue(item.isDisplayed());
        }

        softAssert.assertEquals(driver.findElement(By.xpath("//ul[@class='sidebar-menu left']//a[@href='index.html']"))
                                      .getText(), "Home");
        softAssert.assertEquals(driver.findElement(By.xpath("//ul[@class='sidebar-menu left']//a[@href='contacts.html']"))
                                      .getText(), "Contact form");
        softAssert.assertEquals(driver.findElement(By.xpath("//ul[@class='sidebar-menu left']//span[text()='Service']"))
                                      .getText(), "Service");
        softAssert.assertEquals(driver.findElement(By.xpath("//ul[@class='sidebar-menu left']//a[@href='metals-colors.html']"))
                                      .getText(), "Metals & Colors");
        softAssert.assertEquals(driver.findElement(By
            .xpath("//ul[@class='sidebar-menu left']//span[text()='Elements packs']"))
                                      .getText(), "Elements packs");
    }

    //Close Browser
    @AfterClass(alwaysRun = true)
    public void tearDownDriver() {
        driver.close();
    }
}
