package reportConfig;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import commons.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportNG implements ITestListener {
    String projectLocator = System.getProperty("user.dir") + "/ReportNGScreenShots/";

    @Override
    public void onFinish(ITestContext arg0) {

    }

    @Override
    public void onStart(ITestContext arg0) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.setProperty("org.uncommons.reportng.escape-output", "false");

        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getWebDriver();

        String screenshotPath = captureScreenshot(webDriver, result.getName());
        Reporter.getCurrentTestResult();
        Reporter.log("<br><a target=\"_blank\" href=\"file:///" + screenshotPath + "\">" + "<img src=\"file:///" + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
        Reporter.setCurrentTestResult(null);
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {

    }

    @Override
    public void onTestStart(ITestResult arg0) {

    }

    @Override
    public void onTestSuccess(ITestResult arg0) {

    }

    public String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenPath = projectLocator + screenshotName + "_" + formater.format(calendar.getTime()) + ".png";
            FileUtils.copyFile(source, new File(screenPath));
            return screenPath;
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
            return e.getMessage();
        }
    }

}