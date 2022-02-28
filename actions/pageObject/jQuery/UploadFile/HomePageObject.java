package pageObject.jQuery.UploadFile;

import commons.Nopcommerce.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jQuery.UploadFile.HomePageUI;

import java.util.List;

public class HomePageObject extends BasePage {
    WebDriver driver;
    public HomePageObject(WebDriver driver){
        this.driver = driver;
    }

    public boolean isFileLoadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_NAME_LOADING, fileName);
        return isElementDisplayed(driver, HomePageUI.FILE_NAME_LOADING, fileName);
    }

    public boolean isFileLinkUploadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
        return isElementDisplayed(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
    }

    public boolean isFileImgUploadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_IMG, fileName);
        return isImageLoaded(driver, HomePageUI.FILE_NAME_UPLOADED_IMG, fileName);
    }

    public void clickToStartButton() {
        List<WebElement> startButtons = getListWebElement(driver, HomePageUI.START_BUTTON);

        for (WebElement startButton: startButtons){
            startButton.click();
            sleepInSecond(2);
        }
    }
}
