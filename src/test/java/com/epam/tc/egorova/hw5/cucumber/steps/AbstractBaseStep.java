package com.epam.tc.egorova.hw5.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.egorova.hw5.cucumber.context.TestContext;
import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.HomePage;
import com.epam.tc.hw5.pages.UserTablePage;
import com.epam.tc.hw5.pages.components.HeaderMenuComponent;
import com.epam.tc.hw5.pages.components.LoginFormComponent;
import com.epam.tc.hw5.pages.components.LogsPanelComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractBaseStep {

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;
    protected LoginFormComponent loginForm;
    protected HeaderMenuComponent headerMenu;
    protected LogsPanelComponent logsPanel;

    public AbstractBaseStep() {
        WebDriver driver = TestContext.getInstance().getDriver();
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
        loginForm = new LoginFormComponent(driver);
        headerMenu = new HeaderMenuComponent(driver);
        logsPanel = new LogsPanelComponent(driver);
    }

    public void isElementDisplayed(WebElement element) {
        assertThat(element.isDisplayed())
            .as("Element is not displayed");
    }
}
