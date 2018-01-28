package com.jandagort.game.economy.roundrunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RoundRunner implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoundRunner.class);


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(60000);
                LOGGER.info("Round change happened");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
