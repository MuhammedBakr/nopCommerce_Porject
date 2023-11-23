package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;
import static dtos.Resources.expectedUrl;



public class P02_login {
    // Elements
    private final By clickLoginButton = By.cssSelector("*[class='ico-login']");
    private final By emailField = By.id("Email");
    private final By passField = By.id("Password");
    private final By tabLogin = By.cssSelector("*[class='button-1 login-button']");
    private final By myAccount = By.cssSelector("*[href='/customer/info']");
    private final By unSuccessful = By.cssSelector("*[class='message-error validation-summary-errors']");

    // Actions
    public WebElement loginButton() {
        return driver.findElement(clickLoginButton);
    }
    public WebElement putEmail() {
        return driver.findElement(emailField);
    }
    public WebElement putPass() {
        return driver.findElement(passField);
    }
    public WebElement clickLoginButton(){
        return driver.findElement(tabLogin);
    }
    public void beSureSuccess (){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(),expectedUrl);
        softAssert.assertTrue(driver.findElement(myAccount).isDisplayed());
        softAssert.assertAll();

    }
    public WebElement inValidEmail(){
        return driver.findElement(emailField);
    }
    public WebElement inValidPass(){
        return driver.findElement(passField);
    }
    public void notSuccessS(){
        String colour = driver.findElement(unSuccessful).getCssValue("color");
        String hexColour = Color.fromString(colour).asHex().toLowerCase();
        SoftAssert bakr = new SoftAssert();
        String x =driver.findElement(unSuccessful).getText();
        bakr.assertTrue(x.contains("Login was unsuccessful"));
        bakr.assertEquals(hexColour,"#e4434b");
        bakr.assertAll();
        System.out.println(hexColour);
    }
}
