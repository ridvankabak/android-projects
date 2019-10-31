package com.example.ridvankabak.landmark;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static Bitmap secilenResim;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        final ArrayList<String> landmarkNames = new ArrayList<String>();
        landmarkNames.add("Pamukkale");
        landmarkNames.add("Kaklık mağarası");
        landmarkNames.add("Laodikya Antik Kenti");
        landmarkNames.add("Hierepolis Antik Kenti");
        landmarkNames.add("Karahayıt");

        Bitmap pamukkale = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pamukkale);
        Bitmap kaklik = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.kaklik);
        Bitmap laodikya = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.laodikya);
        Bitmap hierapolis = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.hierapolis);
        Bitmap karahayit = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.karahayit);

        final ArrayList<Bitmap> landmarkImages = new ArrayList<>();

        landmarkImages.add(pamukkale);
        landmarkImages.add(kaklik);
        landmarkImages.add(laodikya);
        landmarkImages.add(hierapolis);
        landmarkImages.add(karahayit);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkNames);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
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
