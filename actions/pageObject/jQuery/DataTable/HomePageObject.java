package pageObject.jQuery.DataTable;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jQuery.DataTable.HomePageUI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomePageObject extends BasePage {
    WebDriver driver;
    public HomePageObject(WebDriver driver){
        this.driver = driver;
    }

    public void openPagingByPageNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER,pageNumber);
        clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER,pageNumber);
    }

    public void enterToHeaderTextboxLabel(String headerLable, String value) {
        waitForElementVisible(driver,HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME,headerLable);
        sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, value, headerLable);
        pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, Keys.RETURN, headerLable);
    }

    public boolean isPageNumberActive(String pageNumber) {
        waitForElementVisible(driver,HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER);
        return isElementDisplayed(driver,HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER,pageNumber);
    }

    public List<String> getValueEachRowAtAllPage() {
        // lấy ra số lượng page
        int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
        List<String> allRowValue = new ArrayList<String>();
        // Khong luu trung nhau
        Set<String> allRowUniqueValue = new HashSet<String>();

        // duyệt qua tất cả các page
        for (int index = 1; index <= totalPage; index ++){
            clickToElement(driver,HomePageUI.PAGINATION_INDEX,String.valueOf(index));

            // lấy ra giá trị các row trong tất cả các page
            List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
            for (WebElement eachRow:allRowElementEachPage){
                allRowUniqueValue.add(eachRow.getText());
            }
        }

        // in ra man hinh tat ca cac row cua cac page
        for (String value:allRowUniqueValue){
            System.out.println(value);
        }
        return  allRowValue;
    }

    public void enterToTextBoxByColumnNameAtAnyRowNumber(String columnName, String rowNumber, String value) {
        // Lay ra column index dua vao ten cot
        int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

        // sendkey
        waitForElementVisible(driver,HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber, String.valueOf(columnIndex));
        sendkeyToElement(driver,HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,value,rowNumber, String.valueOf(columnIndex));
    }

    public void selectDropdownByColumnNameAtAnyRowNumber(String columnName, String rowNumber, String value) {
        int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

        waitForElementVisible(driver,HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber, String.valueOf(columnIndex));
        selectItemInDefaultDropdown(driver,HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX,value,rowNumber, String.valueOf(columnIndex));
    }

    public void clickToLoadButton() {
        waitForElementClickable(driver,HomePageUI.LOAD_BUTTON);
        clickToElement(driver, HomePageUI.LOAD_BUTTON);
    }

    public void checkToCheckboxByColumnNameAtAnyRowNumber(String columnName, String rowNumber) {
        int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
        waitForElementClickable(driver,HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber, String.valueOf(columnIndex));
        checkToDefaultCheckboxOrRadio(driver,HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber, String.valueOf(columnIndex));
    }

    public void unCheckToCheckboxByColumnNameAtAnyRowNumber(String columnName, String rowNumber) {
        int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
        waitForElementClickable(driver,HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber, String.valueOf(columnIndex));
        uncheckToDefaultCheckbox(driver,HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber, String.valueOf(columnIndex));
    }

    public void clickToIconByRowNumber(String rowNumber, String iconName) {
        waitForElementClickable(driver,HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
        clickToElement(driver,HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
    }
}
