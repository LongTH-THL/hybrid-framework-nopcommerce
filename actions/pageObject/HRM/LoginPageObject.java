package pageObject.HRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HRM.LoginPageUI;

public class LoginPageObject extends BasePage {

    public WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
