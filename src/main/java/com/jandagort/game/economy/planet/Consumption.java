package com.jandagort.game.economy.planet;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
@Scope("prototype")
public class Consumption {
    private BigInteger food = new BigInteger("0");
    private BigInteger electricity = new BigInteger("0");
}
