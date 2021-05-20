package com.example.boredapplication.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GameObject {


    public int id;
    public String UserId;
    public String name;
    public String description;
    public double price;
    public String publisher;
    public Number rating;
    public String genre;

    public GameObject(int id,String name, double price, Number rating){
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }
    public String getGenre() {
        return genre;
    }
    public double getPrice() {
        return price;
    }
    public String toString()
    {
        return "TEST title: " + name + " / " + rating;
    }


}
