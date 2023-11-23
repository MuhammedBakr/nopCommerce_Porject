package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;


public class D07_followUsStepDef {
    P03_homePage homePage = new P03_homePage();

    @When("click on FB")
    public void chooseFB() {
        homePage.selectFacebook().click();
    }

    @Then("validate FB link")
    public void fbOK() {
        homePage.sureFB();
    }

    @When("click on X")
    public void clickOnX() {
        homePage.selectX().click();
    }

    @Then("validate X link")
    public void validateXLink() {
        homePage.sureX();
    }


    @When("click on rss")
    public void clickOnRss() {
        homePage.selectRss().click();
    }

    @Then("validate rss link")
    public void validateRssLink() {
        homePage.sureRSS();
    }

    @When("click on YT")
    public void clickOnYT() {
        homePage.selectYT().click();
    }

    @Then("validate YT link")
    public void validateYTLink() {
        homePage.sureYT();
    }
}
