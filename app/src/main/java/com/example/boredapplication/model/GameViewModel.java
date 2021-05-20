package com.example.boredapplication.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class GameViewModel extends ViewModel
{
    private AppRepository gameRepo;

    public GameViewModel()
    {
        gameRepo = AppRepository.getInstance();
    }
    public LiveData<ArrayList<GameObject>> getGameList()
    {
        return gameRepo.getGamesList();
    }
    public void searchPopularGames()
    {
        gameRepo.getPopularGames();
    }

}
