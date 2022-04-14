package pageObject.HRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class EmployeeListPageObject extends BasePage {

    public WebDriver driver;

    public EmployeeListPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
