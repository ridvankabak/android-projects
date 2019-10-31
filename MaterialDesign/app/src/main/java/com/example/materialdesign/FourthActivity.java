package com.example.materialdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class FourthActivity extends AppCompatActivity {
    private RecyclerView rw;
    private MyAdapter adapter; // My adapterdan nesne oluşturmalıyız ki bağlayalım
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        rw = findViewById(R.id.rw);

        rw.setHasFixedSize(true); // Ekranı çevirsekte size koruyacak
        rw.setLayoutManager(new LinearLayoutManager(this)); //??

        ArrayList<String>ulkeler = new ArrayList<>();
        ulkeler.add("Türkiye");
        ulkeler.add("Amerika");
        ulkeler.add("Rusya");
        ulkeler.add("Japonya");
        ulkeler.add("İtalya");
        ulkeler.add("Fransa");

        adapter = new MyAdapter(this,ulkeler); //My adapterda istenilen verileri gönderiyoruz

        rw.setAdapter(adapter);//Adapterimizi bağlıyoruz


    }
}
