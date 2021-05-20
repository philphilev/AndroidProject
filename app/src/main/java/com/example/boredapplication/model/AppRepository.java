package com.example.boredapplication.model;

import android.util.Log;

import com.example.boredapplication.networking.GameAPI;
import com.example.boredapplication.networking.GameService;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

import java.util.ArrayList;

public class AppRepository {

    private GameAPI gameAPI;
    private static AppRepository instance;
    private MutableLiveData<ArrayList<GameObject>> games;

    private AppRepository()
    {
        gameAPI = GameService.GetGameAPI();
        games = new MutableLiveData<>();
    }

    public static synchronized AppRepository getInstance() {
        if(instance == null){
            instance = new AppRepository();
        }
        return instance;
    }

    public LiveData<ArrayList<GameObject>> getGamesList(){
        return games;
    }

    public void getPopularGames()
    {
        Call<GameList> call = gameAPI.getPopularGames();
        call.enqueue(new Callback<GameList>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<GameList> call, Response<GameList> response) {
                if (response.isSuccessful()) {
                    games.setValue(response.body().getGames());
                    System.out.println(games.toString());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<GameList> call, Throwable t) {
                Log.i("Retrofit", t.getMessage());
            }
        });
    }


   /* FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = FirebaseDatabase.getInstance("gs://boredapplication-b6303.appspot.com").getReference("games");
    FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();

    public void saveGame(GameObject game) {
        String key = databaseReference.child(game.UserId).push().getKey();
        game.GameId = key;
        databaseReference.child(game.UserId).child(key).setValue(game);
    }

    public DatabaseReference getDatabaseReference() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance("gs://boredapplication-b6303.appspot.com").getReference("games");
        return databaseReference;
    }

    public FirebaseStorage getFirebaseStorage() {
        return firebaseStorage;
    }

    public void deleteGame(String user, String game){
        databaseReference.child(user).child(game).removeValue();
    }
    public void editGame(GameObject game){
        databaseReference.child(game.UserId).child(game.GameId).setValue(game);
    } */
}