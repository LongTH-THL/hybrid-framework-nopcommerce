package com.jQuery;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.jQuery.DataTable.HomePageObject;
import pageObject.jQuery.DataTable.PageGeneratorManager;

import java.util.List;

public class User_01_DataTable_DataGrid extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    List<String> acctuaAllCountryValue;
    List<String> expectedAllCountryValue;


    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl){
        driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    public void Table_01_Paging(){
        homePage.openPagingByPageNumber("10");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isPageNumberActive("10"));

        homePage.openPagingByPageNumber("5");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isPageNumberActive("5"));

        homePage.openPagingByPageNumber("7");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isPageNumberActive("7"));

        homePage.openPagingByPageNumber("18");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isPageNumberActive("18"));

    }

    public void Table_02_Enter_To_Header() {
        homePage.enterToHeaderTextboxLabel("Country","Angola");
        homePage.enterToHeaderTextboxLabel("Females","276880");
        homePage.enterToHeaderTextboxLabel("Males","276472");
        homePage.enterToHeaderTextboxLabel("Total","553353");
        homePage.sleepInSecond(3);

        homePage.enterToHeaderTextboxLabel("Country","Argentina");
        homePage.enterToHeaderTextboxLabel("Females","338282");
        homePage.enterToHeaderTextboxLabel("Males","349238");
        homePage.enterToHeaderTextboxLabel("Total","687522");
        homePage.sleepInSecond(3);
    }


    public void Table_03_Get_Value_Each_Row_At_ALL_Page() {
        // ham doc du lieu file country.txt
        // doc xong luu vao List<String> = Expected Value = expectedAllCountryValue


        acctuaAllCountryValue = homePage.getValueEachRowAtAllPage();
    }

    @Test
    public void Table_04_Enter_To_Textbox_At_Any_Row(){
        homePage.clickToLoadButton();
        homePage.sleepInSecond(3);
        // Value de nhap du lieu
        // Row number
        // ColumnName = Album/ Artist/....
        homePage.enterToTextBoxByColumnNameAtAnyRowNumber("Album", "2", "Justin");
        homePage.enterToTextBoxByColumnNameAtAnyRowNumber("Artist", "4", "Baby");
        homePage.enterToTextBoxByColumnNameAtAnyRowNumber("Year", "3", "2014");
        homePage.enterToTextBoxByColumnNameAtAnyRowNumber("Price", "5", "10");

        homePage.selectDropdownByColumnNameAtAnyRowNumber("Origin","2","Hong Kong");
        homePage.sleepInSecond(2);
        homePage.selectDropdownByColumnNameAtAnyRowNumber("Origin","4","Japan");
        homePage.sleepInSecond(2);
        homePage.selectDropdownByColumnNameAtAnyRowNumber("Origin","1","US");
        homePage.sleepInSecond(2);
        homePage.selectDropdownByColumnNameAtAnyRowNumber("Origin","3","Taiwan");
        homePage.sleepInSecond(2);

        homePage.checkToCheckboxByColumnNameAtAnyRowNumber("With Poster?","3");
        homePage.sleepInSecond(2);
        homePage.checkToCheckboxByColumnNameAtAnyRowNumber("With Poster?","5");
        homePage.sleepInSecond(2);
        homePage.unCheckToCheckboxByColumnNameAtAnyRowNumber("With Poster?","1");
        homePage.sleepInSecond(2);
        homePage.unCheckToCheckboxByColumnNameAtAnyRowNumber("With Poster?","2");
        homePage.sleepInSecond(2);
        homePage.unCheckToCheckboxByColumnNameAtAnyRowNumber("With Poster?","4");
        homePage.sleepInSecond(2);

        homePage.clickToIconByRowNumber("1","Remove Current Row");
        homePage.clickToIconByRowNumber("1","Insert Row Above");
        homePage.clickToIconByRowNumber("1","Move Up");

        homePage.clickToIconByRowNumber("5","Remove Current Row");
        homePage.clickToIconByRowNumber("4","Remove Current Row");
        homePage.clickToIconByRowNumber("3","Remove Current Row");
        homePage.clickToIconByRowNumber("2","Remove Current Row");
        homePage.clickToIconByRowNumber("1","Remove Current Row");

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
