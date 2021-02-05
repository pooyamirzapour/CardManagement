package com.digi.card.repository.enums;

public enum CardStatus {
    ACTIVE("1"),
    INACTIVE("2");


    CardStatus(String v) {
        value = v;
    }

    private final String value;

    public String getValue() {
        return value;
    }
} 
