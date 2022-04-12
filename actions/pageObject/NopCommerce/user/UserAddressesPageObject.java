package pageObject.NopCommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserAddressesPageObject extends BasePage {
    WebDriver driver;

    public UserAddressesPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
