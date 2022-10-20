package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class WebTable_StepDefinitions {
    WebTableLoginPage webTableLoginPage=new WebTableLoginPage();
    @Given("user is on the login page of web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
String url=ConfigurationReader.getProperty("webTableUrl");
Driver.getDriver().get(url);
    }

    @When("user enters username {string}")
    public void user_enters_username(String string) {
webTableLoginPage.username.sendKeys(string);
    }

    @When("user enters password {string}")
    public void user_enters_password(String string) {
webTableLoginPage.password.sendKeys(string);
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
webTableLoginPage.loginButton.click();
    }

    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders() {
        BrowserUtils.verifyURLContains("orders");
    }

    @When("user enters username {string} password {string} and logins")
    public void userEntersUsernamePasswordAndLogins(String arg0, String arg1) throws InterruptedException {
       webTableLoginPage.loginWithConfig();
    }
    @When("user enters below credentials")
    public void user_enters_below_credentials(Map<String,String> credentials) throws InterruptedException {
     webTableLoginPage.loginMethod(credentials.get("username"),credentials.get("password"));
    }
}