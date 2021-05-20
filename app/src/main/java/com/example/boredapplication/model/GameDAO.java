package com.example.boredapplication.model;

public class GameDAO {

    private int id;
    private String name;
    private String description;
    private Number rating;
    private Integer price;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return name;
    }

    public Number getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GameObject getGame()
    {
        return new GameObject(id, name, price, rating);
    }
}
