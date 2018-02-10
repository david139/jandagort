package com.jandagort.game.economy.planet.repository;

import com.jandagort.game.economy.planet.Consumption;
import com.jandagort.game.economy.planet.Production;
import com.jandagort.game.economy.planet.Supply;
import com.jandagort.user.domain.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @OneToOne(cascade = CascadeType.ALL)
    private Consumption consumption;
    @OneToOne(cascade = CascadeType.ALL)
    private Production production;
    @OneToOne(cascade = CascadeType.ALL)
    private Supply supply;

    private BigInteger villages = new BigInteger("10");
    private BigInteger powerPlants = new BigInteger("10");
    private BigInteger farms = new BigInteger("10");

    public void stepRound() {
        if (supply.getFood().compareTo(supply.getPopulation()) >= 1) {

            BigInteger remainingFood = supply.getFood().subtract(supply.getPopulation());
            BigInteger newPopulation = remainingFood.min(supply.getPopulation().add(supply.getPopulation().divide(new BigInteger("10")))).min(villages.multiply(new BigInteger("100")));

            supply.setFood(remainingFood);
            supply.setPopulation(newPopulation);
        } else {
            supply.setFood(new BigInteger("0"));
            supply.setPopulation(supply.getPopulation().subtract(supply.getPopulation().divide(new BigInteger("10"))));
        }
    }

}
