package com.example.materialdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private EditText username,password;
    private Button buttonYap,buttonIleri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        buttonYap=findViewById(R.id.buttonYap);
        buttonIleri=findViewById(R.id.buttonIleri);

        buttonIleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(i);
            }
        });
        buttonYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"username: "+username.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
