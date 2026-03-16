package com.flightbooking.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchasePage extends BasePage {


    @FindBy(id = "inputName")
    WebElement name;

    @FindBy(id = "address")
    WebElement address;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "zipCode")
    WebElement zip;

    @FindBy(id = "creditCardNumber")
    WebElement card;
    
    @FindBy(id ="creditCardMonth")
    WebElement ccMonth;
    
    @FindBy(id="creditCardYear")
    WebElement ccYear;
    
    @FindBy(id = "nameOnCard")
    WebElement nameOnCard;

    @FindBy(css = "input[type='submit']")
    WebElement purchase;

    public void enterPassengerDetails(String n,
                                      String a,
                                      String c,
                                      String s,
                                      String z) {

        type(name,n);
        type(address,a);
        type(city,c);
        type(state,s);
        type(zip,z);
    }

    public void enterPaymentDetails(String cardNumber,String nameOnC,String cMonth,String cYear) {

        type(card,cardNumber);
        type(ccMonth,cMonth);
        type(ccYear,cYear);
        type(nameOnCard,nameOnC);
    }
    
    public void clickPurchaseFlight() {

        click(purchase);
    }
}