package ru.levelup.at.design.patterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RubToUsdCurrencyConvertor implements CurrencyConvertorStrategy {

    private static final BigDecimal EXCHANGE_RATE = BigDecimal.valueOf(78.02);

    @Override
    public BigDecimal convertMoney(BigDecimal money) {
        return money.divide(EXCHANGE_RATE, RoundingMode.CEILING);
    }
}
