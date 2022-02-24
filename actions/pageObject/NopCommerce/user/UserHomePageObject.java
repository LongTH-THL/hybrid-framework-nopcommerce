package pageObject.NopCommerce.user;

import commons.Nopcommerce.BasePage;
import commons.Nopcommerce.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommerce.user.HomePageUI;

public class UserHomePageObject extends BasePage {
    WebDriver driver;

    public UserHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegisterPageObject openToRegisterPage() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGeneratorManager.getUserRegisterPage(driver);
    }

    public UserLoginPageObject openToLoginPage() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return PageGeneratorManager.getUserLoginPage(driver);
    }

    public UserCustomerInfoPageObject openToMyAccountPage() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getUserCustomerPage(driver);
    }

    public boolean isMyAccountLinkDisplay() {
        waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
    }

}
