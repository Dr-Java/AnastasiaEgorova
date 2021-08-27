package com.epam.tc.egorova.hw5.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.utils.UserProperties;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

public class AssertionStep extends AbstractBaseStep {

    @Then("user 'Roman Iovlev' should be loggined")
    public void userShouldBeLoggined() {
        assertThat(homePage.getLogginedUsername())
            .as("Incorrect username")
            .isEqualTo(UserProperties.getExpectedUsername());
    }

    @Then("Different Elements Page should be opened")
    public void differentElementsPageShouldBeOpened() {
        assertThat(differentElementsPage.getBrowserTitle())
            .as("Title is incorrect")
            .isEqualTo("Different Elements");
    }

    @Then("'Water' and 'Wind' elements should be checked")
    public void checkboxElementsShouldBeChecked() {
        assertThat(differentElementsPage.waterCheckBoxIsSelected())
            .as("Water checkbox is not checked");
        assertThat(differentElementsPage.windCheckBoxIsSelected())
            .as("Wind checkbox is not checked");
    }

    @Then("'Selen' element should be checked")
    public void selenElementsShouldBeChecked() {
        assertThat(differentElementsPage.selenRadioIsSelected())
            .as("Selen radiobutton is not checked");
    }

    @Then("'Yellow' element should be selected")
    public void yellowElementsShouldBeChecked() {
        assertThat(differentElementsPage.yellowInDropdownIsSelected())
            .as("Yellow element is not selected");
    }

    @And("Log rows should be displayed")
    public void logRowsShouldBeDisplayed() {
        SoftAssertions softAssert = new SoftAssertions();
        List<WebElement> logRows = differentElementsPage.getLogRowText();
        List<String> expectedTexts = List.of(
            "value changed to Yellow",
            "value changed to Selen",
            "condition changed to true",
            "condition changed to true");
        for (WebElement element : logRows) {
            assertThat(element.isDisplayed())
                .as("Log rows are not displayed");
        }
        for (int i = 0; i < logRows.size(); i++) {
            assertThat(logRows.get(i).getText())
                .as("Incorrect logs")
                .isEqualTo(expectedTexts.get(i));
        }
        softAssert.assertAll();
    }

    @Then("{string} page should be opened")
    public void userTablePageShouldBeOpened(String expectedTitle) {
        assertThat(userTablePage.getBrowserTitle())
            .as("Title is incorrect")
            .isEqualTo(expectedTitle);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayedOnUsersTablePage(int expectedNumber) {
        assertThat(userTablePage.getNumberTypeDropdowns())
            .as("Incorrect number")
            .hasSize(expectedNumber);
        for (int i = 0; i < userTablePage.getNumberTypeDropdowns().size(); i++) {
            isElementDisplayed(userTablePage.getNumberTypeDropdowns().get(i));
        }
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedOnUserTablePage(int expectedNumber) {
        assertThat(userTablePage.getUsernames())
            .as("Incorrect number")
            .hasSize(expectedNumber);
        for (int i = 0; i < userTablePage.getUsernames().size(); i++) {
            isElementDisplayed(userTablePage.getUsernames().get(i));
        }
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUserTablePage(int expectedNumber) {
        assertThat(userTablePage.getDescriptionTextsUnderImages())
            .as("Incorrect number")
            .hasSize(expectedNumber);
        for (int i = 0; i < userTablePage.getDescriptionTextsUnderImages().size(); i++) {
            isElementDisplayed(userTablePage.getDescriptionTextsUnderImages().get(i));
        }
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUserTablePage(int expectedNumber) {
        assertThat(userTablePage.getCheckboxes())
            .as("Incorrect number")
            .hasSize(expectedNumber);
        for (int i = 0; i < userTablePage.getCheckboxes().size(); i++) {
            isElementDisplayed(userTablePage.getCheckboxes().get(i));
        }
    }

    @Then("User table should contain following values:")
    public void userTableShouldContainFollowingValues(DataTable table) {
        List<Map<String, String>> expectedValues = table.asMaps(String.class, String.class);
        for (int i = 0; i < expectedValues.size(); i++) {
            assertThat(userTablePage.getNumbers().get(i).getText())
                .as("Incorrect value")
                .isEqualTo(expectedValues.get(i).get("Number"));

            assertThat(userTablePage.getUsernames().get(i).getText())
                .as("Incorrect value")
                .isEqualTo(expectedValues.get(i).get("User"));

            assertThat(userTablePage.getStringDescriptionTextsUnderImages().get(i))
                .as("Incorrect value")
                .isEqualTo(expectedValues.get(i).get("Description"));
        }
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesInColumnTypeForUserRoman(DataTable table) {
        List<String> expectedValues = table.asList().subList(1, 4);
        for (int i = 0; i < expectedValues.size(); i++) {
            assertThat(userTablePage.getDroplistForUserRoman().get(i).getText())
                .as("Incorrect value")
                .isEqualTo(expectedValues.get(i));
        }
    }

    @Then("1 log row has {string} text in the row section")
    public void logRowHasProperTextInRowSection(String expectedRow) {
        assertThat(userTablePage.getVipLogRow())
            .as("Incorrect log text")
            .containsOnlyOnce(expectedRow);
    }
}
