package com.example.myapplication.ui.consulta_producto;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConsultaProductoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ConsultaProductoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento Consulta Producto");
    }

    public LiveData<String> getText() {
        return mText;
    }
}