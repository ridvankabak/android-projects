package com.example.gorselnesneler;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import java.net.URI;

public class FourthActivity extends AppCompatActivity {
    private Button buttonDegistir,buttonBasla,buttonDurdur,buttonGecis3;
    private ImageView imageView;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        buttonGecis3=findViewById(R.id.buttonGecis3);
        buttonDegistir=findViewById(R.id.buttonDegistir);
        buttonBasla=findViewById(R.id.buttonBasla);
        buttonDurdur=findViewById(R.id.buttonDurdur);
        imageView=findViewById(R.id.imageView);
        videoView=findViewById(R.id.videoView);

        buttonDegistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.okey);
            }
        });
        buttonBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri adres = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);
                videoView.setVideoURI(adres);
                videoView.start();
            }
        });
        buttonDurdur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.stopPlayback();
            }
        });
        buttonGecis3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FourthActivity.this,FiveActivity.class);
                startActivity(i);
            }
        });
    }
}
