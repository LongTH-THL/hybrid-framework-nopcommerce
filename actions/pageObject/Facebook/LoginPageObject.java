package pageObject.Facebook;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.Facebook.LoginPageUIs;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void clickToCreatNewAccountButton() {
        waitForElementClickable(driver, LoginPageUIs.CREAT_NEW_ACCOUNT_BUTTON);
        clickToElement(driver,LoginPageUIs.CREAT_NEW_ACCOUNT_BUTTON);
    }

    public boolean emailAddressTextboxIsDisplay() {
        waitForAllElementVisible(driver, LoginPageUIs.EMAIL_ADDRESS_TEXTBOX);
        return isElementDisplayed(driver, LoginPageUIs.EMAIL_ADDRESS_TEXTBOX);
    }

    public void enterToEmailAddressTextbox(String emailAddress) {
        waitForAllElementVisible(driver, LoginPageUIs.EMAIL_ADDRESS_TEXTBOX);
        sendkeyToElement(driver,LoginPageUIs.EMAIL_ADDRESS_TEXTBOX,emailAddress);
    }

    public boolean isConfirmEmailAddressTextboxDisplay() {
        return isElementDisplayed(driver,LoginPageUIs.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
    }

    public void clickCloseIconAtRegisterForm() {
        waitForElementClickable(driver, LoginPageUIs.CLOSE_ICON);
        clickToElement(driver, LoginPageUIs.CLOSE_ICON);
    }

    public boolean isConfirmEmailAddressTextboxUndisplay() {
        waitForElementUndisplay(driver, LoginPageUIs.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
        return isElementUndisplay(driver, LoginPageUIs.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
    }
}
