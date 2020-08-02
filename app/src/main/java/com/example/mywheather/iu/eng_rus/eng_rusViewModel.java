package com.example.mywheather.iu.eng_rus;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class eng_rusViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public eng_rusViewModel(){

        mText = new MutableLiveData<>();
        mText.setValue("This is eng_rus fragment");

    }

    public LiveData<String> getText() {return mText;}
}
