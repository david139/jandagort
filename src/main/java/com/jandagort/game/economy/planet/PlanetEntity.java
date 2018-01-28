package com.jandagort.game.economy.planet;

import com.jandagort.user.domain.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@Entity
@Table(name = "planets")
public class PlanetEntity {
    @Id
    private long id;
    @ManyToOne
    private UserEntity owner;
    private BigInteger food = new BigInteger("10000000000");
    private BigInteger population = new BigInteger("100");

    public void stepRound() {
        if (food.compareTo(population) >= 1) {
            BigInteger remainingFood = food.subtract(population);
            BigInteger newPopulation = remainingFood.subtract(population).min(population.multiply(new BigInteger("1.1")));

            food = remainingFood;
            population = newPopulation;
        }
    }

}
