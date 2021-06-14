package ru.levelup.at.build.tools;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class CalculatorSimple2Test {

    private Calculator calculator;

    @BeforeSuite
    public void calculatorSimpleSuiteSetUp() {
        System.out.println("calculatorSimpleSuiteSetUp");
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

    @Test
    public void addTest() {
        System.out.println("addTest");
        Double actualValue = calculator.add(2.0, 2.0);
        final Double expectedValue = 4.0D;

        assertEquals(actualValue, expectedValue);
    }

    @Test
    public void subtractTest() {
        System.out.println("subtractTest");
        Double actualValue = calculator.subtract(2.0, 2.0);
        final Double expectedValue = 0.0D;

        assertEquals(actualValue, expectedValue);
    }

    @Test
    @Ignore
    public void addFailWithAssertEqualsTest() {
        System.out.println("addFailWithAssertEqualsTest");
        Double actualValue = calculator.add(4.0, 5.0);
        final Double expectedValue = 6.0D;

        assertEquals(actualValue, expectedValue, 0.0001);
    }

    @Test(enabled = false)
    public void addFailWithAssertEqualsAndDoubleCompareTest() {
        System.out.println("addFailWithAssertEqualsAndDoubleCompareTest");
        Double actualValue = calculator.add(3.0, 2.0);
        final Double expectedValue = 8.0D;

        assertEquals(Double.compare(actualValue, expectedValue), 0);
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

    @AfterSuite
    public void calculatorSimpleSuiteTearDown() {
        System.out.println("calculatorSimpleSuiteTearDown");
    }
}
