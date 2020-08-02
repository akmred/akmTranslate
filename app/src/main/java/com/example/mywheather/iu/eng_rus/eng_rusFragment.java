package com.example.mywheather.iu.eng_rus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.example.mywheather.R;

public class eng_rusFragment extends Fragment {

    private eng_rusViewModel eng_rusViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        eng_rusViewModel =
                ViewModelProviders.of(this).get(eng_rusViewModel.class);
        View root = inflater.inflate(R.layout.fragment_eng_rus, container, false);
        final TextView textView = root.findViewById(R.id.translateTextEng);
        eng_rusViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        return root;
    }
}
