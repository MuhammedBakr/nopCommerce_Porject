package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P02_login;

public class D02_loginStepDef {
    P02_login login= new P02_login();

    @When("user go to login page")
    public void goToLoginPage() {
        login.loginButton().click();
    }

    @And("user login with valid {string} and {string}")
    public void userLoginWithValidAnd(String arg0, String arg1) {
        login.putEmail().sendKeys(arg0);
        login.putPass().sendKeys(arg1);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.clickLoginButton().click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        login.beSureSuccess();
    }

    @And("user login with invalid {string} and {string}")
    public void userLoginWithInvalidAnd(String arg0, String arg1) {
        login.inValidEmail().sendKeys(arg0);
        login.inValidPass().sendKeys(arg1);
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        login.notSuccessS();
    }
}


