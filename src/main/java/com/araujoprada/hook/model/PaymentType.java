package com.araujoprada.hook.model;

public enum PaymentType{
    TRANSFERENCE(1,"Transferencia bancaria"),
    MOBILE_BANK(2,"Banca Móvil"),
    CASH(3, "Al contado");

    private final int order;
    private final String description;

    PaymentType(int order, String description) {
        this.order = order;
        this.description = description;
    }

    public int getOrder() {
        return this.order;
    }

    public String getDescription() {
        return this.description;
    }
}
