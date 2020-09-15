package com.example.mywheather.iu.translate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/*
* Структура перевода
* состоит из:
* from - с какого текста переводить (ru, en)
* to - на какой переводить (ru, en)
* textSource - текст для перевода
* textTranslateForGSon - переведенный текст в формате GSON
* */
public class StructuraTranslate {
    private String from,to, textSource, textTranslateForGSon;

    public StructuraTranslate(String textSource,String to, String from) {
        this.from = from;
        this.to = to;
        this.textSource = textSource;
    }

    /*
    * Заполняет текст перевода
    * */
    public void setTextTranslate(String textTranslate) {

        this.textTranslateForGSon = textTranslate;
    }

    /*
    * Возвращает текст для перевода в формате json
    * */
    public String getTextSourceForGSon() {

        String textGSon = "[{\n    \"text\":" + textSource + "\"\n}\n]";

        return prettify(textGSon);

    }

    // This function prettifies the json response.
    private static String prettify(String json_text) {
        JsonParser parser = new JsonParser();
        JsonElement json = parser.parse(json_text);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(json);
    }

    /*
    * Берет перевденный текст в формате json и преобразует в простой текст
    * */
    public String getTextTranslateForGSon() {

        String textTranslate = fromGSon(textTranslateForGSon);

        return textTranslateForGSon;
    }

    /*
    * Преобразует json текст в простой текст
    * */
    private String fromGSon(String textTranslateForGSon) {

        BodyResponse bodyResponse = new BodyResponse();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.create();
        Gson gson = new Gson();
        bodyResponse = gson.fromJson(textTranslateForGSon, BodyResponse.class);

        return bodyResponse.getText();

    }

    /*
    * Дополняет услове направление перевода
    * */
    public String getToFrom() {

        String TextToFrom = "&to=" + to + "&from=" + from;

        return TextToFrom;

    }
}
