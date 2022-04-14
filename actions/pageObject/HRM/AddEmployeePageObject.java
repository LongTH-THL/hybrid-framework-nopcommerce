package pageObject.HRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AddEmployeePageObject extends BasePage {

    public WebDriver driver;

    public AddEmployeePageObject(WebDriver driver) {
        this.driver = driver;
    }
}
