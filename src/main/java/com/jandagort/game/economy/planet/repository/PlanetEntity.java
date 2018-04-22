package com.jandagort.game.economy.planet.repository;

import com.jandagort.game.economy.planet.Consumption;
import com.jandagort.game.economy.planet.Production;
import com.jandagort.game.economy.planet.Supply;
import com.jandagort.user.domain.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "planets")
public class PlanetEntity {
    private static final BigDecimal ONE = new BigDecimal("1");

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

    private BigDecimal villages;
    private BigDecimal powerPlants;
    private BigDecimal farms;

    public void stepRound() {

        BigDecimal populationFulfillment = supply.getPopulation().divide(consumption.getPopulation(), BigDecimal.ROUND_HALF_UP);
        BigDecimal electricityFulfillment = supply.getElectricity().divide(consumption.getElectricity(), BigDecimal.ROUND_HALF_UP);

        if (populationFulfillment.compareTo(new BigDecimal("1")) < 0) {
            electricityFulfillment = electricityFulfillment.multiply(populationFulfillment);
        }

        BigDecimal productivityFulfillment = populationFulfillment.compareTo(electricityFulfillment) > 0 ? electricityFulfillment : populationFulfillment;

        if (productivityFulfillment.compareTo(ONE) < 0) {
            if (populationFulfillment.compareTo(ONE) < 0) {
                supply.setElectricity(supply.getElectricity().add(production.getElectricity().multiply(populationFulfillment)));
            }
            supply.setFood(supply.getFood().add(production.getFood().multiply(productivityFulfillment)));

        } else {
            supply.setElectricity(supply.getElectricity().add(production.getElectricity()));
            supply.setFood(supply.getFood().add(production.getFood()));
        }

        supply.setFood(supply.getFood().subtract(consumption.getFood()));
        supply.setPopulation(supply.getPopulation().multiply(new BigDecimal("1.1")));
        consumption.setFood(supply.getPopulation());
    }

    public void setUp() {
        supply.setPopulation(supply.getPopulation().add(new BigDecimal("10")));
        supply.setElectricity(supply.getElectricity().add(new BigDecimal("1000")));
        supply.setFood(supply.getFood().add(new BigDecimal("1000000")));

        villages = new BigDecimal("10");
        production.setResidence(production.getResidence().add(new BigDecimal("100")));
        consumption.setFood(consumption.getFood().add(new BigDecimal("100")));

        powerPlants = new BigDecimal("2");
        production.setElectricity(production.getElectricity().add(new BigDecimal("20")));
        consumption.setPopulation(consumption.getPopulation().add(new BigDecimal("50")));

        farms = new BigDecimal("2");
        production.setFood(production.getFood().add(new BigDecimal("200")));
        consumption.setElectricity(consumption.getElectricity().add(new BigDecimal("10")));
        consumption.setPopulation(consumption.getPopulation().add(new BigDecimal("20")));
    }


}
