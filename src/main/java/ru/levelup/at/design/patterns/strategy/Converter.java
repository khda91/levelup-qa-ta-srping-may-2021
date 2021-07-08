package ru.levelup.at.design.patterns.strategy;

import java.math.BigDecimal;

public interface Converter {

    BigDecimal convertMoney(BigDecimal money);
}
