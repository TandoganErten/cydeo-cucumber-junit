package com.cydeo.step_definitions;

import com.cydeo.pages.VyTrackLoginPage;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VyTrackStepDefinition {
    VyTrackLoginPage login = new VyTrackLoginPage();


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackUrl"));
    }

    @When("user enters driver credentials")
    public void user_enters_driver_credentials() throws IOException {
        String path = "new VyTrack credentials.xlsx";
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("vytrack");
        String username = sheet.getRow(0).getCell(0).toString();
        String password = sheet.getRow(0).getCell(1).toString();
        login.userNameInput.sendKeys(username);
        login.passwordInput.sendKeys(password);
        login.submitBtn.click();
    }

    @Then("user should see driver navigation options")
    public void user_should_see_driver_navigation_options(List<String> menuOps) {

    }


    @When("user enters {string} information")
    public void user_enters_information(String string) throws IOException {
        String path = "new VyTrack credentials.xlsx";
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("vytrack");
        String username = "";
        String password = "";

        switch (string){
            case "Sales":
                username = sheet.getRow(10).getCell(0).toString();
                password = sheet.getRow(10).getCell(1).toString();
                break;

            case "Store":
                username = sheet.getRow(6).getCell(0).toString();
                password = sheet.getRow(6).getCell(1).toString();
                break;
        }

        login.userNameInput.sendKeys(username);
        login.passwordInput.sendKeys(password);
        login.submitBtn.click();



    }

    @Then("user should see manager navigation options")
    public void user_should_see_manager_navigation_options(List<String> menuOps) {

    }



}