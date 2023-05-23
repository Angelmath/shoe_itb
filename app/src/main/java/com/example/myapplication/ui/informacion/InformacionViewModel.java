package com.example.myapplication.ui.informacion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InformacionViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public InformacionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento de Informacion");
    }

    public LiveData<String> getText() {
        return mText;
    }
}