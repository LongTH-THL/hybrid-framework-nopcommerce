package com.nopcommerce.commons;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObject.user.*;

import java.util.Set;

public class Commons_01_Login extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;

    private String firstName, lastName, validEmail, password;
    public static Set<Cookie> loginPageCookie;


    @Parameters({"browser", "url"})
    @BeforeTest
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);

        firstName = "automation";
        lastName = "FC";
        password = "123456";
        validEmail = "auto" + randomData() + "@gmail.com";

        log.info("Commons_01 - Step_01: Verify Home Page is display");
        homePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Commons_01 - Step_02: Click to Register Link");
        registerPage = homePage.clickToRegisterLink();
        registerPage.sleepInSecond(2);

        log.info("Commons_01 - Step_03: Enter to First Name Textbox: " + firstName);
        registerPage.inputToFirstnameTextbox(firstName);

        log.info("Commons_01 - Step_04: Enter to Last Name Textbox: " + lastName);
        registerPage.inputToLastnameTextbox(lastName);

        log.info("Commons_01 - Step_05: Enter to Email Textbox: " + validEmail);
        registerPage.inputToEmailTextbox(validEmail);

        log.info("Commons_01 - Step_06: Enter to Pass Textbox: " + password);
        registerPage.inputToPasswordTextbox(password);

        log.info("Commons_01 - Step_07: Enter to Confirm Pass Textbox: " + password);
        registerPage.inputToConfirmPasswordTextbox(password);

        log.info("Commons_01 - Step_08: Click to register button");
        registerPage.clickToRegisterButton();

        log.info("Commons_01 - Step_09: Verify Success Message is display");
        verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

        log.info("Commons_01 - Step_10: Verify Home Page is Display");
        homePage = registerPage.clickToLogoutLink();

        log.info("Commons_01 - Step_11: Verify Login Page is Display");
        loginPage = homePage.clickToLoginLink();

        log.info("Commons_01 - Step_12: Enter to Email Textbox: " + validEmail);
        loginPage.inputToEmailTextbox(validEmail);

        log.info("Commons_01 - Step_13: Enter to Pass Textbox: " + password);
        loginPage.inputToPasswordTextbox(password);

        log.info("Commons_01 - Step_14: Click Login button");
        homePage = loginPage.clickToLoginButton();

        log.info("Commons_01 - Step_15: Verify My Account link is display");
        veryfiTrue(homePage.isMyAccountLinkDisplay());

        log.info("Commons_01 - Step_16: Get All Cookies");
        loginPageCookie = homePage.getAllCookies(driver);
        System.out.println(" all cookies = " + loginPageCookie);


        log.info("Pos-Condition: Close browser" + browserName + "");
        clearDriverInstance();
    }
}
