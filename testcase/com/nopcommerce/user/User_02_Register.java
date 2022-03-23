package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserRegisterPageObject;

import java.util.Random;

public class User_02_Register extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;

    private String firstName, lastName, emailAddress, password;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl){
        driver = getBrowserDriver(browserName, appUrl);

        homePage = new UserHomePageObject(driver);

        firstName = "automation";
        lastName = "FC";
        password = "123456";
        emailAddress = "auto" + randomData() + "@gmail.com";
    }

    @Test
    public void Register_01_Empty_Data(){
        homePage.clickToRegisterLink();
        registerPage = new UserRegisterPageObject(driver);

        registerPage.clickToRegisterButton();


        verifyEquals(registerPage.getErrorMessageAtFirstnameTextbox(),"First name is required.");
        verifyEquals(registerPage.getErrorMessageAtLastnameTextbox(),"Last name is required.");
        verifyEquals(registerPage.getErrorMessageAtEmailTextbox(),"Email is required.");
        verifyEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password is required.");
        verifyEquals(registerPage.getErrorMessageAtConfirmPasswodTextbox(),"Password is required.");

    }

    @Test
    public void Register_02_Invalid_Email(){
        homePage.clickToRegisterLink();
        registerPage = new UserRegisterPageObject(driver);

        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox("123@123");
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        verifyEquals(registerPage.getErrorMessageAtEmailTextbox(),"Wrong email.");
    }

    @Test
    public void Register_03_Success(){
        homePage.clickToRegisterLink();
        registerPage = new UserRegisterPageObject(driver);

        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        verifyEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

        registerPage.clickToLogoutLink();

    }

    @Test
    public void Register_04_Exiting_Email(){
        homePage.clickToRegisterLink();
        registerPage = new UserRegisterPageObject(driver);

        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        verifyEquals(registerPage.getErrorExitingEmailMessage(),"The specified email already exists");


    }

    @Test
    public void Register_05_Password_Less_Than_6_Chars(){
        homePage.clickToRegisterLink();
        registerPage = new UserRegisterPageObject(driver);

        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox("123");
        registerPage.inputToConfirmPasswordTextbox("123");

        registerPage.clickToRegisterButton();

        verifyEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password must meet the following rules:\n" +
                "\n" +
                "must have at least 6 characters");
    }

    @Test
    public void Register_06_Invalid_Confirm_Password(){
        homePage.clickToRegisterLink();
        registerPage = new UserRegisterPageObject(driver);

        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox("000000");

        registerPage.clickToRegisterButton();

        verifyEquals(registerPage.getErrorMessageAtConfirmPasswodTextbox(),"The password and confirmation password do not match.\n");
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
