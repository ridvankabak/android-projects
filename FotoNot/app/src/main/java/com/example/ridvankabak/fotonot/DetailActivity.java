package com.example.ridvankabak.fotonot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        textView.setText(name);
        imageView.setImageBitmap(MainActivity.secilenResim);


    }
}
