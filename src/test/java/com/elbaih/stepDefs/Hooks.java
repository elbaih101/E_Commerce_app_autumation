package com.elbaih.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks
{
    public static WebDriver driver;
    @Before
    public static void start()
    {//1- create bridge with web driver
      /*  System.out.println("open");
        String key="webdriver.edge.driver";
        String value =System.getProperty("user.dir")+"/Browsers/msedgedriver.exe";*/
    //1- create bridge using WebDriverManager dependency
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }





    @After
    public static void end()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
