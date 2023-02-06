package com.elbaih.stepDefs;

import com.elbaih.pages.P03_homePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishlistStepDef {
    P03_homePage home = new P03_homePage();
SoftAssert soft =new SoftAssert();
WebDriverWait wait =new WebDriverWait(Hooks.driver, Duration.ofSeconds(2));
    @When("user clicks on wish list button on the htc phone product")
    public void addtowishlist() {
        WebElement product = null;
        for (WebElement tmp : home.shownProductList) {
            if (tmp.getText().contains("HTC One M8"))
                product = tmp;

        }
        product.findElement(By.className("add-to-wishlist-button")).click();

    }

    @Then("message that confirms addition of the phone appears")
    public void messageThatConfirmsAdditionOfThePhoneAppears()
    {
        String actcolor= Color.fromString(home.notificationbar.getCssValue("background-color")).asHex();
        soft.assertEquals(actcolor,"#4bb07a");
        soft.assertEquals(home.notificationbar.getText().trim().toLowerCase(),("The product has been added to your wishlist ").trim().toLowerCase());
        soft.assertAll();
    }

    @When("the success message disapear user clicks on the wishlist button on top of the page")
    public void theSuccessMessageDisapearUserClicksOnTheWishlistButtonOnTopOfThePage()
    {wait.until(ExpectedConditions.invisibilityOf(home.notificationbar));
        home.wishlist.click();

    }

    @Then("verify the quantity of the product is bigger than {int}")
    public void verifyTheQuantityOfTheProductIsBiggerThan(int arg0)
    {
      int quantity= Integer.parseInt(home.quantityofwishlistproduct.getAttribute("value").trim()) ;
      soft.assertTrue(quantity>0);
      soft.assertAll();
    }
}
