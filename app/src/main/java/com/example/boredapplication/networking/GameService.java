package com.example.boredapplication.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GameService {

    private static Retrofit.Builder retroBuild = new Retrofit.Builder()
            .baseUrl("https://api.rawg.io/api/")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retroBuild.build();

    private static GameAPI gameAPI = retrofit.create(GameAPI.class);

    public static GameAPI GetGameAPI() {
        return gameAPI;
    }
}
