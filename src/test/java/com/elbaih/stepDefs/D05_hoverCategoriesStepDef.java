package com.elbaih.stepDefs;

import com.elbaih.pages.P03_homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.elbaih.stepDefs.Hooks.driver;

public class D05_hoverCategoriesStepDef {
    P03_homePage home = new P03_homePage();

    String title;
    SoftAssert soft = new SoftAssert();
    WebElement categorie;


    @When("randomly selecting a category")
    public void hoverovercategory() {
        Actions action = new Actions(driver);
//        System.out.println(Arrays.toString(home.categories.toArray()));
//        Select select=new Select();


        do {
            int t = (int) (Math.random() * 6);
            categorie = home.categories.get(t);
        }
        while (categorie.findElements(By.tagName("ul")).isEmpty());


        action.moveToElement(categorie).perform();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @And("select random sub category from the main one")
    public void selectRandomSubCategoryFromTheMainOne() {
        List<WebElement> subcat = categorie.findElements(By.tagName("li"));
        int t = (int) (Math.random() * (subcat.size() - 1));
        title = subcat.get(t).getText();

        subcat.get(t).click();
        System.out.println(title);

    }

    @Then("the subcategory page is navigated to")
    public void theSubcategoryPageIsNavigatedTo() {
        soft.assertTrue(driver.getCurrentUrl().toLowerCase().trim().contains(title.toLowerCase().trim()));
    }
}
