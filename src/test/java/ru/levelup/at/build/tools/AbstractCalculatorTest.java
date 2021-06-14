package ru.levelup.at.build.tools;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public abstract class AbstractCalculatorTest {

    protected Calculator calculator;

    @BeforeSuite
    public void calculatorSimpleSuiteSetUp() {
        System.out.println("calculatorSimpleSuiteSetUp");
    }

    @BeforeTest
    public void calculatorTestSetUp() {
        System.out.println("calculatorTestSetUp");
    }

    @BeforeClass
    public void calculatorSimple1ClassSetUp() {
        System.out.println("calculatorSimple1ClassSetUp");
    }

    @BeforeMethod
    public void calculatorSetUp() {
        System.out.println("calculatorSetUp");
        calculator = new Calculator();
    }

    @AfterMethod
    public void calculatorTearDown() {
        System.out.println("calculatorTearDown");
        calculator = null;
    }

    @AfterClass
    public void calculatorSimple1ClassTearDown() {
        System.out.println("calculatorSimple1ClassTearDown");
    }

    @AfterTest
    public void calculatorTestTearDown() {
        System.out.println("calculatorTestTearDown");
    }

    @AfterSuite
    public void calculatorSimpleSuiteTearDown() {
        System.out.println("calculatorSimpleSuiteTearDown");
    }
}
