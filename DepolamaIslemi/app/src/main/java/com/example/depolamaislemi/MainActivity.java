package com.example.depolamaislemi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText editTextGirdi;
    private Button buttonOku,buttonYaz,buttonSil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextGirdi=findViewById(R.id.editTextGirdi);
        buttonOku=findViewById(R.id.buttonOku);
        buttonYaz = findViewById(R.id.buttonYaz);
        buttonSil=findViewById(R.id.buttonSil);

        buttonYaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hariciYaz();
                dahiliYaz();
            }
        });

        buttonOku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hariciOku();
                dahiliOku();

            }
        });
        buttonSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hariciSil();
                dahiliSil();

            }
        });
    }
    public void hariciYaz(){
        try {

            File dosyaYolu = Environment.getExternalStorageDirectory(); //dosya yolumuzu aldık

            File dosya = new File(dosyaYolu,"dosyam.txt");// dosyamızı oluşturduk

            if(!dosya.exists()){
                dosya.createNewFile(); // kontrol ettik daha önce oluşturduk diyerek, ona göre kayıt işlemi yaptık

            }
            FileWriter fw  = new FileWriter(dosya);

            BufferedWriter yazici = new BufferedWriter(fw);

            yazici.write(editTextGirdi.getText().toString());

            yazici.flush();
            yazici.close();
            fw.close();

            editTextGirdi.setText("");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void hariciOku(){
        try {

            File dosyaYolu = Environment.getExternalStorageDirectory();

            File dosya = new File(dosyaYolu,"dosyam.txt");

            FileReader fr  = new FileReader(dosya);

            BufferedReader okuyucu = new BufferedReader(fr);

            StringBuilder sb = new StringBuilder();

            String satir = "";

            while((satir = okuyucu.readLine()) != null){
                sb.append(satir+"\n");

            }
            okuyucu.close();
            editTextGirdi.setText(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void hariciSil(){
            File dosyaYolu = Environment.getExternalStorageDirectory(); //dosya yolumuzu aldık

            File dosya = new File(dosyaYolu,"dosyam.txt");// dosyamızı oluşturduk

            dosya.delete();
            editTextGirdi.setText("silindi");
    }
    public void dahiliYaz(){
        try{
            FileOutputStream fos = openFileOutput("dosyam.txt",MODE_PRIVATE);
            OutputStreamWriter yazici = new OutputStreamWriter(fos);
            yazici.write(editTextGirdi.getText().toString());
            yazici.close();
            editTextGirdi.setText("");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void dahiliOku(){
        try {
            FileInputStream fis = openFileInput("dosyam.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader okuyucu = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();

            String satir = "";

            while((satir = okuyucu.readLine()) != null){
                sb.append(satir+"\n");

            }
            okuyucu.close();
            editTextGirdi.setText(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void dahiliSil(){
        File yol = getFilesDir();
        File file = new File(yol,"dosyam.txt");
        editTextGirdi.setText(String.valueOf(file.delete()));
    }
}
