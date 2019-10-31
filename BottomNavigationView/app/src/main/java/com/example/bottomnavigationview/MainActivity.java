package com.example.bottomnavigationview;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNav=findViewById(R.id.bottomNav);

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentTutucu, new BirinciFragment()).commit();

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;

                if(menuItem.getItemId() == R.id.action_anasayfa){
                    fragment= new BirinciFragment();
                }
                if(menuItem.getItemId() == R.id.action_kesfet){
                    fragment= new IkinciFragment();
                }
                if(menuItem.getItemId() == R.id.action_mesaj){
                    fragment= new UcuncuFragment();
                }
                if(menuItem.getItemId() == R.id.action_profil){
                    fragment= new DorduncuFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentTutucu, fragment).commit();

                return true;


            }
        });
    }
}
