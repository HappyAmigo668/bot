package com.potapov.touristicservicetelegrambot.service;


import com.potapov.touristicservicetelegrambot.configuration.server.ServerConfig;
import com.potapov.touristicservicetelegrambot.domain.city.City;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;


@Component(value = "touristicBotService")
public class TouristicBotService implements BotService {

    public SendMessage buildSendMessage(long chatId, String cityName) {
        StringBuilder response = new StringBuilder("Описание для города " + cityName);
        City city = requestCityByName(cityName);

        if (city != null) {
            response.append(":\n\n – ");
            response.append(city.getDescription());

        } else {
            List cityNames = requestCityNames();
            response.append(" не найдено.\n\nВот города, о которых меня можно спросить: \n\n");

            long i = 1;
            if (cityNames != null) {
                for (Object name : cityNames) {
                    response.append(i++).append(". ").append(name).append("\n");
                }
            }
        }

        return new SendMessage()
                .setChatId(chatId)
                .setText(response.toString());
    }

    public boolean isUpdateContainsMessage(Update update) {
        return update.hasMessage() && update.getMessage().hasText();
    }

    private City requestCityByName(String cityName) {

        final String URL = ServerConfig.URL_FIND_CITY_BY_NAME +  "/" + cityName;
        RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.getForObject(URL, City.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }

        return null;
    }

    private List requestCityNames() {
        final String URL = ServerConfig.URL_FIND_ALL_CITY_NAMES;
        RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.getForObject(URL, List.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }

        return null;
    }

}
