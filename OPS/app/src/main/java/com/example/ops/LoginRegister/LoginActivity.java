package com.example.ops.LoginRegister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ops.R;
import com.example.ops.Main2.Main2Activity;

public class LoginActivity extends AppCompatActivity {
    private Button buttonLogin,buttonSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin=findViewById(R.id.buttonLogin);
        buttonSignUp=findViewById(R.id.buttonSignUp);


    }
    public void login(View view){
        Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
        startActivity(intent);
    }

    public void signUp(View view){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
