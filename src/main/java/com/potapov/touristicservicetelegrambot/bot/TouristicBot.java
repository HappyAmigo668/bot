package com.potapov.touristicservicetelegrambot.bot;

import com.potapov.touristicservicetelegrambot.controller.BotController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Component
public class TouristicBot extends TelegramLongPollingBot {

    @Autowired
    BotController botController;


    public TouristicBot() {}


    public TouristicBot(DefaultBotOptions options) {
        super(options);
    }


    public void onUpdateReceived(Update update) {

        SendMessage sendMessage;

        try {
            sendMessage = botController.handleRequest(update);

            if (sendMessage != null) {
                execute(sendMessage);

            } else {
                System.out.println("Error, sendMessage is null");
            }


        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public String getBotUsername() {
        return "cityDescription_bot";
    }


    public String getBotToken() {
        return "621927309:AAGDmYxyBuhm1maMNmmHzRbp_cuq0OPuhKI";
    }
}
