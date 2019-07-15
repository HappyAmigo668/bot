package com.potapov.touristicservicetelegrambot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;


@SpringBootApplication
public class TouristicServiceTelegramBot {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(TouristicServiceTelegramBot.class, args);

        System.out.println("Application started.");
    }
}

