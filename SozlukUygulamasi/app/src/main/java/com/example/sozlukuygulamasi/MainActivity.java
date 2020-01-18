package com.example.sozlukuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.VelocityTracker;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private VeritabaniYardimcisi vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vt = new VeritabaniYardimcisi(this);

        new Kelimelerdao().kelimeEkle(vt,"door","kapi");
        new Kelimelerdao().kelimeEkle(vt,"pencil","kalem");
        new Kelimelerdao().kelimeEkle(vt,"computer","bilgisayar");
        new Kelimelerdao().kelimeEkle(vt,"table","masa");
        new Kelimelerdao().kelimeEkle(vt,"mouse","fare");

        ArrayList<Kelimeler> gelenKelimeler = new Kelimelerdao().tumKelimeler(vt);
        for(Kelimeler k: gelenKelimeler){
            Log.e(String.valueOf(k.getKelime_id()),k.getIngilizce()+"-"+k.getTurkce());
        }

    }
}
