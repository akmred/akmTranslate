package com.example.mywheather.iu.rus_eng;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class rus_engViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public rus_engViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("This is rus-eng fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
