package ru.levelup.at.build.tools;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CalculatorSubtractTest extends AbstractCalculatorTest {

    @BeforeSuite
    public void calculatorSubtractSuiteSetUp() {
        System.out.println("calculatorSubtractSuiteSetUp");
    }

    @Test
    public void subtractTest() {
        System.out.println("subtractTest");
        Double actualValue = calculator.subtract(2.0, 2.0);
        final Double expectedValue = 0.0D;

        assertEquals(actualValue, expectedValue);
    }
}
