package ru.levelup.at.design.patterns.strategy;

import java.math.BigDecimal;

public class ConverterImpl implements Converter {

    private final CurrencyConvertorStrategy currencyConvertorStrategy;

    public ConverterImpl(CurrencyConvertorStrategy currencyConvertorStrategy) {
        this.currencyConvertorStrategy = currencyConvertorStrategy;
    }

    @Override
    public BigDecimal convertMoney(BigDecimal money) {
        return currencyConvertorStrategy.convertMoney(money);
    }
}
