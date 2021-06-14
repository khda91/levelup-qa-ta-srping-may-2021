package ru.levelup.at.build.tools;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSimpleDataProviderTest {

    Calculator calculator;

    @DataProvider
    public Object[][] addDataProvider() {
        return new Object[][] {
            {2.0, 2.0, 4.0},
            {4.8, 6.2, 11.0},
            {-9.1, -10.001, -19.101}
        };
    }

    @DataProvider(name = "Subtract Data Provider")
    public Object[][] subtractDataProvider() {
        return new Object[][] {
            {2.0, 2.0, 0.0},
            {4.8, 6.2, -1.4},
            {-9.1, -10.001, 0.900}
        };
    }

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "addDataProvider")
    public void addTest(Double a, Double b, Double expected) {
        Double actual = calculator.add(a, b);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "Subtract Data Provider")
    public void subtractTest(Double a, Double b, Double expected) {
        Double actual = calculator.subtract(a, b);
        assertEquals(actual, expected, 0.001);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}
