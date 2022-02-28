package com.nopcommerce.baihoc;

import commons.Nopcommerce.BaseTest;
import commons.Nopcommerce.GlobalConstains;
import commons.Nopcommerce.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.UserHomePageObject;
import pageObject.NopCommerce.admin.AdminDashboardPageObject;
import pageObject.NopCommerce.admin.AdminLoginPageObject;
import pageObject.NopCommerce.user.*;

public class User_05_Switch_Role extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject userHomePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject userLoginPage;
    private UserCustomerInfoPageObject userMyAccoutPageObject;
    private UserAddressesPageObject addressesPage;
    private UserMyProductReviewPageObject myProductReviewPage;
    private UserOrderPageObject orderPage;
    private UserRewardPointsPageObject rewardPointsPage;
    private AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;

    private String userEmail, userPassword;
    private String adminEmail, adminPassword;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName, String appUrl){
        driver = getBrowserDriver(browserName, appUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        userPassword = "123456";
        userEmail = "long1@gmail.com";
        adminEmail = "admin@yourstore.com";
        adminPassword = "admin";
    }

    @Test
    public void Role_01_User_To_Admin(){
        userLoginPage = userHomePage.clickToLoginLink();
        userHomePage = userLoginPage.loginAsUser(userEmail, userPassword);

        userMyAccoutPageObject = userHomePage.clickToMyAccount();

        userHomePage = userMyAccoutPageObject.clickTOLogoutLinkAtUser(driver);

        userHomePage.openPageUrl(driver, GlobalConstains.ADMIN_PAGE_URL);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

        adminDashboardPage = adminLoginPage.LoginAdmin(adminEmail, adminPassword);
        Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplay());

        adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdmin(driver);
    }

    @Test
    public void Role_02_Admin(){
        adminLoginPage.openPageUrl(driver, GlobalConstains.PORTAL_PAGE_URL);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        userLoginPage = userHomePage.clickToLoginLink();
        userHomePage = userLoginPage.loginAsUser(userEmail, userPassword);
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplay());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
