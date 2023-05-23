package com.example.myapplication.ui.quienes_somos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuienesSomosViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public QuienesSomosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento Quienes Somos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}