package pageObject.HRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HRM.PersonalDetailPageUI;

public class PersonalDetailPageObject extends BasePage {

    public WebDriver driver;

    public PersonalDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToChangePhotoImage() {
        waitForElementClickable(driver, PersonalDetailPageUI.AVATAR_IMAGE);
        clickToElement(driver, PersonalDetailPageUI.AVATAR_IMAGE);
    }

    public Boolean isUploadAvatarSuccessMessageDisplayed() {
        waitForAllElementVisible(driver, PersonalDetailPageUI.UPLOAD_AVATAR_SUCCESS_MESSAGE);
        return isElementDisplayed(driver, PersonalDetailPageUI.UPLOAD_AVATAR_SUCCESS_MESSAGE);
    }

    public boolean isNewAvatarImageDisplayed() {
        waitForAllElementVisible(driver, PersonalDetailPageUI.AVATAR_IMAGE);
        int imageWidth = Integer.parseInt(getElementAttribute(driver, PersonalDetailPageUI.AVATAR_IMAGE,"width"));
        int imageHeight = Integer.parseInt(getElementAttribute(driver, PersonalDetailPageUI.AVATAR_IMAGE,"height"));
        return (imageWidth!=200)||(imageHeight!=200);
    }
}
