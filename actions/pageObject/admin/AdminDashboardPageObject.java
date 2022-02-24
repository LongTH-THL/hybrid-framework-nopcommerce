package pageObject.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.DashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
    WebDriver driver;
    public AdminDashboardPageObject(WebDriver driver){
        this.driver = driver;
    }

    public boolean isDashboardHeaderDisplay(){
        return isElementDisplayed(driver, DashboardPageUI.DASHBOARD_HEADER);
    }
}
