package com.example.gorselnesneler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    private Button buttonGecis3,buttonBasla,buttonBitir;
    private TextView textViewSlider,textViewOy;
    private ProgressBar progressBar;
    private SeekBar seekBar;
    private RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        buttonGecis3 = findViewById(R.id.buttonGecis3);
        buttonGecis3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ThirdActivity.this,FourthActivity.class);
                startActivity(i);
            }
        });
        buttonBasla = findViewById(R.id.buttonBasla);
        buttonBitir = findViewById(R.id.buttonBitir);
        textViewSlider = findViewById(R.id.textViewSlider);
        textViewOy = findViewById(R.id.textViewOy);
        progressBar = findViewById(R.id.progressBar);
        seekBar = findViewById(R.id.seekBar);
        ratingBar = findViewById(R.id.ratingBar);

        buttonBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
        buttonBitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewSlider.setText("Slider: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textViewOy.setText("Oy: "+((int)rating));
            }
        });





    }
}
