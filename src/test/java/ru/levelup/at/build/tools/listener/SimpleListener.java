package ru.levelup.at.build.tools.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class SimpleListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(String.format("Test %s is started", result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(String.format("Test %s is finished with SUCCESS status",
            result.getMethod().getMethodName()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(String.format("Test %s is finished with FAILED status",
            result.getMethod().getMethodName()));
    }
}
