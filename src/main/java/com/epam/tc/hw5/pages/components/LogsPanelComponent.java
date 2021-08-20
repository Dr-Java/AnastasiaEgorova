package com.epam.tc.hw5.pages.components;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogsPanelComponent extends AbstractComponent {

    @FindBy(xpath = "//li[text()[contains(.,'%s: %s changed to %s')]]")
    private List<WebElement> logRows;

    public LogsPanelComponent(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getLogRows() {
        return logRows;
    }
}
