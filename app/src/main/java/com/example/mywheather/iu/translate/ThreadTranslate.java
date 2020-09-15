package com.example.mywheather.iu.translate;

public class ThreadTranslate extends Thread {

    StructuraTranslate translateRule;
    String textRespond;

    public ThreadTranslate(String text, String to, String from) {

        this.translateRule = new StructuraTranslate(text, to, from);

    }

    @Override
    public void run() {

        ConnectTranslateAPI connectTranslateAPI = new ConnectTranslateAPI(translateRule);
        textRespond = connectTranslateAPI.GetTranslateText();

   }

   public String GetTextTranslate()
   {return  textRespond;}

}
