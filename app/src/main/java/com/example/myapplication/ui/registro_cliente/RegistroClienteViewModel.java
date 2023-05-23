package com.example.myapplication.ui.registro_cliente;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegistroClienteViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RegistroClienteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento Registrar Cliente");
    }

    public LiveData<String> getText() {
        return mText;
    }
}