package com.example.kullanicietkilesimi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button buttonNormal,buttonOzel,buttonDegistir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNormal=findViewById(R.id.buttonGeriDonusluS);
        buttonOzel=findViewById(R.id.buttonOzelS);
        buttonDegistir=findViewById(R.id.buttonDegistir);

        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Normal Toast Mesaj",Toast.LENGTH_LONG).show();
            }
        });
        buttonOzel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View tasarim=getLayoutInflater().inflate(R.layout.ozel_toast_tasarim,null);
                TextView textView = tasarim.findViewById(R.id.textViewMesaj);
                textView.setText("Merhaba Ozel Toast");
                Toast ozel = new Toast(getApplicationContext());
                ozel.setView(tasarim);
                ozel.setDuration(Toast.LENGTH_LONG);
                ozel.show();
            }
        });
        buttonDegistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });
    }
}
