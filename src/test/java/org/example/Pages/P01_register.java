package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class P01_register {
    // Elements
    private final By clickRegisterButton = By.cssSelector("*[class='ico-register']");
    private final By clickGenderMale = By.id("gender-male");
    private final By putFirstName = By.id("FirstName");
    private final By putLastName = By.id("LastName");

    private final By chooseDay = By.cssSelector("*[name='DateOfBirthDay']");
    private final By chooseMonth = By.cssSelector("*[name='DateOfBirthMonth']");
    private final By chooseYear = By.cssSelector("*[name='DateOfBirthYear']");
    private final By putEmail = By.id("Email");
    private final By putPassword = By.id("Password");
    private final By confirmPassword = By.id("ConfirmPassword");
    private final By tabRegister = By.id("register-button");
    public static final By resultMessage = By.cssSelector("*[class='result']");


    // Actions
    public WebElement registerLink() {
        return driver.findElement(clickRegisterButton);
    }

    public WebElement selectGenderMale() {
        return driver.findElement(clickGenderMale);
    }

    public WebElement enterFirstName() {
        return driver.findElement(putFirstName);
    }

    public WebElement enterLastName() {
        return driver.findElement(putLastName);
    }

    public void enterDay() {
        Select day = new Select(driver.findElement(chooseDay));
        day.selectByValue("0");
    }

    public void enterMonth() {
        Select month = new Select(driver.findElement(chooseMonth));
        month.selectByValue("0");
    }

    public void enterYear() {
        Select year = new Select(driver.findElement(chooseYear));
        year.selectByValue("1998");
    }

    public WebElement enterEmail() {
        return driver.findElement(putEmail);
    }

    public WebElement enterPassword() {
        return driver.findElement(putPassword);
    }

    public WebElement enterConfirmation() {
        return driver.findElement(confirmPassword);
    }

    public WebElement clickRegestier() {
        return driver.findElement(tabRegister);
    }

    public void messageSuccess() {
        String name = driver.findElement(resultMessage).getText();
        String actualColour = driver.findElement(resultMessage).getCssValue("color");
        String hexColour = Color.fromString(actualColour).asHex().toUpperCase();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(name, "Your registration completed");
        softAssert.assertEquals(hexColour, "#4CB17C");
        softAssert.assertAll();
        System.out.println(name);
        System.out.println(hexColour);
        System.out.println(actualColour);
    }


}
