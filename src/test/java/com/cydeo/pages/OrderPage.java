package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends BasePage {

    public  OrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "select[name='product']")
    public WebElement productDropDown;
    @FindBy(css = "input[placeholder='Enter amount desired']")
    public WebElement quantity;
    @FindBy(css = "input[placeholder=\"Full name of the customer\"]")
    public WebElement customerName;
    @FindBy(css = "input[placeholder=\"Street address of the customer\"]")
    public WebElement street;
    @FindBy(css = "input[placeholder=\"City where the customer lives\"]")
    public WebElement city;
    @FindBy(css = "input[placeholder=\"State where the customer lives\"]")
    public WebElement state;
    @FindBy(css = "input[placeholder=\"The cusomer's zip code\"]")
    public WebElement zip;

@FindBy(xpath = "//input[@name='card']")
public List<WebElement> cards;
    @FindBy(css = "input[placeholder=\"The number on the card\"]")
    public WebElement cardNo;
   @FindBy(css = "input[placeholder=\"e.g. 04/24\"]")
    public WebElement expireDate;
   @FindBy(xpath = "//button[.='Process Order']")
public WebElement processOrder;

}
