package com.example.sp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private Button buttonKaydet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonKaydet = findViewById(R.id.buttonKaydet);




        buttonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("Kişisel Bilgiler",MODE_PRIVATE); // kişisel bilgiler diye dosya oluşturuyor, mode_private ise korumalı modu aktif hale getiriyor

                SharedPreferences.Editor e = sp.edit(); // artık editör ile kayıt yapma işlemi gerçekleştirebiliriz

                e.putString("ad","Rıdvan");// değerleri giriyoruz
                e.putInt("yas",22);
                e.putFloat("boy",1.78f);
                e.putBoolean("bekar",true);

                Set<String> arkadasListesi = new HashSet<>();
                arkadasListesi.add("Zeynep");
                arkadasListesi.add("Merve");

                e.putStringSet("arkadasListesi",arkadasListesi);

                e.commit(); // eğer bunu girmezsek hiçbir şey kayıt edilmez


                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }
}
