package com.example.yasamdongusu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.textViewMsj);
        button = findViewById(R.id.buttonDonus);

        /*String gelenMesaj = getIntent().getStringExtra("mesaj");
        int gelenYas = getIntent().getIntExtra("yas",0);
        double gelenBoy = getIntent().getDoubleExtra("boy",0.0);
        boolean gelenBekarMi = getIntent().getBooleanExtra("bekarMi",false);*/
        Kisiler gelenKisiler = (Kisiler) getIntent().getSerializableExtra("nesne");

        textView.setText(gelenKisiler.getIsim()+" - "+gelenKisiler.getYas()+" - "+gelenKisiler.getBoy()+" - "+gelenKisiler.isBekarMi());



        ((View) button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}
