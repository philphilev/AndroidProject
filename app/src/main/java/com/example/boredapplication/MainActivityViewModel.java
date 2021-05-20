package com.example.boredapplication;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.google.firebase.auth.FirebaseUser;

import com.example.boredapplication.model.*;

public class MainActivityViewModel extends AndroidViewModel {

    private final UserRepo userRepository;

    public MainActivityViewModel(Application app){
        super(app);
        userRepository = UserRepo.getInstance(app);
    }

    public void init() {
        String userId = userRepository.getCurrentUser().getValue().getUid();
        // messageRepository.init(userId);
    }

    public LiveData<FirebaseUser> getCurrentUser(){
        return userRepository.getCurrentUser();
    }

    /* public void saveMessage(String message) {
        messageRepository.saveMessage(message);
    }

    public LiveData<Message> getMessage() {
        return messageRepository.getMessage();
    } */

    public void signOut() {
        userRepository.signOut();
    }
}

