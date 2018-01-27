package com.jandagort;

import com.jandagort.roundrunner.RoundRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(MainApplication.class);
        ctx.getBean(RoundRunner.class).run();

    }


}