package com.jandagort.game.economy.planet.building;

import java.math.BigInteger;

public enum Village {
    RESIDENCE(new BigInteger("100"));

    private BigInteger value;

    Village(BigInteger value) {
        this.value = value;
    }

    public BigInteger getValue() {
        return value;
    }
}

