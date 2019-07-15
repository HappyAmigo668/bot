package com.potapov.touristicservicetelegrambot.controller;

import com.potapov.touristicservicetelegrambot.service.BotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;


@Component(value = "touristicBotController")
public class TouristicBotController implements BotController {

    @Autowired
    BotService botService;


    public SendMessage handleRequest(Update update) {

        SendMessage sendMessage = null;

        if (botService.isUpdateContainsMessage(update)) {

            Message message = update.getMessage();
            Chat chat = message.getChat();

            String username = "@" + chat.getUserName();

            String requestText = message.getText();

            System.out.println("Receive request from " + username + ": [" + requestText + "]");


            try {

                sendMessage = botService.buildSendMessage(chat.getId(), requestText);

                sendMessage = (sendMessage == null ? getErrorMessage(chat.getId()) : sendMessage);

                System.out.println("Send response to " + username + ": [" + sendMessage + "]");

            } catch (RuntimeException e) {
                sendMessage = getErrorMessage(chat.getId());
            }
        }

        return sendMessage;
    }


    private SendMessage getErrorMessage(long chatId) {

        String errorMessage = "Internal server error. Try again later.";

        return new SendMessage(chatId, errorMessage);
    }

}
