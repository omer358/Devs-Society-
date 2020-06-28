package com.example.devssociety.screens.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<String> userName;
    private MutableLiveData<String> passward;

    private MutableLiveData<Boolean> navigateToSignUP;
}