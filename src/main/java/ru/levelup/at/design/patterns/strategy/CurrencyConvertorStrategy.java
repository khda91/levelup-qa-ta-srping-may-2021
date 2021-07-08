package ru.levelup.at.design.patterns.strategy;

import java.math.BigDecimal;

public interface CurrencyConvertorStrategy {

    BigDecimal convertMoney(BigDecimal money);
}
