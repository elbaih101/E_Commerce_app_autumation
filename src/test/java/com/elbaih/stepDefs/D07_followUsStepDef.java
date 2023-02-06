package com.elbaih.stepDefs;

import com.elbaih.pages.P03_homePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

public class D07_followUsStepDef
{
    P03_homePage home =new P03_homePage();
    WebDriverWait wait =new WebDriverWait(Hooks.driver, Duration.ofSeconds(2));
    SoftAssert soft =new SoftAssert();

    @When("user clicks on the {string} logo in the end of the page")
    public void clickonsociallogo(String logo)
    {wait.until(ExpectedConditions.visibilityOf(home.networks));
        home.networks.findElement(By.cssSelector("li[class="+logo+"]")).click();




    }

    @Then("{string}  is opened in new tab")
    public void isOpenedInNewTab(String link)
    {
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs =new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        soft.assertEquals(Hooks.driver.getCurrentUrl().toLowerCase(),link.toLowerCase());
        soft.assertAll();

    }
}
