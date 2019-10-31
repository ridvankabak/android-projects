package com.example.kullanicietkilesimi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    private Button buttonNormal,buttonOzel,buttonDegistir3;
    EditText editTextAlert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        buttonNormal=findViewById(R.id.buttonGeriDonusluS);
        buttonOzel=findViewById(R.id.buttonOzelS);
        buttonDegistir3=findViewById(R.id.buttonDegistir3);

        buttonDegistir3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ThirdActivity.this,FourthActivity.class);
                startActivity(i);
            }
        });
        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ao = new AlertDialog.Builder(ThirdActivity.this);
                ao.setIcon(R.drawable.resimm);
                ao.setTitle("Başlık");
                ao.setMessage("Mesaj");
                ao.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Tamam secildi",Toast.LENGTH_SHORT).show();
                    }
                });
                ao.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"İptal seçiildi",Toast.LENGTH_SHORT).show();
                    }
                });
                ao.create().show();
            }
        });
        buttonOzel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View tasarim = getLayoutInflater().inflate(R.layout.ozel_alert_tasarim,null);
                editTextAlert = tasarim.findViewById(R.id.editTextAlert);
                AlertDialog.Builder ao = new AlertDialog.Builder(ThirdActivity.this);
                ao.setMessage("Mesaj");
                ao.setView(tasarim);
                ao.setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String alinanVeri = editTextAlert.getText().toString();
                        Toast.makeText(getApplicationContext(),"Kayıt edilen veri: "+alinanVeri,Toast.LENGTH_SHORT).show();
                    }
                });
                ao.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Kayıt iptal edildi",Toast.LENGTH_SHORT).show();
                    }
                });
                ao.create().show();
            }
        });


    }
}
