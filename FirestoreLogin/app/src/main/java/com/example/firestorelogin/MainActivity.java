package com.example.firestorelogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPassword;
    Button btnLogin, btnSignup;
    FirebaseAuth firebaseAuth;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    String username;
    String password;

    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmailLogin);
        editTextPassword = findViewById(R.id.editTextPasswordLogin);
        btnLogin = findViewById(R.id.buttonLogin);
        btnSignup = findViewById(R.id.buttonSignUp);
        firebaseAuth = FirebaseAuth.getInstance();

        sp = getSharedPreferences("Giris Bilgi",MODE_PRIVATE);
        editor = sp.edit();

        editTextEmail.setText(sp.getString("email", ""));
        editTextPassword.setText(sp.getString("password", ""));

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Main2Activity.class));

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = editTextEmail.getText().toString();
                final String password = editTextPassword.getText().toString();
                if(count>1){
                    if (count>1) {

                        editor.putString("email", email);
                        editor.putString("password", password);
                        editor.commit();
                    } else {
                        editor.clear();
                        editor.commit();
                        }
                    otoGiris();
                    }
                else{
                        if(TextUtils.isEmpty(email)){
                    editTextEmail.setError("Email gereklidir");
                    return;
                }
                        if(TextUtils.isEmpty(password)){
                    editTextPassword.setError("Password gereklidir");
                    return;
                }
                        if(password.length()<6){
                    editTextPassword.setError("Şifre en az 6 karakterli olmalı");
                    return;
                }

                        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Giriş başarılı", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),Main3Activity.class));
                                count++;

                            }else{
                            Toast.makeText(MainActivity.this, "Hata ! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        }
                        });
                    }
            }
        });
    }

    private void otoGiris() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        MainActivity.this.finish();
    }
}
