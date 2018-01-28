package com.jandagort;

import com.jandagort.game.economy.roundrunner.RoundRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class MainApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MainApplication.class);
        ctx.getBean(RoundRunner.class).run();
    }
}