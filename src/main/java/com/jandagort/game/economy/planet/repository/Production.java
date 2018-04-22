package com.jandagort.game.economy.planet.repository;

import lombok.Data;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Scope("prototype")
@Data
@Entity
@Table(name = "productions")
public class Production {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private BigInteger food;
    private BigInteger electricity;
}
