package com.example.gorselnesneler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SixActivity extends AppCompatActivity {
    private Button buttonGecis5;
    private ListView listView;
    private ArrayList<String> meyveler = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
        buttonGecis5 =findViewById(R.id.buttonGecis5);
        listView = findViewById(R.id.listView);

        meyveler.add("Armut");
        meyveler.add("Elma");
        meyveler.add("Portakal");
        meyveler.add("Mandalina");
        meyveler.add("Çilek");
        meyveler.add("Greyfurt");
        meyveler.add("Avakado");
        meyveler.add("Kivi");
        meyveler.add("Muz");
        meyveler.add("Ananas");

        arrayAdapter = new ArrayAdapter<String>(SixActivity.this,android.R.layout.simple_expandable_list_item_1,android.R.id.text1,meyveler);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Meyve: " + meyveler.get(position),Toast.LENGTH_SHORT).show();
            }
        });
        buttonGecis5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SixActivity.this,SevenActivity.class);
                startActivity(i);
            }
        });
    }
}
