package com.jandagort.game.economy.planet.repository;

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
    @OneToOne(cascade = CascadeType.ALL)
    private Population population;

    private BigInteger villages;
    private BigInteger powerPlants;
    private BigInteger farms;
}
