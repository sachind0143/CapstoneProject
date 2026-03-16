package com.flightbooking.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.flightbooking.automation.utils.LoggerUtils;

public class TravelTheWorldPage extends BasePage {

	@FindBy(name = "fromPort")
    WebElement departure;

    @FindBy(name = "toPort")
    WebElement destination;

    @FindBy(css = "input[type='submit']")
    WebElement findFlights;

    public void selectDepartureCity(String city) {

        LoggerUtils.info(Thread.currentThread().getName()+"Selecting departure city: " + city);

        Select select = new Select(departure);

        select.selectByVisibleText(city);
    }

    public void selectDestinationCity(String city) {

        LoggerUtils.info(Thread.currentThread().getName()+"Selecting destination city: " + city);

        Select select = new Select(destination);

        select.selectByVisibleText(city);
    }

    public void clickFindFlights() {

        click(findFlights);
    }
}
