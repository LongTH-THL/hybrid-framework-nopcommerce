package com.jQuery;

import commons.Nopcommerce.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.jQuery.UploadFile.HomePageObject;
import pageObject.jQuery.UploadFile.PageGeneratorManager;

public class User_02_Upload_File extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    String picnicFileName = "Picnic.jpg";
    String aDaoFileName = "a Dao.jpeg";
    String[] multipleFileNames= {aDaoFileName};


    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl){
        driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void Upload_01_One_File_Per_Time(){
        homePage.uploadMultipleFile(driver, aDaoFileName);
        Assert.assertTrue(homePage.isFileLoadedByName(aDaoFileName));

        homePage.clickToStartButton();

        Assert.assertTrue(homePage.isFileLinkUploadedByName(aDaoFileName));
        Assert.assertTrue(homePage.isFileImgUploadedByName(aDaoFileName));
    }


    @Test
    public void Upload_02_Multiple_File_Per_Time(){
        homePage.refreshCurrentPage(driver);

        homePage.uploadMultipleFile(driver,multipleFileNames);
        Assert.assertTrue(homePage.isFileLoadedByName(aDaoFileName));

        homePage.clickToStartButton();

        Assert.assertTrue(homePage.isFileLinkUploadedByName(aDaoFileName));
        Assert.assertTrue(homePage.isFileImgUploadedByName(aDaoFileName));
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
