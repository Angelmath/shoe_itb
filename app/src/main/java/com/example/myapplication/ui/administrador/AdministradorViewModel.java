package com.example.myapplication.ui.administrador;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AdministradorViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AdministradorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento Administrador");
    }

    public LiveData<String> getText() {
        return mText;
    }
}