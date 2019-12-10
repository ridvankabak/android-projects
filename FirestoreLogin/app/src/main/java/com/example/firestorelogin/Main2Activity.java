package com.example.firestorelogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    EditText editTextUsername,editTextPassword,editTextEmail,editTextPhone;
    Button buttonSignUp;
    FirebaseFirestore fstore;
    FirebaseAuth firebaseAuth;
    String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextUsername = findViewById(R.id.editTextUsernameSignup);
        editTextPassword = findViewById(R.id.editTextPasswordSignup);
        editTextEmail = findViewById(R.id.editTextEmailSignup);
        editTextPhone = findViewById(R.id.editTextPhoneSignup);
        buttonSignUp = findViewById(R.id.btnSignUpp);

        firebaseAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = editTextUsername.getText().toString();
                final String password = editTextPassword.getText().toString();
                final String email = editTextEmail.getText().toString();
                final String phone = editTextPhone.getText().toString();

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


                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Main2Activity.this, "Kullanıcı oluşturuldu", Toast.LENGTH_SHORT).show();
                            userID =firebaseAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("users").document(userID);
                            final Map<String,Object> user = new HashMap<>();
                            user.put("username",username);
                            user.put("password",password);
                            user.put("email",email);
                            user.put("phone",phone);

                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("TAG","onSuccess: Kullanıcı profili oluşturuldu "+ userID);
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),Main3Activity.class));

                        }else{
                            Toast.makeText(Main2Activity.this, "Hata ! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });



    }
}
