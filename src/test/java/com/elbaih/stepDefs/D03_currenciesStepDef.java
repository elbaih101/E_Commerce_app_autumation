package com.elbaih.stepDefs;

import com.elbaih.pages.P03_homePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_currenciesStepDef
{
    WebDriver driver=Hooks.driver;
    P03_homePage home=new P03_homePage();
    @When("user Select Euro currency from the dropdown list on the top left of home page")
    public void selectCurrency(){
        Select select =new Select(home.curenclist);
        select.selectByVisibleText("Euro");
    }

    @Then("currency changes for the product shown in the page")
    public void currencyChangesForTheProductShownInThePage()
    {
        for (WebElement element:home.productsPrices)
        {
            Assert.assertTrue(element.getText().contains("€"));
        }

    }
}
