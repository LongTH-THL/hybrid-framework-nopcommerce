package pageObject.NopCommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserOrderPageObject extends BasePage {
    WebDriver driver;

    public UserOrderPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
