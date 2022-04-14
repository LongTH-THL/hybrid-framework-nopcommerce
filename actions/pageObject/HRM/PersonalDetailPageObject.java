package pageObject.HRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class PersonalDetailPageObject extends BasePage {

    public WebDriver driver;

    public PersonalDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
