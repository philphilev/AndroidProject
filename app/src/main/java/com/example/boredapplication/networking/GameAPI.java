package com.example.boredapplication.networking;

import androidx.room.Query;

import com.example.boredapplication.model.GameList;
import com.example.boredapplication.model.GameObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.*;

public interface GameAPI {

    String apiKey = "?key=c00a31d26886457c8274fc7e7be79c83";

    @GET("/games/{id}" + apiKey)
    Call<GameObject> getGameDetail(@Path("/games/{id}") int id);

    @GET("/games" + apiKey)
    Call<GameList> getPopularGames();

    /*@GET("/games" + apiKey + languageEN)
    Call<GameList> searchGameByTitle(@Query("query") String title); */

}
