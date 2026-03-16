package com.flightbooking.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.flightbooking.automation.base.DriverManager;
import com.flightbooking.automation.utils.LoggerUtils;
import com.flightbooking.automation.utils.WaitUtils;
public class BasePage {

    public BasePage() {

        PageFactory.initElements(
                DriverManager.getDriver(), this);
        
    }

    protected void click(WebElement element) {

        WaitUtils.waitForClickable(element);

        LoggerUtils.info(Thread.currentThread().getName()+" Clicking button ");

        element.click();
        
    }

    protected void type(WebElement element, String text) {

        WaitUtils.waitForVisibility(element);

        LoggerUtils.info(Thread.currentThread().getName()+" Typing text: "+text);

        element.clear();
        element.sendKeys(text);
        
    }

    protected String getText(WebElement element) {

        WaitUtils.waitForVisibility(element);

        LoggerUtils.info(Thread.currentThread().getName()+" Getting text from element");

        return element.getText();
        
    }

    protected boolean isDisplayed(WebElement element) {

        WaitUtils.waitForVisibility(element);

        return element.isDisplayed();
        
    }

}