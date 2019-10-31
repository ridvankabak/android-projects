package com.example.maps.ui.yardim;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class YardimViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public YardimViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is yardim fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}


