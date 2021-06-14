package ru.levelup.at.build.tools;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalculatorSimpleTest1 {

    @Test
    public void addTest() {
        Calculator calculator = new Calculator();
        Double actualValue = calculator.add(2.0, 2.0);
        final Double expectedValue = 4.0D;

        assertEquals(actualValue, expectedValue);
    }
}
