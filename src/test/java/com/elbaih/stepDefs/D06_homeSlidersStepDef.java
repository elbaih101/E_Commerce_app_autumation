package com.elbaih.stepDefs;

import com.elbaih.pages.P03_homePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D06_homeSlidersStepDef
{
    SoftAssert soft =new SoftAssert();
    P03_homePage home =new P03_homePage();
WebDriverWait wait =new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    @When("user clicks on the {string} {string} slider")
    public void userClicksOnTheSlider(String arg0,String arg1)
    {
        wait.until(ExpectedConditions.attributeContains(home.slider,"src",arg0));
        home.slider.findElement(By.xpath("../..")).click();

    }
    @Then("user is directed to the phone page {string}")
    public void userdirectedtophonepage(String arg0)
    {
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains(arg0));
        soft.assertAll();
    }


}
