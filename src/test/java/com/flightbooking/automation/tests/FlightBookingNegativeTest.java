package com.flightbooking.automation.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.flightbooking.automation.base.BaseTest;
import com.flightbooking.automation.listeners.TestListener;
import com.flightbooking.automation.pages.*;
import com.flightbooking.automation.utils.*;

@Listeners(TestListener.class)
public class FlightBookingNegativeTest extends BaseTest {

    @DataProvider(name = "excelData")
    public Object[][] getExcelData() throws Exception {

        String path = System.getProperty("user.dir")
                + "/src/test/resources/NegativeTestData.xlsx";

        return ExcelUtils.getExcelData(path, "Sheet1");
    }

    @Test(dataProvider = "excelData")

    public void verifyBookingWithInvalidData(
            String fromCity,
            String toCity,
            String name,
            String address,
            String city,
            String state,
            String zip,
            String card,
            String ccMonth,
            String ccYear,
            String nameOnCard) {

        TravelTheWorldPage travel = new TravelTheWorldPage();

        travel.selectDepartureCity(fromCity);
        travel.selectDestinationCity(toCity);
        travel.clickFindFlights();

        FlightsPage flights = new FlightsPage();

        Assert.assertTrue(flights.verifyFlightsDisplayed());

        flights.chooseFirstFlight();

        PurchasePage purchase = new PurchasePage();

        purchase.enterPassengerDetails(name, address, city, state, zip);
        purchase.enterPaymentDetails(card, nameOnCard, ccMonth, ccYear);

        purchase.clickPurchaseFlight();

        ConfirmationPage confirmation = new ConfirmationPage();

        String message = confirmation.getConfirmationMessage();

        // Negative validation
        Assert.assertFalse(
                message.contains("Thank you"),
                "Booking succeeded with invalid input"
        );
    }
}