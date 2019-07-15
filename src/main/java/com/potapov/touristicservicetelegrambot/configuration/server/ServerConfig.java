package com.potapov.touristicservicetelegrambot.configuration.server;

public interface ServerConfig {

    String HOST = "127.0.0.1";
    int PORT = 8080;
    String CONTEXT_PATH = "touristic-service";

    String URL = "http://" + HOST + ":" + PORT + "/" + CONTEXT_PATH;
    String URL_FIND_CITY_BY_NAME = URL + "/city/findByName";
    String URL_FIND_ALL_CITY_NAMES = URL + "/city/findAllNames/";

}
