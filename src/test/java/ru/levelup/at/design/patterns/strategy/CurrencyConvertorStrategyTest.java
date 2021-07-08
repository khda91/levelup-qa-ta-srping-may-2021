package ru.levelup.at.design.patterns.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CurrencyConvertorStrategyTest {

    @Test
    public void converterTest() {
        var currencyConvertorStrategy = new RubToEurCurrencyConvertor();
        var convertor = new ConverterImpl(currencyConvertorStrategy);
        var actual = convertor.convertMoney(new BigDecimal("194.00"));

        assertThat(actual)
            .isEqualTo(new BigDecimal("2.00"));
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
            {new RubToEurCurrencyConvertor(), new BigDecimal("194.00"), new BigDecimal("2.00")},
            {new RubToUsdCurrencyConvertor(), new BigDecimal("194.00"), new BigDecimal("2.58")}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void converterDataProviderTest(CurrencyConvertorStrategy strategy,
                                          BigDecimal money, BigDecimal expected) {
        var convertor = new ConverterImpl(strategy);
        var actual = convertor.convertMoney(money);

        assertThat(actual).isEqualTo(expected);
    }
}
