package com.example.myapplication.ui.inicio_sesion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InicioSesionViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public InicioSesionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento Inicio Sesion");
    }

    public LiveData<String> getText() {
        return mText;
    }
}