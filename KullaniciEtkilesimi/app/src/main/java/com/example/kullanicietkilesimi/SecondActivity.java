package com.example.kullanicietkilesimi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private Button buttonYap,buttonDegistir2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        buttonYap=findViewById(R.id.buttonYap);
        buttonDegistir2=findViewById(R.id.ButtonDegistir2);
        buttonDegistir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(i);
            }
        });
        buttonYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(SecondActivity.this,buttonYap); // Context verip, hangi işlemden sonra pop up çalışcağını belirtiyoruz
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu_tasarim,popupMenu.getMenu()); // xml yolunu gösteriyoruz
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.action_sil:
                                Toast.makeText(getApplicationContext(),"Sil seçildi",Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.action_duzenle:
                                Toast.makeText(getApplicationContext(),"Duzenle secildi",Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;

                        }
                    }
                });

            }
        });
    }
}
