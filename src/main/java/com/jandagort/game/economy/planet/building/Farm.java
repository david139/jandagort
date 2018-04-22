package com.jandagort.game.economy.planet.building;

import java.math.BigInteger;

public enum Farm {
    FOOD_PRODUCTION(new BigInteger("1000")),
    ELECTRICITY_CONSUMPTION(new BigInteger("10")),
    POPULATION_ALLOCATION(new BigInteger("10"));

    private BigInteger value;

    Farm(BigInteger value) {
        this.value = value;
    }

    public BigInteger getValue() {
        return value;
    }
}
