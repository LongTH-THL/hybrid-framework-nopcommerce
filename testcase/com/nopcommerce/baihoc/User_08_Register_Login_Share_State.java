//package com.nopcommerce.baihoc;
//
//import com.nopcommerce.commons.Commons_01_Login;
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//import pageObject.user.*;
//
//public class User_08_Register_Login_Share_State extends BaseTest {
//    private WebDriver driver;
//    private UserHomePageObject homePage;
//    private UserLoginPageObject loginPage;
//
//
//
//    private String validEmail, password;
//
//    @Parameters({"browser","url"})
//    @BeforeClass
//    public void beforeTest(String browserName, String appUrl){
//        driver = getBrowserDriver(browserName, appUrl);
//        homePage = PageGeneratorManager.getUserHomePage(driver);
//
//        log.info("User_01_Login - Step_01: Click to Login link");
//        loginPage = homePage.clickToLoginLink();
//
//        log.info("User_01_Login - Step_02: Set Login Page Cookie");
//        loginPage.setAllCookies(driver, Commons_01_Login.loginPageCookie);
//        loginPage.sleepInSecond(3);
//        loginPage.refreshCurrentPage(driver);
//
//        log.info("User_01_Login - Step_03: Click To HomePage Img");
//        loginPage.openHomePage();
//
//        log.info("User_01_Login - Step_04: Verify My Account Link is Display");
//        homePage = PageGeneratorManager.getUserHomePage(driver);
//        veryfiTrue(homePage.isMyAccountLinkDisplay());
//    }
//
//    @Test
//    public void TC_01_Login_To_System(){
//    }
//
//    @AfterClass
//    public void afterClass(){
//        driver.quit();
//    }
//
//}
