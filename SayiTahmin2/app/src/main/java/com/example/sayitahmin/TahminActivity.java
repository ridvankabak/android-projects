package com.example.sayitahmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class TahminActivity extends AppCompatActivity {
    private TextView textViewKalanHak,textViewYonlendirme;
    private EditText editText;
    private Button buttonKontrol;
    private int sayac = 5;
    private int rastgeleSayi;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahmin);
        textViewKalanHak=findViewById(R.id.textViewKalanHak);
        textViewYonlendirme=findViewById(R.id.textViewYonlendirme);
        editText=findViewById(R.id.editTextTahmin);
        buttonKontrol=findViewById(R.id.buttonKontrol);

        Random rnd = new Random();
        rastgeleSayi=rnd.nextInt(101);
        Log.e("Sayi",String.valueOf(rastgeleSayi));


        buttonKontrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sayac-=1;
               int tahmin = Integer.parseInt(editText.getText().toString());

                if(sayac != 0){
                   if(rastgeleSayi == tahmin){
                       Intent i = new Intent(TahminActivity.this,SonucActivity.class);
                       i.putExtra("sonuc",true);
                       startActivity(i);
                       finish();
                   }
                   if(tahmin>rastgeleSayi){
                       textViewYonlendirme.setText("Azalt");
                   }
                   if(tahmin<rastgeleSayi){
                       textViewYonlendirme.setText("Arttır");
                   }
                   textViewKalanHak.setText("Kalan Hak:"+sayac);



               }else{//Kaybettik
                   Intent i = new Intent(TahminActivity.this,SonucActivity.class);
                   i.putExtra("sonuc",false);
                   startActivity(i);
                   finish();
               }
               editText.setText("");
            }
        });
    }
}
