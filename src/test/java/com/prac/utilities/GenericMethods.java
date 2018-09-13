package com.prac.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class GenericMethods {

    public static void selectAnItemFromDropdown(WebElement element, String value) {
        new Select(element).selectByVisibleText(value);
    }

    public static void enterTextBoxValue(WebElement element, String value) {
        element.sendKeys(value);
    }

    public static void click(WebElement element) {
        if (element.isEnabled())
            element.click();
        else {
            Assert.assertFalse(true, "Element is disabled");
        }
    }

    public static void waitForElementToAppear(WebDriver driver, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public static boolean isWebElementDisplayOnAPage(WebElement element) {
        return element.isDisplayed();
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public static void clickOnElementWhenClickable(WebDriver driver, WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement page = wait.until(
                elementToBeClickable
                        (element));

        if (element.isEnabled())
            element.click();
        else {
            Assert.assertFalse(true, "Element is disabled");
        }
    }
}
