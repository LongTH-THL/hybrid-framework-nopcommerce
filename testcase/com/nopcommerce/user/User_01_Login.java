package com.nopcommerce.user;

import com.relevantcodes.extentreports.LogStatus;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.UserCustomerInfoPageObject;
import pageObject.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class User_01_Login extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserCustomerInfoPageObject myAccountPage;

    private String firstName, lastName, validEmail,invalidEmail, notFoundEmail, password;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl){
        driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = "automation";
        lastName = "FC";
        password = "123456";
        validEmail = "auto" + randomData() + "@gmail.com";
        invalidEmail = "AFC@AFC.com@.vn";
        notFoundEmail = "auto" + randomData() + "@mail.vn";

        System.out.println("Pre-Condition - Step 01: Click to Register link");
        registerPage = homePage.clickToRegisterLink();

        System.out.println("Pre-Condition - Step 02: Register with emty data");
        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox(validEmail);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);
        System.out.println("Pre-Condition - Step 03: Click to Register button");
        registerPage.clickToRegisterButton();
        System.out.println("Pre-Condition - Step 04: Verify success message");
        verifyEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

        homePage = registerPage.clickToLogoutLink();
    }

    @Test
    public void Login_01_Empty_Data(Method method){
        ExtentTestManager.startTest(method.getName(), "Login_01_Empty_Data");
        ExtentTestManager.getTest().log(LogStatus.INFO, "NewCustomer - Step 01: Verify Login Page is display ");
//        log.info("Login_01_Empty_Data - Step_01: Verify Login Page is display");
        loginPage = homePage.clickToLoginLink();

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_01_Empty_Data - Step_02: Click Login Button");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_01_Empty_Data - Step_03: Verify Error Message At Email Textbox");
        verifyEquals(loginPage.getErrorMessageAtEmailTextbox(),"Please enter your email");

        ExtentTestManager.endTest();
    }

    @Test
    public void Login_02_Invalid_Email(Method method){
        ExtentTestManager.startTest(method.getName(), "Login_02_Invalid_Email");
        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_02_Invalid_Data - Step_01: Verify Login Page is display");
        loginPage = homePage.clickToLoginLink();

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_02_Invalid_Data - Step_02: Enter invalid Email to Email Textbox");
        loginPage.inputToEmailTextbox(invalidEmail);

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_02_Invalid_Data - Step_03: Click login button");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_02_Invalid_Data - Step_04: Verify Error Message At Email Textbox");
        verifyEquals(loginPage.getErrorMessageAtEmailTextbox(),"Wrong email.");

        ExtentTestManager.endTest();
    }

//    @Test
//    public void Login_03_Email_Not_Found(){
//        loginPage = homePage.clickToLoginLink();
//
//        loginPage.inputToEmailTextbox(notFoundEmail);
//
//        loginPage.clickToLoginButton();
//
//        verifyEquals(loginPage.getErrorMessageUnsuccessfull(),"Login was unsuccessful. Please correct the errors and try again.\n" +
//                "No customer account found");
//    }
//
//    @Test
//    public void Login_04_Exitng_Email_And_Emty_Password(){
//        loginPage = homePage.clickToLoginLink();
//
//        loginPage.inputToEmailTextbox(validEmail);
//        loginPage.inputToPasswordTextbox("");
//        loginPage.clickToLoginButton();
//
//        verifyEquals(loginPage.getErrorMessageUnsuccessfull(),"Login was unsuccessful. Please correct the errors and try again.\n" +
//                "The credentials provided are incorrect");
//
//    }
//
//    @Test
//    public void Login_05_Exiting_Email_And_Incorrect_Password(){
//        loginPage = homePage.clickToLoginLink();
//
//        loginPage.inputToEmailTextbox(validEmail);
//        loginPage.inputToPasswordTextbox("654321");
//        loginPage.clickToLoginButton();
//
//        verifyEquals(loginPage.getErrorMessageUnsuccessfull(),"Login was unsuccessful. Please correct the errors and try again.\n" +
//                "The credentials provided are incorrect");
//    }
//
//    @Test
//    public void Login_06_Success(){
//        loginPage = homePage.clickToLoginLink();
//
//        loginPage.inputToEmailTextbox(validEmail);
//        loginPage.inputToPasswordTextbox(password);
//        homePage = loginPage.clickToLoginButton();
//
//        veryfiTrue(homePage.isMyAccountLinkDisplay());
//
//        homePage.clickToMyAccountLink();
//
//    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
