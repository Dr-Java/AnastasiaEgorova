package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.pages.components.AbstractComponent;
import com.epam.tc.hw5.pages.components.HeaderMenuComponent;
import com.epam.tc.hw5.pages.components.LoginFormComponent;
import com.epam.tc.hw5.pages.components.LogsPanelComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractBasePage extends AbstractComponent {

    protected LoginFormComponent loginForm;
    protected HeaderMenuComponent headerMenu;
    protected LogsPanelComponent logsPanel;
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    private static final String SITE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    protected AbstractBasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        loginForm = new LoginFormComponent(driver);
        logsPanel = new LogsPanelComponent(driver);
        headerMenu = new HeaderMenuComponent(driver);
        //homePage = new HomePage(driver);
        //userTablePage = new UserTablePage(driver);
    }

    public void openSite() {
        driver.get(SITE_URL);
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }
}
