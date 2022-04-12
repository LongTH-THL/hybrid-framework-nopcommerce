package pageObject.NopCommerce.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommerce.user.LoginPageUi;

public class UserLoginPageObject extends BasePage {
    private WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserHomePageObject clickToLoginButton() {
        waitForElementVisible(driver, LoginPageUi.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUi.LOGIN_BUTTON);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, LoginPageUi.EMAIL_TEXTBOX);
        sendkeyToElement(driver,LoginPageUi.EMAIL_TEXTBOX,email);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver,LoginPageUi.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUi.PASSWORD_TEXTBOX,password);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver, LoginPageUi.EMAIL_ERROR_MESSSAGE);
        return getElementText(driver,LoginPageUi.EMAIL_ERROR_MESSSAGE);
    }

    public String getErrorMessageUnsuccessfull() {
        waitForElementVisible(driver, LoginPageUi.EMAIL_ERROR_MESSSAGE_UNSUCCESS_FULL);
        return getElementText(driver, LoginPageUi.EMAIL_ERROR_MESSSAGE_UNSUCCESS_FULL);
    }

    public UserHomePageObject loginAsUser(String email, String password) {
        inputToEmailTextbox(email);
        inputToPasswordTextbox(password);
        return clickToLoginButton();
    }

    public UserHomePageObject openHomePage() {
        waitForElementClickable(driver, LoginPageUi.HOMEPAGE_IMG);
        clickToElement(driver, LoginPageUi.HOMEPAGE_IMG);
        return PageGeneratorManager.getUserHomePage(driver);
    }
}
