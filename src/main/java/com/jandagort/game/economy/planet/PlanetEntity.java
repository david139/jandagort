package com.jandagort.game.economy.planet;

import com.jandagort.user.domain.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@Entity
@Table(name = "planets")
public class PlanetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private UserEntity owner;
    private BigInteger food = new BigInteger("10000000000");
    private BigInteger population = new BigInteger("100");
    private BigInteger villages = new BigInteger("10");

    public void stepRound() {
        if (food.compareTo(population) >= 1) {

            BigInteger remainingFood = food.subtract(population);
            BigInteger newPopulation = remainingFood.min(population.add(population.divide(new BigInteger("10")))).min(villages.multiply(new BigInteger("100")));

            food = remainingFood;
            population = newPopulation;
        } else {
            food = new BigInteger("0");
            population = population.subtract(population.divide(new BigInteger("10")));
        }
    }

}
