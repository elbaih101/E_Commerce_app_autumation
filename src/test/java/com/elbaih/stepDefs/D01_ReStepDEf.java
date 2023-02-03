package com.elbaih.stepDefs;

import com.elbaih.pages.P01_Register;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D01_ReStepDEf {
    WebDriver driver = Hooks.driver;
    SoftAssert soft = new SoftAssert();
    P01_Register register = new P01_Register();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("user go to register page")
    public void user_go_to_register_page() {
        register.registerLink.click();
    }


    @When("user selects gender type")
    public void userselectsgendertype() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        register.genders.get(0).click();
//        driver.findElement(By.cssSelector("input[id=\"FirstName\"]")).sendKeys("john");
//        driver.findElement(By.cssSelector("input[id=\"LastName\"]")).sendKeys("sayed");


    }


    @And("user enters {string} & {string}")
    public void userEnters(String firstname, String lastname) {
        register.namefields.get(0).sendKeys(firstname);
        register.namefields.get(1).sendKeys(lastname);
    }

    @And("user selects date of birth")
    public void userSelectsDateOfBirth() {
        Select selectday = new Select(register.daylist);
        Select selmonth = new Select(register.monthlist);
        Select selyear = new Select(register.yearlist);
        //select
        selectday.selectByValue("1");
        selmonth.selectByIndex(1);
        selyear.selectByVisibleText("2007");

    }

    @And("user enters email")
    //generate random email

    public void userEntersemail()  {
        Faker fake =new Faker();
       String emailAddress = fake.internet().safeEmailAddress();
        register.email.sendKeys(emailAddress);

    }


    @And("users enters passowrd {string} and confirms it")
    public void usersEntersPassowrdAndConfirmsIt(String argpassword0) {
        register.passwords.get(0).sendKeys(argpassword0);
        register.passwords.get(1).sendKeys(argpassword0);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        register.regButton.click();
    }

    @Then("account is created succesfuly")
    public void accountIsCreatedSuccesfuly() {
        wait.until(ExpectedConditions.urlContains("/registerresult"));
        register.succesmessage.isDisplayed();
        soft.assertTrue(register.succesmessage.isDisplayed());
        soft.assertTrue(register.succesmessage.getText().contains("Your registration completed"));
        String actcolor = Color.fromString(register.succesmessage.getCssValue("color")).asHex();
        soft.assertEquals(actcolor, "#4cb17c");


        soft.assertAll();
    }
}
