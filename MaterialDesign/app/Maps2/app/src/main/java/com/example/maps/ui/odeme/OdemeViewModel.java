package com.example.maps.ui.odeme;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OdemeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OdemeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is odeme fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}