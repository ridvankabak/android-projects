package com.example.kullanicietkilesimi;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {
    private Button buttonNormal,buttonGeriDonuslu,buttonOzel;
    private ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        buttonNormal=findViewById(R.id.buttonNormalS);
        buttonGeriDonuslu=findViewById(R.id.buttonGeriDonusluS);
        buttonOzel=findViewById(R.id.buttonOzelS);

        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Merhaba Dünya",Snackbar.LENGTH_SHORT).show();
            }
        });
        buttonGeriDonuslu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Mesaj silinsin mi?",Snackbar.LENGTH_SHORT)
                        .setAction("Evet", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar.make(v,"Mesaj silindi",Snackbar.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
        buttonOzel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v,"İnternet bağlantısı yok!",Snackbar.LENGTH_SHORT).setAction("Tekrar dene", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                snackbar.setActionTextColor(Color.BLUE);

                View view = snackbar.getView();
                TextView textView = view.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.GREEN);

                snackbar.show();
            }
        });

    }
}
