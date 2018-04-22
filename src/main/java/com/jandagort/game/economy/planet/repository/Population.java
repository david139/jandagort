package com.jandagort.game.economy.planet.repository;

import lombok.Data;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.math.BigInteger;

@Scope("prototype")
@Data
@Entity
@Table(name = "populations")
public class Population {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private BigInteger current;
    private BigInteger next;
    private BigInteger max;
    private BigInteger allocated;
}
