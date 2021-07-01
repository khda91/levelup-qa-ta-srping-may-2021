package ru.levelup.at.selenium.allure.listeners;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureAttachmentListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("web.driver");
        takeScreenshotAttachment(driver);
        getPageSource(driver);
    }

    private void getPageSource(WebDriver driver) {
        Allure.addAttachment(driver.getTitle(), "text/html", driver.getPageSource());
    }

    @Attachment(type = "image/png", fileExtension = "png")
    private byte[] takeScreenshotAttachment(WebDriver driver) {
        return takeScreenshot(driver);
    }

    private byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
