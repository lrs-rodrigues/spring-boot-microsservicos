package com.lrsrodrigues.checkout.entities;

import java.util.UUID;

public class Checkout {
    private UUID protocol;

    public Checkout() {}

    public Checkout(UUID protocol) {
        this.protocol = protocol;
    }

    public UUID getProtocol() {
        return protocol;
    }

    public void setProtocol(UUID protocol) {
        this.protocol = protocol;
    }

    public String toString() {
        return "Checkout [protocol=" + protocol + "]";
    }
}
