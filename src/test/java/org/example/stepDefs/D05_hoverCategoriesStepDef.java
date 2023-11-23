package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;

public class D05_hoverCategoriesStepDef {
    P03_homePage homePage = new P03_homePage();

    @When("make sure categories is displayed")
    public void make_Sure_Categories_Is_Displayed() {
        homePage.selectionStep();
    }


    @Then("choose randomly sub category")
    public void choose_Randomly_Sub_Category() {
        homePage.chooseRandomCategory();
    }


}
