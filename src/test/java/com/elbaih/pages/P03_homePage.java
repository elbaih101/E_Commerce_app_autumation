package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P03_homePage {
    WebDriver driver = Hooks.driver;
    PageFactory pageFactory = new PageFactory();

    public P03_homePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "customerCurrency")
    public WebElement curenclist;


    @FindBys({
            @FindBy(className = "prices")
    })
    public List<WebElement> productsPrices;

    @FindBy(id = "small-searchterms")
    public WebElement searchBar;
    @FindBy(className = "search-box-button")
    public WebElement searchButton;
    @FindAll({
            @FindBy(className = "product-item")
    })
    public List<WebElement> shownProductList;

    @FindBy(className = "sku")
    public WebElement skuVAlue;

    @FindAll({
            @FindBy(xpath = "//ul[@class=\"top-menu notmobile\"]/li")
    })
    public List<WebElement> categories;


    @FindBy(xpath = "//div[@id=\"nivo-slider\"]/img")
    public WebElement slider;

    @FindBy(className = "bar-notification")
    public WebElement notificationbar;
    @FindBy(className = "ico-wishlist")
    public WebElement wishlist;
        @FindBy(className="qty-input")
    public WebElement quantityofwishlistproduct;
        @FindBy(className ="networks")
    public WebElement networks;
}
