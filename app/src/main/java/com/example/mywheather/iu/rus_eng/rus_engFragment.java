package com.example.mywheather.iu.rus_eng;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mywheather.R;

public class rus_engFragment extends Fragment {

    private rus_engViewModel rus_engViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rus_engViewModel =
                ViewModelProviders.of(this).get(rus_engViewModel.class);
        View root = inflater.inflate(R.layout.fragment_rus_eng, container, false);
//        todo vrem
        final TextView textView = root.findViewById(R.id.translateTextRus);
        rus_engViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {

                        textView.setText(s);
                    }

        });

        return root;

    }
}
