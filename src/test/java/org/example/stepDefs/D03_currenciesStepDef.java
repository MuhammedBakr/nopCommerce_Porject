package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;

public class D03_currenciesStepDef {
    P03_homePage homePage = new P03_homePage();
    @When("Select Euro currency from the dropdown list on the top left of home page")
    public void selectEuroCurrency() {
        homePage.dropDown();

    }

    @Then("products displayed in Home page")
    public void productsDisplayedInHomePage() {
        homePage.theEuroSign();
    }
}
