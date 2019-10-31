package com.example.ridvankabak.mydatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Muzisyenler",MODE_PRIVATE,null);

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS muzisyenler (name VARCHAR, age INT(2))");

            //myDatabase.execSQL("INSERT INTO muzisyenler (name,age) VALUES ('James',50)");//veri ekleme

            //myDatabase.execSQL("INSERT INTO muzisyenler (name,age) VALUES ('Harry',30)");//veri ekleme

            //myDatabase.execSQL("INSERT INTO muzisyenler (name,age) VALUES ('Chandler',26)");

            //myDatabase.execSQL("INSERT INTO muzisyenler (name,age) VALUES ('Ross',24)");

            //Cursor cursor = myDatabase.rawQuery("SELECT * FROM muzisyenler",null); //Cursor = Fare imlecimiz gibi tüm database'i geziyor.

            //Cursor cursor = myDatabase.rawQuery("SELECT * FROM muzisyenler WHERE age < 30",null); //Filtreleme kullandık, 30 yaşından küçükleri yazdırdık.

            //Cursor cursor = myDatabase.rawQuery("SELECT * FROM muzisyenler WHERE age < 30 AND name = 'Chandler'",null); //iki tane filtreleme kullandık,
            // yaşı 30dan küçük ismini çağırdığımız kişi

            //Cursor cursor = myDatabase.rawQuery("SELECT * FROM muzisyenler WHERE name LIKE '%a%'",null); //like= gibilerini getir
            // %a%=namelerin içinde a geçen kişileri getir.

            Cursor cursor = myDatabase.rawQuery("SELECT * FROM muzisyenler",null); //

            //myDatabase.execSQL("DELETE FROM muzisyenler WHERE name LIKE 'J%'"); //veri silme

            //myDatabase.execSQL("UPDATE muzisyenler SET age = 56 WHERE name = 'Harry'"); //veri guncelleme

            int nameIx = cursor.getColumnIndex("name");
            int ageIx = cursor.getColumnIndex("age");

            cursor.moveToFirst();//ilk veriye git
            while(cursor!=null){
                System.out.println("Name:" + cursor.getString(nameIx));
                System.out.println("Age:" + cursor.getString(ageIx));

                cursor.moveToNext();//sonra ki veriye git
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
