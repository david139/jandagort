package com.jandagort.game.economy.planet;

import lombok.Data;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.math.BigInteger;

@Scope("prototype")
@Data
@Entity
@Table(name = "supplies")
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private BigInteger food;
    private BigInteger electricity;
    private BigInteger population;
}
