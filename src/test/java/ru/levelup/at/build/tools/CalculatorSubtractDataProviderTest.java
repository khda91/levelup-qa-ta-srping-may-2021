package ru.levelup.at.build.tools;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import ru.levelup.at.build.tools.data.provider.CalculatorAddSubtractDataProvider;

public class CalculatorSubtractDataProviderTest extends AbstractCalculatorDataProviderTest {

    @Test(dataProvider = "Subtract Data Provider", dataProviderClass = CalculatorAddSubtractDataProvider.class)
    public void subtractTest(Double a, Double b, Double expected) {
        Double actual = calculator.subtract(a, b);
        assertEquals(actual, expected, 0.001);
    }
}
