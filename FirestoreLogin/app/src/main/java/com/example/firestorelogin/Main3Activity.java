package com.example.firestorelogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class Main3Activity extends AppCompatActivity {
    private Button buttonLogout,buttonUptade,buttonLoad;
    private EditText editTextUsername,editTextPassword,editTextEmail,editTextPhone;
    private TextView textView;
    String userID;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
    private DocumentReference noteRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        buttonLogout = findViewById(R.id.buttonLogout);
        buttonUptade = findViewById(R.id.buttonUptade);
        buttonLoad = findViewById(R.id.buttonLoad);
        editTextUsername = findViewById(R.id.editTextUsernameUptade);
        editTextPassword = findViewById(R.id.editTextPasswordUpdate);
        editTextEmail = findViewById(R.id.editTextEmailUptade);
        editTextPhone = findViewById(R.id.editTextPhoneUptade);
        textView = findViewById(R.id.textView);

        userID=firebaseAuth.getCurrentUser().getUid();
        noteRef = db.document("users/"+userID);

        verileriCek();



        buttonUptade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                String email = editTextEmail.getText().toString();
                String phone = editTextPhone.getText().toString();

                Map<String,Object> user = new HashMap<>();

                user.put("username",username);
                user.put("password",password);
                user.put("email",email);
                user.put("phone",phone);

                noteRef.set(user, SetOptions.merge());

                Toast.makeText(Main3Activity.this, "Güncellendi", Toast.LENGTH_SHORT).show();

            }
        });



        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();//log out
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });

        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){
                            String username = documentSnapshot.getString("username");
                            String password = documentSnapshot.getString("password");
                            String email = documentSnapshot.getString("email");
                            String phone = documentSnapshot.getString("phone");

                            editTextUsername.setText(username);
                            editTextPassword.setText(password);
                            editTextEmail.setText(email);
                            editTextPhone.setText(phone);
                            Toast.makeText(Main3Activity.this, "Veriler geldi", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(getApplicationContext(), "Document does not exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        Log.d("tag",e.toString());

                    }
                });
            }
        });




    }


    private void verileriCek() {
        noteRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    String username = documentSnapshot.getString("username");
                    String password = documentSnapshot.getString("password");
                    String email = documentSnapshot.getString("email");
                    String phone = documentSnapshot.getString("phone");

                    editTextUsername.setText(username);
                    editTextPassword.setText(password);
                    editTextEmail.setText(email);
                    editTextPhone.setText(phone);

                }else {
                    Toast.makeText(getApplicationContext(), "Document does not exist", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                Log.d("tag",e.toString());

            }
        });
    }
}
