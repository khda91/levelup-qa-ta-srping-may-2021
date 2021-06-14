package ru.levelup.at.build.tools;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.at.build.tools.data.provider.CalculatorAddSubtractDataProvider;

public class CalculatorAddDataProviderTest extends AbstractCalculatorDataProviderTest {

    @Test(dataProvider = "addDataProvider", dataProviderClass = CalculatorAddSubtractDataProvider.class)
    public void addTest(Double a, Double b, Double expected) {
        Double actual = calculator.add(a, b);
        assertEquals(actual, expected);
    }
}
