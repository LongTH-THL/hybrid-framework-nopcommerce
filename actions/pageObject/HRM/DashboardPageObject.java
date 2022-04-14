package pageObject.HRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class DashboardPageObject extends BasePage {

    public WebDriver driver;

    public DashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
