package com.example.gorselnesneler;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class FiveActivity extends AppCompatActivity {
    private EditText editTextSaat,editTextTarih;
    private Button buttonGecis4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        buttonGecis4=findViewById(R.id.buttonGecis4);
        editTextSaat=findViewById(R.id.editTextSaat);
        editTextTarih=findViewById(R.id.editTextTarih);

        editTextSaat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int saat=c.get(Calendar.HOUR_OF_DAY); //Cihazdaki o anki saati alıyoruz
                int dk = c.get(Calendar.MINUTE);// cihazdaki o anki dakikayı alıyoruz

                TimePickerDialog timePicker; //Görsel Saat nesnesini oluşturuyoruz
                timePicker = new TimePickerDialog(FiveActivity.this , new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        editTextSaat.setText(hourOfDay+":"+minute);
                    }
                },saat,dk,true); // saat veya dk yazmak yerine kendimizde elle atayabiliyoruz

                timePicker.setTitle("Saat seçiniz:");
                timePicker.setButton(TimePickerDialog.BUTTON_POSITIVE,"Ayarla",timePicker);
                timePicker.setButton(TimePickerDialog.BUTTON_NEGATIVE,"İptal",timePicker);
                timePicker.show();

            }
        });
        editTextTarih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int yil= c.get(Calendar.YEAR);
                int ay = c.get(Calendar.MONTH);
                int gun = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker;
                datePicker = new DatePickerDialog(FiveActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editTextTarih.setText(dayOfMonth +"/"+(month+1)+"/"+year);
                    }
                },yil,ay,gun);
                datePicker.setTitle("Saat seçiniz:");
                datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE,"Ayarla",datePicker);
                datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE,"İptal",datePicker);
                datePicker.show();
            }
        });
        buttonGecis4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FiveActivity.this,SixActivity.class);
                startActivity(i);
            }
        });
    }
}
