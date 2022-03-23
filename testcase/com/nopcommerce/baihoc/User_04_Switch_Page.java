package com.nopcommerce.baihoc;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObject.user.*;

public class User_04_Switch_Page extends BaseTest {
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

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName, String appUrl){
        driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = "automation";
        lastName = "FC";
        password = "123456";
        validEmail = "auto" + randomData() + "@gmail.com";
    }

    @Test
    public void User_01_Register(){
        registerPage = homePage.clickToRegisterLink();

        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox(validEmail);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

        homePage = registerPage.clickToLogoutLink();
    }

    @Test
    public void User_02_Login(){
        loginPage = homePage.clickToLoginLink();

        loginPage.inputToEmailTextbox(validEmail);
        loginPage.inputToPasswordTextbox(password);
        homePage = loginPage.clickToLoginButton();

        Assert.assertTrue(homePage.isMyAccountLinkDisplay());

    }

    @Test
    public void User_03_My_Account(){
        customerInfoPage = homePage.clickToMyAccountLink();

        Assert.assertTrue(customerInfoPage.idCustomerInfoPageDisplay());

    }

    @Test
    public void User_04_Switch_Page(){
        addressesPage = customerInfoPage.openAddressesPage(driver);

        myProductReviewPage = addressesPage.openMyProductReviewPage(driver);

        orderPage = myProductReviewPage.openOrderPage(driver);

        rewardPointsPage = orderPage.openRewardPointPage(driver);

        addressesPage = rewardPointsPage.openAddressesPage(driver);

    }

    @Test
    public void User_05_Switch_Role(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
