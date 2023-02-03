package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P01_Register {
    public WebDriver driver = Hooks.driver;
    PageFactory pageFactory=new PageFactory();
    //PAGE FACTORY POM
    //1- CONSTRUCTOR
    public P01_Register() {
        pageFactory.initElements(driver, this);
    }

    @FindBy(className = "ico-register")
    public WebElement registerLink;


   /* public WebElement registerLink()
    {
        WebElement registerLink =driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));
        return registerLink;
    }

    public List Gender()
    {
      List <WebElement> genders= driver.findElements(By.cssSelector("div[id=\"gender\"]"));
      genders
      return genders;
    }*/

    @FindBys({
            @FindBy(name = "Gender")
    })
    public List<WebElement> genders;

    @FindAll({
            @FindBy(id = "FirstName"),
            @FindBy(id = "LastName")

    })
    public List<WebElement> namefields;
    @FindBy(name="DateOfBirthDay")
    public WebElement daylist;
    @FindBy(name = "DateOfBirthMonth")
    public WebElement monthlist;
    @FindBy(name = "DateOfBirthYear")
    public WebElement yearlist;
    @FindBy(id = "Email")
    public WebElement email;
    @FindAll({
            @FindBy(id = "Password"),
            @FindBy(id = "ConfirmPassword")
    })
    public List<WebElement> passwords;
    @FindBy(id = "register-button")
    public WebElement regButton;

    @FindBy(className = "result")
    public WebElement succesmessage;

}
