package com.elbaih.stepDefs;

import com.elbaih.pages.P02_login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D02_loginStepDef
{ WebDriver driver =Hooks.driver;
    WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
    P02_login login =new P02_login();
    SoftAssert soft =new SoftAssert();
    @Given("user go to login page")
    public void userGoToLoginPage()
    {
        login.loginPage.click();

    }
    @When("user login with {string} {string} and {string}")
    public void userLoginWithAnd(String arg0, String username, String password)
    {

        login.loginFields.get(0).sendKeys(username);
        login.loginFields.get(1).sendKeys(password);
    }



    @And("user press on login button")
    public void userPressOnLoginButton()
    {
        login.loginButton.click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully()
    {
        soft.assertTrue(login.myAccount.isDisplayed());
        soft.assertTrue(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/"));
        soft.assertAll();

    }



    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem()
    {
        soft.assertTrue(login.unsucloginmesage.isDisplayed());
        soft.assertTrue(login.unsucloginmesage.getText().contains("Login was unsuccessful"));
       String actColor= Color.fromString(login.unsucloginmesage.getCssValue("color")).asHex() ;
        soft.assertEquals(actColor,"#e4434b");
        soft.assertAll();
    }


}
