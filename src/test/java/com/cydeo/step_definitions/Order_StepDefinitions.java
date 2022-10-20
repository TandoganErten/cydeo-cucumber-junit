package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.ViewAllOrdersPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Order_StepDefinitions {
    ViewAllOrdersPage viewAllOrdersPage=new ViewAllOrdersPage();
    BasePage basePage=new BasePage();
    OrderPage orderPage=new OrderPage();
    WebTableLoginPage webTableLoginPage=new WebTableLoginPage();
    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("webTableUrl"));







    webTableLoginPage.loginMethod();

    basePage.order.click();
    }
    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        Select select=new Select(orderPage.productDropDown);
        select.selectByVisibleText(string);
    }
    @When("user enters quantity {int}")

    public void user_enters_quantity(Integer int1) {
        //value of method accepts int and turns itno string
orderPage.quantity.sendKeys(String.valueOf(int1));
    }
    @When("user enters customer name {string}")
    public void user_enters_customer_name(String string) {
orderPage.customerName.sendKeys(string);
    }
    @When("user enters street {string}")
    public void user_enters_street(String string) {
orderPage.street.sendKeys(string);
    }
    @When("user enters city {string}")
    public void user_enters_city(String string) {
orderPage.city.sendKeys(string);
    }
    @When("user enters state {string}")
    public void user_enters_state(String string) {
orderPage.state.sendKeys(string);
    }
    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
orderPage.zip.sendKeys(string);
    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String string) {
        BrowserUtils.clickRadioButton(orderPage.cards,string);
    }
    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
orderPage.cardNo.sendKeys(string);
    }
    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
orderPage.expireDate.sendKeys(string);
    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
orderPage.processOrder.click();
    }
    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String string) {
        Assert.assertEquals(viewAllOrdersPage.newCustomerCell.getText(),string);
    }
}
