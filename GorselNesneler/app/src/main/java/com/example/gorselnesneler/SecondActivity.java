package com.example.gorselnesneler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private CheckBox checkBoxJava,checkBoxC,checkBoxPython,checkBoxCss,checkBoxPascal;
    private RadioButton radioButtonFb,radioButtonBjk,radioButtonGs,radioButtonBursa,radioButtonDenizli;
    private Button buttonSonuc,buttonGecis2;
    private String dilSonuclari = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        checkBoxJava = findViewById(R.id.checkBoxJava);
        checkBoxC = findViewById(R.id.checkBoxC);
        checkBoxPython = findViewById(R.id.checkBoxPython);
        checkBoxCss = findViewById(R.id.checkBoxCss);
        checkBoxPascal = findViewById(R.id.checkBoxPascal);

        radioButtonFb = findViewById(R.id.radioButtonFB);
        radioButtonBjk = findViewById(R.id.radioButtonBjk);
        radioButtonGs = findViewById(R.id.radioButtonGs);
        radioButtonBursa = findViewById(R.id.radioButtonBs);
        radioButtonDenizli = findViewById(R.id.radioButtonDenizli);

        buttonGecis2=findViewById(R.id.buttonGecis2);
        buttonSonuc = findViewById(R.id.buttonSonuc);
        buttonSonuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBoxJava.isChecked()){
                    dilSonuclari += "Java ";
                }
                if(checkBoxC.isChecked()){
                    dilSonuclari += "C ";
                }
                if(checkBoxCss.isChecked()){
                    dilSonuclari += "Css ";
                }
                if(checkBoxPython.isChecked()){
                    dilSonuclari += "Python ";
                }
                if(checkBoxPascal.isChecked()){
                    dilSonuclari += "Pascal ";
                }
                Toast.makeText(getApplicationContext(),dilSonuclari,Toast.LENGTH_SHORT).show();
                dilSonuclari = "";
            }
        });
        radioButtonFb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.e("Fenerbahce",String.valueOf(isChecked));
            }
        });
        buttonGecis2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(i);
            }
        });

    }
}
