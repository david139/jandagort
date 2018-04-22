package com.jandagort.game.economy.planet.building;

import java.math.BigInteger;

public enum PowerPlant {
    POPULATION_ALLOCATION(new BigInteger("20")),
    ENERGY_PRODUCTION(new BigInteger("100"));

    private BigInteger value;

    PowerPlant(BigInteger value) {
        this.value = value;
    }

    public BigInteger getValue() {
        return value;
    }
}
