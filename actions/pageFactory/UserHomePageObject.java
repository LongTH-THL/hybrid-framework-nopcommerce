package pageFactory;

import commons.Factory.BasePageFactory;
import commons.Nopcommerce.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageObject.NopCommerce.user.UserLoginPageObject;
import pageObject.NopCommerce.user.UserCustomerInfoPageObject;
import pageObject.NopCommerce.user.UserRegisterPageObject;

public class UserHomePageObject extends BasePageFactory {
    private WebDriver driver;

    public UserHomePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Page UIs
    @FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
    private WebElement registerLink;

    @FindBy(xpath = "//a[@class='ico-login']")
    private WebElement loginLink;

    @FindBy(xpath = "//a[text()='My account']")
    private WebElement myAccountLink;

    // Page Object/ Action

    public UserRegisterPageObject clickToRegisterLink() {
        waitForElementClickable(driver, registerLink);
        clickToElement(driver,registerLink);
        return PageGeneratorManager.getUserRegisterPage(driver);
    }

    public UserLoginPageObject clickToLoginLink() {
        waitForElementClickable(driver, loginLink);
        clickToElement(driver, loginLink);
        return PageGeneratorManager.getUserLoginPage(driver);
    }

    public boolean isMyAccountLinkDisplay() {
        waitForElementVisible(driver, myAccountLink);
        return isElementDisplayed(driver, myAccountLink);
    }

    public UserCustomerInfoPageObject clickToMyAccount() {
        waitForElementClickable(driver, myAccountLink);
        clickToElement(driver,myAccountLink);
        return PageGeneratorManager.getMyAccountPage(driver);
    }
}
