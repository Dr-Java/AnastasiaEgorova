package com.epam.tc.egorova.hw5.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class GivenStep extends AbstractBaseStep {

    @Given("I open JDI GitHub site")
    public void openJdiGitHubHomePage() {
        homePage.openSiteHomePage();
    }

    @And("I login as user 'Roman Iovlev'")
    public void performLoginAsUser() {
        homePage.performLogin();
    }

    @And("I open through the header menu Service -> Different Elements Page")
    public void openThroughTheHeaderMenuServiceDifferentElementsPage() {
        var differentElementsPage = homePage.openDifferentElementsPage();
    }
}
