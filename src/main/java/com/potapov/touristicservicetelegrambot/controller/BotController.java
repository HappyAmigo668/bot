package com.potapov.touristicservicetelegrambot.controller;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component(value = "botController")
public interface BotController {

    SendMessage handleRequest(Update update);

}
