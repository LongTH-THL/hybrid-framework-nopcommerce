package com.nopcommerce.baihoc;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.NopCommerce.user.*;

public class User_06_Dynamic_Locator extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserCustomerInfoPageObject customerInfoPage;
    private UserAddressesPageObject addressesPage;
    private UserMyProductReviewPageObject myProductReviewPage;
    private UserOrderPageObject orderPage;
    private UserRewardPointsPageObject rewardPointsPage;

    private String firstName, lastName, validEmail,invalidEmail, notFoundEmail, password;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl){
        driver = getBrowserDriver(browserName, appUrl);

        firstName = "automation";
        lastName = "FC";
        password = "123456";
        validEmail = "auto" + randomData() + "@gmail.com";
    }

    @Test
    public void User_01_Register_Login(){
        log.info("User_01_Register - Step_01: Verify Home Page is display");
        homePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("User_01_Register - Step_02: Click to Register Link");
        registerPage = homePage.clickToRegisterLink();
        registerPage.sleepInSecond(2);

        log.info("User_01_Register - Step_03: Enter to First Name Textbox: " + firstName);
        registerPage.inputToFirstnameTextbox(firstName);

        log.info("User_01_Register - Step_04: Enter to Last Name Textbox: " + lastName);
        registerPage.inputToLastnameTextbox(lastName);

        log.info("User_01_Register - Step_05: Enter to Email Textbox: " + validEmail);
        registerPage.inputToEmailTextbox(validEmail);

        log.info("User_01_Register - Step_06: Enter to Pass Textbox: " + password);
        registerPage.inputToPasswordTextbox(password);

        log.info("User_01_Register - Step_07: Enter to Confirm Pass Textbox: " + password);
        registerPage.inputToConfirmPasswordTextbox(password);

        log.info("User_01_Register - Step_08: Click to register button");
        registerPage.clickToRegisterButton();

        log.info("User_01_Register - Step_09: Verify Success Message is display");
        verifyEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

        log.info("User_01_Register - Step_10: Verify Home Page is Display");
        homePage = registerPage.clickToLogoutLink();

        log.info("User_01_Register - Step_11: Verify Login Page is Display");
        loginPage = homePage.clickToLoginLink();

        log.info("User_01_Register - Step_12: Enter to Email Textbox: " + validEmail);
        loginPage.inputToEmailTextbox(validEmail);

        log.info("User_01_Register - Step_13: Enter to Pass Textbox: " + password);
        loginPage.inputToPasswordTextbox(password);

        log.info("User_01_Register - Step_14: Click Login button");
        homePage = loginPage.clickToLoginButton();

        log.info("User_01_Register - Step_15: Verify My Account link is display");
        veryfiTrue(homePage.isMyAccountLinkDisplay());

        log.info("User_01_Register - Step_16: Verify customer info page is display");
        customerInfoPage = homePage.clickToMyAccountLink();
    }


//    @Test
//    public void User_02_Switch_Page() {
//        addressesPage = customerInfoPage.openAddressesPage(driver);
//
//        myProductReviewPage = addressesPage.openMyProductReviewPage(driver);
//
//        orderPage = myProductReviewPage.openOrderPage(driver);
//
//        rewardPointsPage = orderPage.openRewardPointPage(driver);
//
//        addressesPage = rewardPointsPage.openAddressesPage(driver);
//
//    }
//
//    @Test
//    public void User_03_Dynamic_Page_01() {
//        customerInfoPage = (UserCustomerInfoPageObject) addressesPage.openPageMyAcountPageByName(driver,"Customer info");
//
//        myProductReviewPage = (UserMyProductReviewPageObject) customerInfoPage.openPageMyAcountPageByName(driver,"My product reviews");
//
//        orderPage = (UserOrderPageObject) myProductReviewPage.openPageMyAcountPageByName(driver,"Orders");
//
//        rewardPointsPage = (UserRewardPointsPageObject) orderPage.openPageMyAcountPageByName(driver,"Reward points");
//
//        addressesPage = (UserAddressesPageObject) rewardPointsPage.openPageMyAcountPageByName(driver,"Addresses");
//    }
//
//    @Test
//    public void User_03_Dynamic_Page_02() {
//        myProductReviewPage = (UserMyProductReviewPageObject) addressesPage.openPageMyAcountPageByName(driver,"My product reviews");
//
//        customerInfoPage = (UserCustomerInfoPageObject) myProductReviewPage.openPageMyAcountPageByName(driver,"Customer info");
//
//        myProductReviewPage = (UserMyProductReviewPageObject) customerInfoPage.openPageMyAcountPageByName(driver,"My product reviews");
//
//        orderPage = (UserOrderPageObject) myProductReviewPage.openPageMyAcountPageByName(driver,"Orders");
//
//        rewardPointsPage = (UserRewardPointsPageObject) orderPage.openPageMyAcountPageByName(driver,"Reward points");
//
//        addressesPage = (UserAddressesPageObject) rewardPointsPage.openPageMyAcountPageByName(driver,"Addresses");
//    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
