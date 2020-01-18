package com.example.sp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Set;

public class SecondActivity extends AppCompatActivity {
    private Button buttonSil,buttonGuncelle;
    private TextView textViewCikti;
    private SharedPreferences sp;
    private SharedPreferences.Editor e;
    private String ad;
    private float boy;
    private int yas;
    private boolean bekar;
    private Set<String> arkadasListesi;
    private StringBuilder sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        buttonGuncelle = findViewById(R.id.buttonGuncelle);
        buttonSil = findViewById(R.id.buttonSil);
        textViewCikti = findViewById(R.id.textViewCikti);

        sp = getSharedPreferences("Kişisel Bilgiler",MODE_PRIVATE); // kişisel bilgiler diye dosya oluşturuyor, mode_private ise korumalı modu aktif hale getiriyor

        e = sp.edit();

        ad = sp.getString("ad","isim yok"); // verileri çekme işlemi
        yas = sp.getInt("yas",0);
        boy = sp.getFloat("boy",0.0f);
        bekar = sp.getBoolean("bekar",false);
        arkadasListesi = sp.getStringSet("arkadasListesi",null); // farklı indexlendiği için string builder ile çekiyoruz

        sb = new StringBuilder();

        for (String s:arkadasListesi){
            sb.append(s+" ");
        }

        textViewCikti.setText("Ad: "+ ad+" Yas: "+yas+" Boy: "+boy+" Bekar: "+ bekar+ " Arkadaslar: "+sb.toString()); // textview yazdırmaaa

        buttonSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e.remove("ad"); //silme işlemi
                e.commit();

                ad = sp.getString("ad","isim yok");
                textViewCikti.setText("Ad: "+ ad+" Yas: "+yas+" Boy: "+boy+" Bekar: "+ bekar+ " Arkadaslar: "+sb.toString()); // textview yazdırmaaa
            }
        });

        buttonGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e.putInt("yas",400); //guncelleme işlemi
                e.commit();

                yas = sp.getInt("yas",0);
                textViewCikti.setText("Ad: "+ ad+" Yas: "+yas+" Boy: "+boy+" Bekar: "+ bekar+ " Arkadaslar: "+sb.toString()); // textview yazdırmaaa
            }
        });

    }
}
