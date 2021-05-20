package com.example.boredapplication.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GameRepo {

    public String name;
    public String description;
    public double price;
    public String rating;
    public String genre;

    public GameRepo(String name, double price){
        this.name = name;
        this.price = price;
    }

}
