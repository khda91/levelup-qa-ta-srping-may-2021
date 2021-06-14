package ru.levelup.at.build.tools.data.provider;

import org.testng.annotations.DataProvider;

public class CalculatorAddSubtractDataProvider {

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
}
