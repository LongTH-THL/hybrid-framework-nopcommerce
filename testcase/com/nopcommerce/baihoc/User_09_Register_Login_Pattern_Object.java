package com.nopcommerce.baihoc;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.UserRegisterPageObject;

public class User_09_Register_Login_Pattern_Object extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserLoginPageObject loginPage;
    private UserRegisterPageObject registerPage;

    private String validEmail, password, firstName, lastName;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeTest(String browserName, String appUrl){
        driver = getBrowserDriver(browserName, appUrl);

        firstName = "automation";
        lastName = "FC";
        password = "123456";
        validEmail = "auto" + randomData() + "@gmail.com";
    }

    @Test
    public void TC_01_Register_To_System(){
        log.info("User_01_Register - Step_01: Verify Home page is Displayed");
        homePage = PageGeneratorManager.getUserHomePage(driver);
        veryfiTrue(homePage.isHomePageImgIsDisplay());

        log.info("User_01_Register - Step_02: Click Register Link");
        homePage.clickToLinkByName(driver,"Register");
        registerPage = PageGeneratorManager.getUserRegisterPage(driver);

        log.info("User_01_Register - Step_03: Enter To First Name Textbox");
        registerPage.enterToTextboxID(driver, "FirstName",firstName);

        log.info("User_01_Register - Step_04: Enter To Last Name Textbox");
        registerPage.enterToTextboxID(driver,"LastName",lastName);

        log.info("User_01_Register - Step_05: Enter To Email Address Textbox");
        registerPage.enterToTextboxID(driver,"Email",validEmail);

        log.info("User_01_Register - Step_06: Enter To Password Textbox");
        registerPage.enterToTextboxID(driver,"Password",password);

        log.info("User_01_Register - Step_07: Enter To Confirm Password Textbox");
        registerPage.enterToTextboxID(driver,"ConfirmPassword",password);

        log.info("User_01_Register - Step_08: Click to Register Button");
        registerPage.clickToRegisterButton();

        log.info("User_01_Register - Step_09: Verify Register Success Message");
        verifyEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

        log.info("User_01_Register - Step_10: Click to Log out Link");
        homePage.clickToLinkByName(driver,"Log out");
    }

    @Test
    public void TC_02_Login_To_System(){
        log.info("User_02_Login - Step_01: Click to Login Link");
        homePage.clickToLinkByName(driver,"Log in");
        loginPage = PageGeneratorManager.getUserLoginPage(driver);

        log.info("User_02_Login - Step_02: Enter to Email Textbox");
        loginPage.enterToTextboxID(driver,"Email",validEmail);

        log.info("User_02_Login - Step_03: Enter to Password Textbox");
        loginPage.enterToTextboxID(driver,"Password",password);

        log.info("User_02_Login - Step_03: Click to Login Button");
        loginPage.clickToLoginButton();
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
