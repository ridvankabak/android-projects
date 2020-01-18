package com.example.loginekranisp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainAnaActivity extends AppCompatActivity {
    private TextView textView;
    private Button buttonCikis;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ana);

        textView = findViewById(R.id.textViewAna);
        buttonCikis = findViewById(R.id.buttonCikis);

        sp = getSharedPreferences("GirisBilgi",MODE_PRIVATE);
        editor = sp.edit();

        username = sp.getString("username","kullanici adi yok");
        password = sp.getString("password","sifre yok");

        textView.setText("Username : "+username+" Password : "+password);

        buttonCikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove("username");
                editor.remove("password");
                editor.commit();

                startActivity(new Intent(MainAnaActivity.this,MainActivity.class));
                finish();
            }
        });






    }

}
