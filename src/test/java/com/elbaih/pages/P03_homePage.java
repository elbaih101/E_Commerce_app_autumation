package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P03_homePage
{
    WebDriver driver= Hooks.driver;
    PageFactory pageFactory=new PageFactory();

    public P03_homePage(){pageFactory.initElements(driver,this);}

    @FindBy(id="customerCurrency")
    public WebElement curenclist;


    @FindBys({
            @FindBy(className ="prices" )
    })
    public List<WebElement> productsPrices;


}
