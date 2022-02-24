package pageObject.NopCommerce.admin;

import commons.Nopcommerce.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommerce.admin.DashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
    WebDriver driver;
    public AdminDashboardPageObject(WebDriver driver){
        this.driver = driver;
    }

    public boolean isDashboardHeaderDisplay(){
        return isElementDisplayed(driver, DashboardPageUI.DASHBOARD_HEADER);
    }
}
