package com.nopcommerce.baihoc;

import commons.Nopcommerce.BaseTest;
import commons.Nopcommerce.PageGeneratorManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageFactory.UserHomePageObject;
import pageObject.NopCommerce.user.*;

@Listeners(commons.Nopcommerce.MethodListener.class)
public class User_07_Assert_Verify extends BaseTest {
    private WebDriver driver;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl){
        driver = getBrowserDriver(browserName, appUrl);
    }

    @Test
    public void Vrify_01_ValidateCurrentURL(){
        System.out.println("Verify_01_Pass");
        String loginURL = driver.getCurrentUrl();
        verifyEquals(loginURL, "https://vi-vn.facebook.com/");

        System.out.println("Verify_02_Failed");
        String loginTitle = driver.getTitle();
        verifyEquals(loginTitle,"abc xyz");

        System.out.println("Verify_03_Pass");
        veryfiTrue(driver.findElement(By.xpath(" //img[@class='fb_logo _8ilh img']")).isDisplayed());

        System.out.println("Verify_04_Failed");
        verifyFailed(driver.findElement(By.xpath(" //img[@class='fb_logo _8ilh img']")).isDisplayed());

        System.out.println("Verify_05_Pass");
        veryfiTrue(driver.findElement(By.xpath(" //img[@class='fb_logo _8ilh img']")).isDisplayed());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
