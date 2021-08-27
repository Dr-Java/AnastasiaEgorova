package com.epam.tc.hw5.pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage extends AbstractBasePage {

    @FindBy(tagName = "select")
    private List<WebElement> numberTypeDropdowns;

    @FindBy(xpath = "//td/a")
    private List<WebElement> usernames;

    @FindBy(xpath = "//div[@class='user-descr']/span")
    private List<WebElement> descriptionTextsUnderImages;

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(css = "td:nth-child(1)")
    private List<WebElement> numbers;

    @FindBy(xpath = "//a[text()='Roman']/parent::td/preceding-sibling::td/select/option")
    private List<WebElement> droplistForUserRoman;

    @FindBy(xpath = "//input[@id='ivan']")
    private WebElement ivanCheckbox;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li[contains(text(), 'Vip: condition changed to true')]")
    private WebElement vipLogRow;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getNumberTypeDropdowns() {
        return numberTypeDropdowns;
    }

    public List<WebElement> getUsernames() {
        return usernames;
    }

    public List<WebElement> getDescriptionTextsUnderImages() {
        return descriptionTextsUnderImages;
    }

    public List<String> getStringDescriptionTextsUnderImages() {
        return descriptionTextsUnderImages
            .stream()
            .map(description -> description.getText().trim().replaceAll("\n", " "))
            .collect(Collectors.toList());
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getNumbers() {
        return numbers;
    }

    public List<WebElement> getDroplistForUserRoman() {
        return droplistForUserRoman;
    }

    public void selectIvanCheckbox() {
        ivanCheckbox.click();
    }

    public String getVipLogRow() {
        return vipLogRow.getText();
    }
}
