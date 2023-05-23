package com.example.myapplication.ui.consulta_cliente;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConsultaClienteViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ConsultaClienteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento Consulta Cliente");
    }

    public LiveData<String> getText() {
        return mText;
    }
}