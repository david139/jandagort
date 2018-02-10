package com.jandagort.game.economy.planet.repository;

import com.jandagort.game.economy.planet.Consumption;
import com.jandagort.game.economy.planet.Production;
import com.jandagort.game.economy.planet.Resources;
import com.jandagort.game.economy.planet.Supply;
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

    @OneToOne(cascade = CascadeType.ALL)
    private Consumption consumption;
    @OneToOne(cascade = CascadeType.ALL)
    private Production production;
    @OneToOne(cascade = CascadeType.ALL)
    private Supply supply;

    private BigInteger villages;
    private BigInteger powerPlants;
    private BigInteger farms;

    public void stepRound() {

        BigInteger populationFulfillemt = consumption.getPopulation().divide(supply.getPopulation());
        BigInteger foodFulfillment = consumption.getFood().divide(supply.getFood());

        // TODO in progress

        if (supply.getFood().compareTo(consumption.getFood()) >= 1) {

            BigInteger remainingFood = supply.getFood().subtract(consumption.getFood());
            BigInteger newPopulation = remainingFood.min(supply.getPopulation().add(supply.getPopulation().divide(new BigInteger("10")))).min(production.getResidence());

            supply.setFood(remainingFood);
            supply.setPopulation(newPopulation);
        } else {
            supply.setFood(new BigInteger("0"));
            supply.setPopulation(supply.getPopulation().subtract(supply.getPopulation().divide(new BigInteger("10"))));
        }
    }

    public void setUp() {
        supply.setPopulation(supply.getPopulation().add(new BigInteger("100")));
        supply.setElectricity(supply.getElectricity().add(new BigInteger("1000000")));
        supply.setFood(supply.getFood().add(new BigInteger("1000000")));

        villages = new BigInteger("10");
        production.setResidence(production.getResidence().add(new BigInteger("100")));
        consumption.setFood(consumption.getFood().add(new BigInteger("100")));

        powerPlants = new BigInteger("2");
        production.setElectricity(production.getElectricity().add(new BigInteger("20")));

        farms = new BigInteger("2");
        consumption.setElectricity(consumption.getElectricity().add(new BigInteger("10")));
        production.setFood(production.getFood().add(new BigInteger("200")));
    }


}
