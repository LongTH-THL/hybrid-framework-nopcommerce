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
    public void beforeClass(String browserName, String appUrl, Method method){
        driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = "automation";
        lastName = "FC";
        password = "123456";
        validEmail = "auto" + randomData() + "@gmail.com";
        invalidEmail = "AFC@AFC.com@.vn";
        notFoundEmail = "auto" + randomData() + "@mail.vn";

        homePage = PageGeneratorManager.getUserHomePage(driver);
        veryfiTrue(homePage.isHomePageImgIsDisplay());

        homePage.clickToLinkByName(driver,"Register");
        registerPage = PageGeneratorManager.getUserRegisterPage(driver);


        registerPage.enterToTextboxID(driver, "FirstName",firstName);
        registerPage.enterToTextboxID(driver,"LastName",lastName);
        registerPage.enterToTextboxID(driver,"Email",validEmail);
        registerPage.enterToTextboxID(driver,"Password",password);
        registerPage.enterToTextboxID(driver,"ConfirmPassword",password);

        registerPage.clickToRegisterButton();
        verifyEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

        homePage.clickToLinkByName(driver,"Log out");
    }

    @Test
    public void Login_01_Empty_Data(Method method){
        ExtentTestManager.startTest(method.getName(), "Login_01_Empty_Data");
        ExtentTestManager.getTest().log(LogStatus.INFO, "NewCustomer - Step 01: Verify Login Page Is Display ");
        homePage.clickToLinkByName(driver,"Log in");
        loginPage = PageGeneratorManager.getUserLoginPage(driver);

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_01_Empty_Data - Step_02: Click Login Button");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_01_Empty_Data - Step_03: Verify Error Message At Email Textbox");
        verifyEquals(loginPage.getErrorMessageAtEmailTextbox(),"Please enter your email");

        ExtentTestManager.endTest();
    }

    @Test
    public void Login_02_Invalid_Email(Method method){
        ExtentTestManager.startTest(method.getName(), "Login_02_Invalid_Email");
        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_02_Invalid_Data - Step_01: Verify Login Page Is Display");
        homePage.clickToLinkByName(driver,"Log in");
        loginPage = PageGeneratorManager.getUserLoginPage(driver);

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_02_Invalid_Data - Step_02: Enter Invalid Email To Email Textbox");
        loginPage.enterToTextboxID(driver,"Email",invalidEmail);

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_02_Invalid_Data - Step_03: Click Login utton");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_02_Invalid_Data - Step_04: Verify Error Message At Email Textbox");
        verifyEquals(loginPage.getErrorMessageAtEmailTextbox(),"Wrong email");

        ExtentTestManager.endTest();
    }

    @Test
    public void Login_03_Email_Not_Found(Method method){
        ExtentTestManager.startTest(method.getName(), "Login_03_Email_Not_Found");
        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_03_Email_Not_Found - Step_01: Verify Login Page Is Display");
        homePage.clickToLinkByName(driver, "Log in");
        loginPage = PageGeneratorManager.getUserLoginPage(driver);

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_03_Email_Not_Found - Step_02: Enter Email Not Found");
        loginPage.enterToTextboxID(driver,"Email",notFoundEmail);

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_03_Email_Not_Found - Step_03: Click To Login Button");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_03_Email_Not_Found - Step_04: Verify Error Message At Email Textbox");
        verifyEquals(loginPage.getErrorMessageUnsuccessfull(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");
    }

    @Test
    public void Login_04_Exiting_Email_And_Emty_Password(Method method){
        ExtentTestManager.startTest(method.getName(), "Login_04_Exiting_Email_And_Emty_Password");
        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_04_Exiting_Email_And_Emty_Password - Step_01: Verify Login Page Is Display");
        homePage.clickToLinkByName(driver, "Log in");
        loginPage = PageGeneratorManager.getUserLoginPage(driver);

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_04_Exiting_Email_And_Emty_Password - Step_02: Enter Exiting Email");
        loginPage.enterToTextboxID(driver,"Email",validEmail);

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_04_Exiting_Email_And_Emty_Password - Step_03: Enter To Password");
        loginPage.inputToPasswordTextbox("");

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_04_Exiting_Email_And_Emty_Password - Step_04: Click Button Login");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_04_Exiting_Email_And_Emty_Password - Step_05: Verify Error Message At Email Textbox");
        verifyEquals(loginPage.getErrorMessageUnsuccessfull(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");

    }

    @Test
    public void Login_05_Exiting_Email_And_Incorrect_Password(Method method){
        ExtentTestManager.startTest(method.getName(), "Login_05_Exiting_Email_And_Incorrect_Password");
        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_05_Exiting_Email_And_Incorrect_Password - Step_01: Verify Login Page Is Display");
        homePage.clickToLinkByName(driver, "Log in");
        loginPage = PageGeneratorManager.getUserLoginPage(driver);

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_05_Exiting_Email_And_Incorrect_Password - Step_02: Enter To Email");
        loginPage.enterToTextboxID(driver,"Email",validEmail);

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_05_Exiting_Email_And_Incorrect_Password - Step_03: Enter Incorrect Password");
        loginPage.enterToTextboxID(driver,"Password","654321");

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_05_Exiting_Email_And_Incorrect_Password - Step_04: Click To Login Button");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_05_Exiting_Email_And_Incorrect_Password - Step_05: Verify Error Message At Email Textbox");
        verifyEquals(loginPage.getErrorMessageUnsuccessfull(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
    }

    @Test
    public void Login_06_Success(Method method){
        ExtentTestManager.startTest(method.getName(), "Login_06_Success");

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_06_Success - Step_01: Verify Login Page Is Display");
        homePage.clickToLinkByName(driver, "Log in");
        loginPage = PageGeneratorManager.getUserLoginPage(driver);

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_06_Success - Step_02: Enter To Email");
        loginPage.enterToTextboxID(driver,"Email",validEmail);

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_06_Success - Step_03: Enter To Password");
        loginPage.enterToTextboxID(driver,"Password",password);

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_06_Success - Step_04: Click To Login Button");
        homePage = loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(LogStatus.INFO,"Login_06_Success - Step_05: Verify My Account link Is Display");
        veryfiTrue(homePage.isMyAccountLinkDisplay());

        homePage.clickToMyAccountLink();

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
