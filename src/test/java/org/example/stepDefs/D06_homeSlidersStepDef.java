package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;

public class D06_homeSlidersStepDef {
    P03_homePage homePage = new P03_homePage();

    @When("click on nokia phone")
    public void nokiaSlider(){
        homePage.slider().get(1).click();
    }

    @Then("go to nokia page")
    public void goToNokiaPage() {
        homePage.expectedNokia();
    }

    @When("click on iphone phone")
    public void iphoneSlider() {
        homePage.slider().get(0).click();
    }

    @Then("go to iphone page")
    public void goToIphonePage() {
        homePage.expectedIphone();
    }
}
