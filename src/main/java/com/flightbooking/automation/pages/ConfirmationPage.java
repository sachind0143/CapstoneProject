package com.flightbooking.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.flightbooking.automation.utils.LoggerUtils;

public class ConfirmationPage extends BasePage {

    @FindBy(tagName = "h1")
    WebElement confirmationMessage;

    public String getConfirmationMessage() {

        LoggerUtils.info(Thread.currentThread().getName()+"Fetching booking confirmation message");

        return getText(confirmationMessage);
    }

    public boolean verifyBookingSuccess() {

        LoggerUtils.info(Thread.currentThread().getName()+"Verifying booking confirmation");

        return isDisplayed(confirmationMessage);
    }
}