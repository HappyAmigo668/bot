package com.potapov.touristicservicetelegrambot.domain.city;

/**
 * Domain class for entity City
 * fields:
 * id long
 * name String
 * description String
 */
public class City {


    private long id;

    private String name;

    private String description;


    public City() {}

    public City(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
