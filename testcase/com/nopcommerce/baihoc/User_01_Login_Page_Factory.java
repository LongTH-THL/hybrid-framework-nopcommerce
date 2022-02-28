package com.nopcommerce.baihoc;

import commons.Nopcommerce.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.UserHomePageObject;
import pageFactory.LoginPageObject;
import pageFactory.RegisterPageObject;

import java.util.Random;

public class User_01_Login_Page_Factory extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject homePage;
    private pageFactory.RegisterPageObject registerPage;
    private pageFactory.LoginPageObject loginPage;

    private String firstName, lastName, validEmail,invalidEmail, notFoundEmail, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName, String appUrl){
        driver = getBrowserDriver(browserName, appUrl);

        homePage = new UserHomePageObject(driver);

        firstName = "automation";
        lastName = "FC";
        password = "123456";
        validEmail = "auto" + randomData() + "@gmail.com";
        invalidEmail = "AFC@AFC.com@.vn";
        notFoundEmail = "auto" + randomData() + "@mail.vn";

        System.out.println("Pre-Condition - Step 01: Click to Register link");
        homePage.clickToRegisterLink();
        registerPage = new RegisterPageObject(driver);
        System.out.println("Pre-Condition - Step 02: Register with emty data");
        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox(validEmail);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);
        System.out.println("Pre-Condition - Step 03: Click to Register button");
        registerPage.clickToRegisterButton();
        System.out.println("Pre-Condition - Step 04: Verify success message");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

        registerPage.clickToLogoutLink();
        homePage = new UserHomePageObject(driver);
    }

    @Test
    public void Login_01_Empty_Data(){
        homePage.clickToLoginLink();
        loginPage = new pageFactory.LoginPageObject(driver);

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Please enter your email");
    }

    @Test
    public void Login_02_Invalid_Email(){
        homePage.clickToLoginLink();
        loginPage = new pageFactory.LoginPageObject(driver);

        loginPage.inputToEmailTextbox(invalidEmail);
        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Wrong email");
    }

    @Test
    public void Login_03_Email_Not_Found(){
        homePage.clickToLoginLink();
        loginPage = new pageFactory.LoginPageObject(driver);

        loginPage.inputToEmailTextbox(notFoundEmail);

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");
    }

    @Test
    public void Login_04_Exitng_Email_And_Emty_Password(){
        homePage.clickToLoginLink();
        loginPage = new pageFactory.LoginPageObject(driver);

        loginPage.inputToEmailTextbox(validEmail);
        loginPage.inputToPasswordTextbox("");
        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");

    }

    @Test
    public void Login_05_Exiting_Email_And_Incorrect_Password(){
        homePage.clickToLoginLink();
        loginPage = new pageFactory.LoginPageObject(driver);

        loginPage.inputToEmailTextbox(validEmail);
        loginPage.inputToPasswordTextbox("654321");
        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
    }

    @Test
    public void Login_06_Success(){
        homePage.clickToLoginLink();
        loginPage = new LoginPageObject(driver);

        loginPage.inputToEmailTextbox(validEmail);
        loginPage.inputToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        homePage = new UserHomePageObject(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDisplay());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    public int randomData(){
        Random random = new Random();
        return random.nextInt(999999);
    }


}
