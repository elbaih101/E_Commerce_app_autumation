package com.elbaih.stepDefs;

import com.elbaih.pages.P03_homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef
{
    P03_homePage home=new P03_homePage();
    SoftAssert soft =new SoftAssert();
    @When("user enters product {string} {string}in the search bar")
    public void userEntersProductNameInTheSeachBar(String arg0,String searchItem)
    {
        home.searchBar.sendKeys(searchItem);
    }

    @And("user clicks search button")
    public void userClicksSearchButton()
    {
        home.searchButton.click();
    }

    @Then("user is directed to search resault page")
    public void userIsDirectedToSearchResaultPage()
    {
        System.out.println(home.shownProductList.size());
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("/search"));

    }


    @And("user clicks on the earched item")
    public void userClicksOnTheEarchedItem()
    {
        if (home.shownProductList.size()==1)
            home.shownProductList.get(0).click();
        
    }

    @And("user is directed to the required item with sku {string}")
    public void userIsDirectedToTheRequiredItem(String sku)
    {
        Assert.assertEquals(home.skuVAlue.getText().toLowerCase(),sku.toLowerCase());

    }
}
