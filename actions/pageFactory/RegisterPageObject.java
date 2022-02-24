package pageFactory;

import commons.Factory.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePageFactory {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstNameTextbox;
    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastNameTextbox;
    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailTextbox;
    @FindBy(xpath = "//input[@id='Password']")
    WebElement passwordTextbox;
    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    WebElement confirmPasswordTextbox;
    @FindBy(xpath = "//button[@id='register-button']")
    WebElement registerButton;

    @FindBy(xpath = "//span[@id='FirstName-error']")
    WebElement firstNameErrorMessage;
    @FindBy(xpath = "//span[@id='LastName-error']")
    WebElement lastNameErrorMessage;
    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement emailErrorMessage;
    @FindBy(xpath = "//span[@id='Password-error']")
    WebElement passwordErrorMessage;
    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    WebElement confirmPasswordErrorMessage;

    @FindBy(xpath = "//div[@class='result']")
    WebElement registerSuccessMessage;
    @FindBy(xpath = "//a[@class='ico-logout']")
    WebElement logoutLink;
    @FindBy(xpath = "//div[contains(@class,'message-error')]//li")
    WebElement exittingEmailErrorMessage;

    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(driver, registerButton);
    }

    public String getErrorMessageAtFirstnameTextbox() {
        waitForElementVisible(driver,firstNameErrorMessage);
        return getElementText(driver,firstNameErrorMessage);
    }

    public String getErrorMessageAtLastnameTextbox() {
        waitForElementVisible(driver,lastNameErrorMessage);
        return getElementText(driver,lastNameErrorMessage);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver,emailErrorMessage);
        return getElementText(driver,emailErrorMessage);
    }

    public String getErrorMessageAtPasswordTextbox() {
        waitForElementVisible(driver,passwordErrorMessage);
        return getElementText(driver,passwordErrorMessage);
    }

    public String getErrorMessageAtConfirmPasswodTextbox() {
        waitForElementVisible(driver,confirmPasswordErrorMessage);
        return getElementText(driver,confirmPasswordErrorMessage);
    }

    public String getErrorExitingEmailMessage() {
        waitForElementVisible(driver,exittingEmailErrorMessage);
        return getElementText(driver,exittingEmailErrorMessage);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver,registerSuccessMessage);
        return getElementText(driver,registerSuccessMessage);
    }

    public void inputToFirstnameTextbox(String firstName) {
        waitForElementVisible(driver,firstNameTextbox);
        sendkeyToElement(driver,firstNameTextbox,firstName);
    }

    public void inputToLastnameTextbox(String lastName) {
        waitForElementVisible(driver,lastNameTextbox);
        sendkeyToElement(driver,lastNameTextbox,lastName);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver,emailTextbox);
        sendkeyToElement(driver,emailTextbox,email);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver,passwordTextbox);
        sendkeyToElement(driver,passwordTextbox,password);
    }

    public void inputToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver,confirmPasswordTextbox);
        sendkeyToElement(driver,confirmPasswordTextbox,confirmPassword);
    }

    public UserHomePageObject clickToLogoutLink() {
        waitForElementClickable(driver,logoutLink);
        clickToElement(driver,logoutLink);
        return new UserHomePageObject(driver);
    }
}
