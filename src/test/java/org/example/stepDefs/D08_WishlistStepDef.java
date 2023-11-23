package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;

public class D08_WishlistStepDef {
    P03_homePage homePage = new P03_homePage();
    @When("click on ❤ HTC")
    public void clickOnHtcProduct(){
        homePage.clickWishList().click();
    }

    @Then("Validate the message was appear")
    public void validateTheMessageWasAppear() {
        homePage.messageDisplayed();
    }

    @When("success message gone click on Wishlist")
    public void successMessageGoneClickOnWishlist() {
        homePage.clickWishList().click();
        homePage.messageDisplayed();
        homePage.clickOnWishList();

    }

    @Then("get Qty Value")
    public void getQtyValue() {
        homePage.qty();
    }
}
