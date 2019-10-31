package com.example.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class IkinciFragment extends Fragment {
    private Button button;
    @androidx.annotation.Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @androidx.annotation.Nullable ViewGroup container, Bundle savedInstanceState) {
        //İkinci sayfadaki tasarımımızı bu şekilde yerleştiriyoruz.
        View rootView = inflater.inflate(R.layout.ikincifragmentlayout,container,false);

        button = rootView.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("İkinci Fragment","Tıklandı");
            }
        });
        return rootView;
    }
}
