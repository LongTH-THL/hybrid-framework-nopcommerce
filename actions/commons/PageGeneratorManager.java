package commons;

import org.openqa.selenium.WebDriver;
import pageObject.admin.AdminDashboardPageObject;
import pageObject.admin.AdminLoginPageObject;
import pageObject.user.*;

public class PageGeneratorManager {
    public static UserCustomerInfoPageObject getMyAccountPage(WebDriver driver){
        return new UserCustomerInfoPageObject(driver);
    }

    public static UserHomePageObject getUserHomePage(WebDriver driver){
        return new UserHomePageObject(driver);
    }

     public static UserLoginPageObject getUserLoginPage(WebDriver driver){
        return new UserLoginPageObject(driver);
    }

    public static UserRegisterPageObject getUserRegisterPage(WebDriver driver){
        return new UserRegisterPageObject(driver);
    }

    public static UserAddressesPageObject getUserAddressesPage(WebDriver driver){
        return new UserAddressesPageObject(driver);
    }

    public static UserMyProductReviewPageObject getUserMyProductReviewPage(WebDriver driver){
        return new UserMyProductReviewPageObject(driver);
    }

    public static UserRewardPointsPageObject getUserRewardPointsPage(WebDriver driver){
        return new UserRewardPointsPageObject(driver);
    }

    public static UserOrderPageObject getUserOrderPage(WebDriver driver) {
        return new UserOrderPageObject(driver);
    }

    public static UserDownloadableProductPageObject getUserDownloadableProductPage(WebDriver driver) {
        return new UserDownloadableProductPageObject(driver);
    }

    public static UserBackInStockSubscriptionsPageObject getuserBackInStockSubscriptions(WebDriver driver) {
        return new UserBackInStockSubscriptionsPageObject(driver);
    }

    public static UserCustomerInfoPageObject getUserCustomerPage(WebDriver driver) {
        return new UserCustomerInfoPageObject(driver);
    }

    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPageObject(driver);
    }

    public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
        return new AdminDashboardPageObject(driver);
    }
}
