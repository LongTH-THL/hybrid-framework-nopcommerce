package com.facebookRegister;

import commons.Nopcommerce.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.Facebook.LoginPageObject;
import pageObject.Facebook.PageGeneratorManager;
import pageObject.jQuery.UploadFile.HomePageObject;

public class User_01_Element_Undisplay extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;


    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl){
        driver = getBrowserDriver(browserName, appUrl);
        loginPage = PageGeneratorManager.getLoginPage(driver);
    }

    @Test
    public void TC_01_Verify_Element_Display(){
        loginPage.clickToCreatNewAccountButton();
        veryfiTrue(loginPage.emailAddressTextboxIsDisplay());
    }

    @Test
    public void TC_02_Verify_Element_Undisplay_In_DOM(){
        loginPage.enterToEmailAddressTextbox("long@gmail.com");
        loginPage.sleepInSecond(2);
        veryfiTrue(loginPage.isConfirmEmailAddressTextboxDisplay());

        loginPage.enterToEmailAddressTextbox("");
        loginPage.sleepInSecond(2);
        verifyFailed(loginPage.isConfirmEmailAddressTextboxDisplay());


    }

    @Test
    public void TC_03_Verify_Element_Undisplay_Not_In_DOM(){
        loginPage.clickCloseIconAtRegisterForm();
        loginPage.sleepInSecond(2);

        veryfiTrue(loginPage.isConfirmEmailAddressTextboxUndisplay());
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
