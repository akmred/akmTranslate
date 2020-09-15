package com.example.mywheather.iu.rus_eng;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mywheather.R;
import com.example.mywheather.iu.translate.ThreadTranslate;

public class rus_engFragment extends Fragment {
    private rus_engViewModel rus_engViewModel;
    TextView translateTextEng;
    private static final String TAG = "myLogs";
    private static String subscriptionKey = System.getenv("TRANSLATOR_TEXT_SUBSCRIPTION_KEY");
    private static String endpoint = System.getenv("TRANSLATOR_TEXT_ENDPOINT");
    String url = "https://api.cognitive.microsofttranslator.com" + "/translate?api-version=3.0&from=en&to=ru";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rus_engViewModel =
                ViewModelProviders.of(this).get(rus_engViewModel.class);
        View root = inflater.inflate(R.layout.fragment_rus_eng, container, false);

        final EditText editText = (EditText)root.findViewById(R.id.editTextRus);
        translateTextEng = (TextView)root.findViewById(R.id.translateTextEng);
               editText.setOnKeyListener(new View.OnKeyListener() {
         @Override
         public boolean onKey(View view, int keyCode, KeyEvent event) {
                         if (event.getAction() == KeyEvent.ACTION_DOWN &&
                                    (keyCode == KeyEvent.KEYCODE_ENTER)) {

                             ThreadTranslate threadTranslate = new ThreadTranslate(editText.getText().toString(), "en", "ru");
                             threadTranslate.start();
                             try {
                                 threadTranslate.join();
                             } catch (InterruptedException e) {
                                 e.printStackTrace();
                             }
                             translateTextEng.setText(threadTranslate.GetTextTranslate());

                             return true;

             }
             return false;
         }
     });


        return root;

    }

}
