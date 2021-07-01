package ru.levelup.at.selenium.allure.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final int LIMIT = 3;
    private int retryCounter = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCounter < LIMIT) {
            retryCounter++;
            return true;
        }
        return false;
    }
}
