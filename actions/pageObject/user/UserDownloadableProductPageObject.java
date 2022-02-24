package pageObject.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserDownloadableProductPageObject extends BasePage {
    WebDriver driver;

    public UserDownloadableProductPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
