package com.jandagort.planets.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public abstract class Planet {

    private BigDecimal wood;
    private BigDecimal stone;
    private BigDecimal food;

    private BigDecimal woodProduction = new BigDecimal(100);
    private BigDecimal stoneProduction = new BigDecimal(100);
    private BigDecimal foodProduction = new BigDecimal(100);
}
