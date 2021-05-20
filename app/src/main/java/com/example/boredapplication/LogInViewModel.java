package com.example.boredapplication;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.google.firebase.auth.FirebaseUser;
import com.example.boredapplication.model.UserRepo;

public class LogInViewModel extends AndroidViewModel {
    private final UserRepo userRepository;

    public LogInViewModel(Application app){
        super(app);
        userRepository = UserRepo.getInstance(app);
    }

    public LiveData<FirebaseUser> getCurrentUser(){
        return userRepository.getCurrentUser();
    }
}
