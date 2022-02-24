package pageObject.NopCommerce.user;

import commons.Nopcommerce.BasePage;
import commons.Nopcommerce.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageFactory.UserHomePageObject;
import pageUIs.NopCommerce.user.RegisterPageUi;

public class UserRegisterPageObject extends BasePage {
    private WebDriver driver;

    public UserRegisterPageObject(WebDriver driver){
        this.driver = driver;
    }
    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUi.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUi.REGISTER_BUTTON);
    }

    public String getErrorMessageAtFirstnameTextbox() {
        waitForElementVisible(driver,RegisterPageUi.FIRST_NAME_ERROR_MESSAGE);
        return getElementText(driver,RegisterPageUi.FIRST_NAME_ERROR_MESSAGE);
    }

    public String getErrorMessageAtLastnameTextbox() {
        waitForElementVisible(driver,RegisterPageUi.LAST_NAME_ERROR_MESSAGE);
        return getElementText(driver,RegisterPageUi.LAST_NAME_ERROR_MESSAGE);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver,RegisterPageUi.EMAIL_ERROR_MESSAGE);
        return getElementText(driver,RegisterPageUi.EMAIL_ERROR_MESSAGE);
    }

    public String getErrorMessageAtPasswordTextbox() {
        waitForElementVisible(driver,RegisterPageUi.PASSWORD_ERROR_MESSAGE);
        return getElementText(driver,RegisterPageUi.PASSWORD_ERROR_MESSAGE);
    }

    public String getErrorMessageAtConfirmPasswodTextbox() {
        waitForElementVisible(driver,RegisterPageUi.CONFIRM_PASSWORD_ERROR_MESSAGE);
        return getElementText(driver,RegisterPageUi.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    public String getErrorExitingEmailMessage() {
        waitForElementVisible(driver,RegisterPageUi.EXITING_EMAIL_ERROR_MESSAGE);
        return getElementText(driver,RegisterPageUi.EXITING_EMAIL_ERROR_MESSAGE);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver,RegisterPageUi.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver,RegisterPageUi.REGISTER_SUCCESS_MESSAGE);
    }

    public void inputToFirstnameTextbox(String firstName) {
        waitForElementVisible(driver,RegisterPageUi.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUi.FIRST_NAME_TEXTBOX,firstName);
    }

    public void inputToLastnameTextbox(String lastName) {
        waitForElementVisible(driver,RegisterPageUi.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUi.LAST_NAME_TEXTBOX,lastName);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver,RegisterPageUi.EMAIL_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUi.EMAIL_TEXTBOX,email);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver,RegisterPageUi.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUi.PASSWORD_TEXTBOX,password);
    }

    public void inputToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver,RegisterPageUi.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUi.CONFIRM_PASSWORD_TEXTBOX,confirmPassword);
    }

    public UserHomePageObject clickToLogoutLink() {
        waitForElementClickable(driver,RegisterPageUi.LOGOUT_LINK);
        clickToElement(driver,RegisterPageUi.LOGOUT_LINK);
        return PageGeneratorManager.getUserHomePage(driver);
    }


}
