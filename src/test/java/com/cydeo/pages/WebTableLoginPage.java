package com.cydeo.pages;

import com.cydeo.step_definitions.WebTable_StepDefinitions;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {
    public WebTableLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "input[name='username']")
    public WebElement username;
    @FindBy(css = "input[name='password']")
    public WebElement password;
    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginButton;

    public void loginMethod(String one,String two) throws InterruptedException {
       this.username.sendKeys(one);
       this.password.sendKeys(two);
       Thread.sleep(2999);
       loginButton.click();
    }
    public void loginMethod(){
this.username.sendKeys("Test");
this.password.sendKeys("Tester");
    this.loginButton.click();
    }
public void loginWithConfig(){
        username.sendKeys(ConfigurationReader.getProperty("webTable.username"));
        password.sendKeys(ConfigurationReader.getProperty("webTable.password"));
loginButton.click();
    }

}
