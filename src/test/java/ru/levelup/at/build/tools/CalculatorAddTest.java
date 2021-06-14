package ru.levelup.at.build.tools;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CalculatorAddTest extends AbstractCalculatorTest {

    @BeforeSuite
    public void calculatorAddSuiteSetUp() {
        System.out.println("calculatorAddSuiteSetUp");
    }

    @Test
    public void addTest() {
        System.out.println("addTest");
        Double actualValue = calculator.add(2.0, 2.0);
        final Double expectedValue = 4.0D;

        assertEquals(actualValue, expectedValue);
    }
}
