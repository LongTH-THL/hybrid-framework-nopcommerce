package pageObject.NopCommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommerce.user.CustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {
    WebDriver driver;

    public UserCustomerInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToNewsLetterCheckbox() {
    }

    public boolean idCustomerInfoPageDisplay() {
        waitForElementVisible(driver, CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
        return isElementDisplayed(driver,CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
    }
}
