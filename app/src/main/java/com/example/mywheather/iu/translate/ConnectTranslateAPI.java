package com.example.mywheather.iu.translate;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/*
* Класс соединения с API translate
* и получения перевода
* */
public class ConnectTranslateAPI {
    private StructuraTranslate translateRule;


    public ConnectTranslateAPI(StructuraTranslate translateStruct) {
        this.translateRule = translateStruct;
    }

    /*
    * Запрпашивает переод у апи
    * */
    public String getRespondOnPOST() throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, translateRule.getTextSourceForGSon());
        Request request = new Request.Builder()
                .url("https://api.cognitive.microsofttranslator.com/translate?api-version=3.0" + translateRule.getToFrom())
                .method("POST", body)
                .addHeader("Ocp-Apim-Subscription-Key", "467a55e9232d43418688dd5fb21d345c")
                .addHeader("Content-Type", "application/json")
                .build();

            Response response = client.newCall(request).execute();

            return response.body().string();

    }

    /*
    * Возвращает текст перевода
    * */
    public String GetTranslateText() {
        String Response = new String();

        try {
             Response  = getRespondOnPOST();
        } catch (IOException e) {
            e.printStackTrace();
        }

        translateRule.setTextTranslate(Response);

        return  translateRule.getTextTranslateForGSon();
    }

}
