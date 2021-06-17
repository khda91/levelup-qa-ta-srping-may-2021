package ru.levelup.at.build.tools;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorSimpleListenerTest {
    Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void addTest() {
        Double actualValue = calculator.add(2.0, 2.0);
        final Double expectedValue = 4.0D;

        assertEquals(actualValue, expectedValue);
    }

    @Test
    public void addFailWithAssertEqualsTest() {
        Double actualValue = calculator.add(4.0, 5.0);
        final Double expectedValue = 6.0D;

        assertEquals(actualValue, expectedValue, 0.0001);
    }

    @Test
    public void addFailWithAssertEqualsAndDoubleCompareTest() {
        Double actualValue = calculator.add(3.0, 2.0);
        final Double expectedValue = 8.0D;

        assertEquals(Double.compare(actualValue, expectedValue), 0);
    }
}
