package com.lrsrodrigues.payment.entities.enums;

public enum PaymentType {

    CREDIT_CARD(1),
    DEBIT_CARD(2),
    CASH(3);

    private int code;

    private PaymentType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static PaymentType valueOf(int code) {
        for (PaymentType value : PaymentType.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Payment Type code");
    }
}