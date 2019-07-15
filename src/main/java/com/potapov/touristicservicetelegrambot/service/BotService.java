package com.potapov.touristicservicetelegrambot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component(value = "botService")
public interface BotService {

    SendMessage buildSendMessage(long chatId, String userText);

    boolean isUpdateContainsMessage(Update update);
}
