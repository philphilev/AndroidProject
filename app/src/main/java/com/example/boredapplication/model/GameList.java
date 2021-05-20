package com.example.boredapplication.model;

import java.util.ArrayList;
import java.util.List;


public class GameList {

    List<GameDAO> results;
    public ArrayList<GameObject> getGames()
    {
        ArrayList<GameObject> result = new ArrayList<>();
        for(GameDAO gameDAO: results){
            result.add(gameDAO.getGame());
        }
        return result;
    }
}
