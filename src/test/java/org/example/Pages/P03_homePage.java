package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static dtos.Resources.*;
import static org.example.stepDefs.Hooks.driver;

public class P03_homePage {
    //Elements
    private final By selectDD = By.id("customerCurrency");
    private final By sign = By.cssSelector("*[class='price actual-price']");
    private final By searchbar = By.cssSelector("*[placeholder='Search store']");
    private final By click = By.cssSelector("*[class='button-1 search-box-button']");
    private final By size_of_search = By.cssSelector("div[class='search-results'] h2[class='product-title']");
    private final By firstSearch = By.cssSelector("div div[class='picture']");
    private final By skuDisplay = By.cssSelector("*[class='label']");
    private final By skuValue = By.cssSelector("div[class='sku'] span[class='value']");
    private final By categoryMenu = By.xpath("//ul[@class=\"top-menu notmobile\"]/li");
    private final By subCategoryName = By.cssSelector("*[class='page-title']");

    public String actualArg0;
    public String valueArg1;
    private final By sliderSelect = By.cssSelector("*[class='nivo-imageLink']");
    private final By facebook = By.cssSelector("*[class='facebook']");
    private final By twitter = By.cssSelector("*[class='twitter']");
    private final By rss = By.cssSelector("*[class='rss']");
    private final By youtube = By.cssSelector("*[class='youtube']");
    private final By wishList = By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]");
    private final By wishMessage = By.cssSelector("*[class='bar-notification success']");
    private final By wishlistCategory = By.cssSelector("*[class='wishlist-label']");
    private final By qtyResult = By.cssSelector("*[class='qty-input']");

    // Actions
    public void dropDown() {
        Select currency = new Select(driver.findElement(selectDD));
        currency.selectByVisibleText("Euro");
    }

    public void theEuroSign() {
        int product_size = driver.findElements(sign).size();
        for (int i = 0; i < product_size; i++) {
            System.out.println(driver.findElements(sign).get(i).getText());
            Assert.assertTrue(driver.findElements(sign).get(i).getText().toLowerCase().contains(expectedSign));
        }


    }

    public WebElement putinSearch() {
        return driver.findElement(searchbar);
    }

    public WebElement click_Search() {
        return driver.findElement(click);
    }

    public void the_test_sure() {
        int search_size = driver.findElements(size_of_search).size();
        for (int o = 0; o < search_size; o++) {
            System.out.println(driver.findElements(size_of_search).get(o).getText().toLowerCase());
            actualArg0 = driver.findElements(size_of_search).get(o).getText().toLowerCase();
        }
    }


    public void selectProduct1() {
        SoftAssert softAssert = new SoftAssert();
        driver.findElement(firstSearch).click();
        valueArg1 = driver.findElement(skuValue).getText().toUpperCase();
        softAssert.assertTrue(driver.findElement(skuDisplay).isDisplayed());

    }

    public void selectionStep() {
        int categorySize = driver.findElements(categoryMenu).size();
        for (int y = 0; y < categorySize; y++) {
            System.out.println(driver.findElements(categoryMenu).get(y).getText());
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(driver.findElements(categoryMenu).get(y).isDisplayed());
        }
    }

    public void chooseRandomCategory() {
        Actions actions = new Actions(driver);
        List<WebElement> mainLinks = driver.findElements(categoryMenu);
        int count = mainLinks.size();
        System.out.println("count is " + count);
        int min = 0;
        int max = count - 1;
        int selectedCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
        actions.moveToElement(mainLinks.get(selectedCategory)).perform();
        String selectedCategoryText = mainLinks.get(selectedCategory).getText();
        System.out.println("to know which category is selected:   " + selectedCategoryText);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        selectedCategory = selectedCategory + 1;
        String locator = "(//ul[@class='top-menu notmobile']//ul)[" + selectedCategory + "]/li";
        List<WebElement> subCategoryLinks = driver.findElements(By.xpath(locator));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String selectedSubCategoryText;
        if (!subCategoryLinks.isEmpty()) {
            int subCategoryCount = subCategoryLinks.size();
            System.out.println("profile links " + subCategoryCount);
            System.out.println(subCategoryLinks.get(0).getText());
            System.out.println(subCategoryLinks.get(1).getText());
            System.out.println(subCategoryLinks.get(2).getText());
            int selectedSubCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
            selectedSubCategoryText = subCategoryLinks.get(selectedSubCategory).getText();
            subCategoryLinks.get(selectedSubCategory).click();
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(selectedSubCategoryText, driver.findElement(subCategoryName).getText());
            softAssert.assertAll();
        } else {
            mainLinks.get(selectedCategory).click();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }


    public List<WebElement> slider() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        return driver.findElements(sliderSelect);
    }

    public void expectedIphone() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(), actualIphoneUrl);
    }

    public void expectedNokia() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(), actualNokia);
    }

    public WebElement selectFacebook() {
        return driver.findElement(facebook);
    }

    public void sureFB() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1:  " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), actualFB);
    }

    public WebElement selectX() {
        return driver.findElement(twitter);
    }

    public void sureX() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1:  " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), actualX);
    }

    public WebElement selectRss() {
        return driver.findElement(rss);
    }

    public void sureRSS() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1:  " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), actualRss);
    }

    public WebElement selectYT() {
        return driver.findElement(youtube);
    }

    public void sureYT() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1:  " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), actualYT);


    }

    public WebElement clickWishList() {
        return driver.findElement(wishList);
    }

    public void messageDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(wishMessage).isDisplayed());
        String actualColour = driver.findElement(wishMessage).getCssValue("background-color");
        String hexConvert = Color.fromString(actualColour).asHex().toLowerCase();
        System.out.println(actualColour);
        System.out.println(hexConvert);
    }
    public void clickOnWishList(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(wishMessage)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(wishlistCategory)));
        driver.findElement(wishlistCategory).click();
    }
    public void qty(){
        String qtyValue = driver.findElement(qtyResult).getAttribute("value");
        int countQty = Integer.parseInt(qtyValue);
        Assert.assertTrue(countQty>0);
        System.out.println(countQty);
        System.out.println("Thank You Moustafa Ismail ❤❤❤❤");

    }

}














