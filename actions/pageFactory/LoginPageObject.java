package pageFactory;

import commons.Factory.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePageFactory {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordTextbox;

    @FindBy(xpath = "//button[contains(@class,'login-button')]")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@id='Email-error']")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//div[contains(@class,'message-error')]")
    private WebElement getEmailErrorMessageUnsuccessFull;

    public UserHomePageObject clickToLoginButton() {
        waitForElementVisible(driver, loginButton);
        clickToElement(driver,loginButton);
        return new UserHomePageObject(driver);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, emailTextbox);
        sendkeyToElement(driver,emailTextbox,email);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver,passwordTextbox);
        sendkeyToElement(driver, passwordTextbox,password);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver,emailErrorMessage);
        return getElementText(driver,emailErrorMessage);
    }

    public String getErrorMessageUnsuccessfull() {
        waitForElementVisible(driver, getEmailErrorMessageUnsuccessFull);
        return getElementText(driver, getEmailErrorMessageUnsuccessFull);
    }


}
