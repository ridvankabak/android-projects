package com.example.materialdesign;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private Toolbar toolbar;
    private Button buttonilerii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        toolbar = findViewById(R.id.toolbar);
        buttonilerii = findViewById(R.id.buttonilerii);

        buttonilerii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ThirdActivity.this,FourthActivity.class);
                startActivity(i);
            }
        });
        toolbar.setTitle("Başlık");
        toolbar.setSubtitle("Alt Başlık");
        toolbar.setLogo(R.drawable.resimm);
        toolbar.setTitleTextColor(Color.YELLOW);


        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tasarim, menu);

        MenuItem menuItem = menu.findItem(R.id.action_arama);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(ThirdActivity.this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_ekle:
                Toast.makeText(getApplicationContext(),"Ekle seçildi",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_sill:
                Toast.makeText(getApplicationContext(),"Sil seçildi",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }



    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        Log.e("TextSubmit",s);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        Log.e("TextChange",s);
        return true;
    }
}
