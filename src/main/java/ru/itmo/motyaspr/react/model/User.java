package ru.itmo.motyaspr.react.model;

import ru.itmo.motyaspr.react.currency.Currency;
import ru.itmo.motyaspr.react.currency.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User{
    @Id
    String id;
    String name;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    Currency currency;
}