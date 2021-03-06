package com.example.listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String mTitle [] ={"Türkiye","İspanya","İsviçre","Hırvatistan","Hollanda","Amerika"};
    private String mDescription [] ={"Türkiye Hakkında","İspanya Hakkında","İsviçre Hakkında","Hırvatistan Hakkında","Hollanda Hakkında","Amerika Hakkında"};
    private ArrayAdapter<String> veriAdaptoru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this,mTitle,mDescription);
        listView.setAdapter(adapter);


    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        String rDesc[];



        MyAdapter (Context context,String title[],String description[]){
            super(context,R.layout.row,R.id.text1,title);
            this.context = context;
            this.rTitle = title;
            this.rDesc = description;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row,parent,false);

            TextView myTitle = row.findViewById(R.id.text1);
            TextView myDescription = row.findViewById(R.id.text2);

            myTitle.setText(rTitle[position]);
            myDescription.setText(rDesc[position]);

            return row;
        }
    }
}
