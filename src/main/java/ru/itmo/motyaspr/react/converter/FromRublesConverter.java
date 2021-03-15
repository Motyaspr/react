package ru.itmo.motyaspr.react.converter;

import ru.itmo.motyaspr.react.currency.Currency;

public class FromRublesConverter {

    static final Double DOLLAR = 78.04;
    static final Double EURO   = 84.16;

    public static Double fromRubles(Double rubles, Currency currency) {
        switch (currency) {
            case USD:
                return rubles / DOLLAR;
            case EUR:
                return rubles / EURO;
            default:
                return rubles;
        }
    }

}
