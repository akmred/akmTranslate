package com.example.mywheather.iu.translate;

import android.util.Log;

public class ThreadTranslate extends Thread {

    private static final String TAG = "MyLog";

    StructuraTranslate translateRule;
    String textRespond;

    public ThreadTranslate(String text, String to, String from) {

        this.translateRule = new StructuraTranslate(text, to, from);

    }

    @Override
    public void run() {

        Log.i(TAG, "Запущен поток");
        ConnectTranslateAPI connectTranslateAPI = new ConnectTranslateAPI(translateRule);
        textRespond = connectTranslateAPI.GetTranslateText();

        Log.i(TAG, "Текст ответа в потоке: " + textRespond);
   }

   public String GetTextTranslate()
   {return  textRespond;}

}
