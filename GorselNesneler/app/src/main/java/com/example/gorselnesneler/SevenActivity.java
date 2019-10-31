package com.example.gorselnesneler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SevenActivity extends AppCompatActivity {
    private Button buttonGoster;
    private Spinner spinner;
    ArrayList<String> meyveler = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven);
        buttonGoster=findViewById(R.id.buttonGoster);
        spinner=findViewById(R.id.spinner);

        meyveler.add("Elma");
        meyveler.add("Armut");
        meyveler.add("Çilek");
        meyveler.add("Muz");
        meyveler.add("Karpuz");

        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,android.R.id.text1,meyveler);
        spinner.setAdapter(arrayAdapter);
        buttonGoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String alinanVeri = spinner.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(),"Meyve: "+alinanVeri,Toast.LENGTH_SHORT).show();
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String secilenMeyve = meyveler.get(position);
                Toast.makeText(getApplicationContext(),"Meyve: "+secilenMeyve,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
