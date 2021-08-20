package com.epam.tc.egorova.hw5.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ActionStep extends AbstractBaseStep {

    @When("I select checkboxes")
    public void selectCheckboxes() {
        differentElementsPage.clickWaterCheckbox();
        differentElementsPage.clickWindCheckbox();
    }

    @When("I select 'Selen' radiobutton")
    public void selectRadiobutton() {
        differentElementsPage.clickSelenRadioButton();
    }

    @When("I select 'Yellow' in dropdown")
    public void selectYellowInDropdown() {
        differentElementsPage.clickYellowColorDropdownItem();
    }

    @When("I click on 'Service' button in Header")
    public void clickOnServiceButtonInHeader() {
        homePage.clickOnServiceButton();
    }

    @And("I click on 'User Table' button in Service dropdown")
    public void clickOnUserTableButtonInServiceDropdown() {
        var userTablePage = homePage.clickUserTableButton();
    }

    @When("I select 'vip' checkbox for 'Sergey Ivan'")
    public void selectVipCheckboxForSergeyIvan() {
        userTablePage.selectIvanCheckbox();
    }
}
