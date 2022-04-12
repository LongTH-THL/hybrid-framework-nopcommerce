package com.HRM;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.HRM.*;

import java.lang.reflect.Method;

public class Live_Coding_HRM extends BaseTest {
    private WebDriver driver;
    String employeeID, statusValue;

    LoginPageObject loginPage;
    AddEmployeePageObject addEmployeePage;
    DashboardPageObject dashboardPage;
    EmployeeListPageObject employeeListPage;
    PersonalDetailPageObject personalDetailPage;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl, Method method){
        log.info("Pre-Condition - Step 01: Open browser'" + browserName + "'and navigate to '" + appUrl + "'");
        driver = getBrowserDriver(browserName, appUrl);

        statusValue = "Enable";

        loginPage = PageGenerator.getLoginPage(driver);
        log.info("Pre-Condition - Step 02: Login with Admin Role");
        loginPage.enterToTextboxByID(driver,"txtUsername","Admin");
        loginPage.enterToTextboxByID(driver,"txtPassword","admin123");
        loginPage.clickToButtonByID(driver,"btnLogin");
        dashboardPage = PageGenerator.getDashboardPage(driver);


    }

    @Test
    public void Employee_01_Add_New_Employee(){
        log.info("Add_New_01 - Step 01: Open Employee List Page");
        dashboardPage.openSubMenu(driver, "PIM", "Employee List");
        employeeListPage = PageGenerator.getEmployeeList(driver);

        log.info("Add_New_01 - Step 02: Click to 'Add' button");
        employeeListPage.clickToButtonByID(driver,"btnAdd");
        addEmployeePage = PageGenerator.getAddEmployeePage(driver);

        log.info("Add_New_01 - Step 03: Enter valid info to 'First Name' textbox");
        addEmployeePage.enterToTextboxByID(driver,"firstName","Automation");

        log.info("Add_New_01 - Step 04: Enter valid info to 'Last Name' textbox");
        addEmployeePage.enterToTextboxByID(driver,"lastName","FC");

        log.info("Add_New_01 - Step 05: Get value of 'Employee ID'");
        employeeID = addEmployeePage.getTextboxValueByID(driver,"employeeId");

        log.info("Add_New_01 - Step 06: Click to 'Creat Login Details' checkbox");
        addEmployeePage.clickToCheckboxByLabel(driver,"Creat Login Details");

        log.info("Add_New_01 - Step 07: Enter valid info to 'User Name' textbox");
        addEmployeePage.enterToTextboxByID(driver,"user_name","long_magic");

        log.info("Add_New_01 - Step 08: Enter valid info to 'Password' textbox");
        addEmployeePage.enterToTextboxByID(driver,"user_password","12345678");

        log.info("Add_New_01 - Step 09: Enter valid info to 'Confirm Password' textbox");
        addEmployeePage.enterToTextboxByID(driver,"re_password","12345678");

        log.info("Add_New_01 - Step 10: Select '" +statusValue+ "' value in 'Status' dropdown");
        addEmployeePage.selectItemInDropdownByID(driver,"status", statusValue);

        log.info("Add_New_01 - Step 11: Click to 'Save' button");
        addEmployeePage.clickToButtonByID(driver,"btnSave");
        personalDetailPage = PageGenerator.getPersonalDetailsPage(driver);

        log.info("Add_New_01 - Step 12: Open Employee List Page");
        personalDetailPage.openSubMenu(driver,"PIM","Employee List");
        employeeListPage = PageGenerator.getEmployeeList(driver);

        log.info("Add_New_01 - Step 13: Enter valid info to 'Employee Name' textbox");
        employeeListPage.enterToTextboxByID(driver,"empsearch_employee_name_empName"," Automation");

        log.info("Add_New_01 - Step 14: Click to 'Search' button");
        employeeListPage.clickToButtonByID(driver,"searchBtn");

        log.info("Add_New_01 - Step 15: Verify Employee Information displayed at 'Table'");
        verifyEquals(employeeListPage.getElementText(driver,"resultTable","ID","1"),employeeID);
        verifyEquals(employeeListPage.getElementText(driver,"resultTable","Last Name","1"),"FC");

    }

    @Test
    public void Employee_02_Upload_Avatar(){
    }

    @Test
    public void Employee_03_Persional_Details(){
    }

    @Test
    public void Employee_04_Contact_Details(){
    }

    @Test
    public void Employee_05_Emergency_Details(){
    }

    @Test
    public void Employee_06_Assigned_Dependents(){
    }

    @Test
    public void Employee_07_Edit_View_Job(){
    }

    @Test
    public void Employee_08_Edit_View_Salary(){
    }

    @Test
    public void Employee_09_Edit_View_Tax(){
    }

    @Test
    public void Employee_10_Qualification(){
    }

    @Test
    public void Employee_11_Search_Employee(){
    }



    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
