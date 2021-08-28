package com.epam.tc.egorova.hw7jdi.tests;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7jdi.JdiSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestInit {

    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        PageFactory.initSite(JdiSite.class);
        JdiSite.open();
    }

    @AfterSuite(alwaysRun = true)
    static void tearDown() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
