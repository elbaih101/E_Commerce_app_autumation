package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P02_login {
    public WebDriver driver = Hooks.driver;
    PageFactory pageFactory=new PageFactory();
    public P02_login() {
        pageFactory.initElements(driver, this);
    }

    @FindBy(className = "ico-login")
    public WebElement loginPage;
    @FindAll({
            @FindBy(className = "email"),
            @FindBy(className = "password")
    })
    public List<WebElement> loginFields;
    @FindBy(className = "login-button")
    public WebElement loginButton;

    @FindBy(className = "ico-account")
    public WebElement myAccount;
    @FindBy(className = "message-error")
    public WebElement unsucloginmesage;


}
