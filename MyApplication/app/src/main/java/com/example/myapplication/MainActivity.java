package com.example.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.birinciFragmentTutucu,new BirinciFragment()); //Hangi fragmentın hangi class olduğunu ekliyoruz
        ft.add(R.id.ikinciFragmentTutucu,new IkinciFragment());

        ft.commit(); // framelayouttaki kutucuklara yerleştiriyoruz.
    }
}
