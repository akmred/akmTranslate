package com.example.mywheather.iu.translate;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
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

//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, translateRule.getTextSourceForGSon());
//        Request request = new Request.Builder()
//                .url("https://api.cognitive.microsofttranslator.com/translate?api-version=3.0" + translateRule.getToFrom())
//                .method("POST", body)
//                .addHeader("Ocp-Apim-Subscription-Key", "467a55e9232d43418688dd5fb21d345c")
//                .addHeader("Content-Type", "application/json")
//                .build();

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "[{\n    \"text\": \"hello world!\"\n}\n]");
        Request request = new Request.Builder()
                .url("https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&to=ru")
                .method("POST", body)
                .addHeader("Ocp-Apim-Subscription-Key", "467a55e9232d43418688dd5fb21d345c")
                .addHeader("Content-Type", "application/json")
                .build();
       client.newCall(request).enqueue(new Callback() {
           @Override
           public void onFailure(@NotNull Call call, @NotNull IOException e) {
               e.printStackTrace();
           }

           @Override
           public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

               if (!response.isSuccessful()){
                   throw new IOException("Unexpected code "+ response);
               } else {
                   String r = "Happy";
               }
           }
       });



//            return response.body().string();
            return "";

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
