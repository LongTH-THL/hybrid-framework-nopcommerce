package pageObject.admin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.LoginPageUI;

public class AdminLoginPageObject extends BasePage {
    WebDriver driver;
    public AdminLoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void inputToUserNameTextbox(String email){
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToPasswordTextbox(String password){
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public AdminDashboardPageObject clickToLoginButton(){
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getAdminDashboardPage(driver);
    }

    public AdminDashboardPageObject LoginAdmin(String email, String password){
        inputToUserNameTextbox(email);
        inputToPasswordTextbox(password);
        return clickToLoginButton();
    }
}
