package com.example.sayitahmin;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SonucActivity extends AppCompatActivity {
    private ImageView imageViewSonuc;
    private TextView textViewSonuc;
    private Button buttonTekrar;
    private boolean sonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        imageViewSonuc=findViewById(R.id.imageViewSonuc);
        textViewSonuc=findViewById(R.id.textViewSonuc);
        buttonTekrar=findViewById(R.id.buttonTekrar);

        sonuc = getIntent().getBooleanExtra("sonuc",false);
        if(sonuc){
            imageViewSonuc.setImageResource(R.drawable.mood_resim);
            textViewSonuc.setText("Kazandınız");
            textViewSonuc.setTextColor(Color.BLUE);
        }
        else{
            imageViewSonuc.setImageResource(R.drawable.dissatisfied_resim);
            textViewSonuc.setText("Kaybettiniz");
            textViewSonuc.setTextColor(Color.BLACK);
        }

        buttonTekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SonucActivity.this,TahminActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
