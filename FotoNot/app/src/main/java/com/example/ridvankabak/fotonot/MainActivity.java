package com.example.ridvankabak.fotonot;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    static Bitmap secilenResim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        final ArrayList<String> landmarkNames = new ArrayList<>();
        landmarkNames.add("Alanya");
        landmarkNames.add("Kaş");
        landmarkNames.add("Adrasan");
        landmarkNames.add("Olimpos");
        landmarkNames.add("Çıralı");

        Bitmap alanya = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.alanya);
        Bitmap kas = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.kas);
        Bitmap adrasan = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.adrasan);
        Bitmap olimpos = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.olimpos);
        Bitmap cirali = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.cirali);

        final ArrayList<Bitmap>landmarkImages = new ArrayList<>();

        landmarkImages.add(alanya);
        landmarkImages.add(kas);
        landmarkImages.add(adrasan);
        landmarkImages.add(olimpos);
        landmarkImages.add(cirali);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkNames);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("name",landmarkNames.get(position));
                secilenResim = landmarkImages.get(position);
                startActivity(intent);
            }
        });

    }
}
