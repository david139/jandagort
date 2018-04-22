package com.jandagort.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigIntegerUtil {

    public static BigInteger incrementWithPercentage(BigInteger input, Integer percentage) {
        BigDecimal value = new BigDecimal(input);

        BigDecimal onePercent = value.divide(new BigDecimal("100"), RoundingMode.HALF_UP);
        return onePercent.multiply(new BigDecimal("100").add(new BigDecimal(percentage.toString()))).toBigInteger();
    }
}
