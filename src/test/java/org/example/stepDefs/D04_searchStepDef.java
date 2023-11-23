package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {
    P03_homePage homePage = new P03_homePage();

    @When("user could search using product name {string}")
    public void userCouldSearchUsingProductName(String arg0) {
        homePage.putinSearch().sendKeys(arg0);
        homePage.click_Search().click();
    }

    @Then("validate for success search {string}")
    public void validateForSuccessSearch(String arg0) {
        SoftAssert softAssert = new SoftAssert();
        homePage.the_test_sure();
        softAssert.assertTrue(homePage.actualArg0.contains(arg0));

    }


    @When("user could search using product serialNumber {string}")
    public void userCouldSearchUsingProductSerialNumber(String arg1) {
        homePage.putinSearch().sendKeys(arg1);
        homePage.click_Search().click();

    }

    @Then("validate for success search with sku {string}")
    public void validateForSuccessSearchWithSku(String arg1) {
        SoftAssert softAssert = new SoftAssert();
        homePage.selectProduct1();
        softAssert.assertEquals(homePage.valueArg1,arg1);
    }
}
