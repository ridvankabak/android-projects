package com.example.sozlukuygulamasi;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Kelimelerdao {
     public void kelimeEkle(VeritabaniYardimcisi vt, String ingilizce, String turkce){
         SQLiteDatabase dbx = vt.getWritableDatabase();
         ContentValues degerler = new ContentValues();

         degerler.put("ingilizce",ingilizce);
         degerler.put("turkce",turkce);

         dbx.insertOrThrow("kelimeler",null,degerler);
         dbx.close();
     }
     public ArrayList<Kelimeler>tumKelimeler (VeritabaniYardimcisi vt){
         ArrayList<Kelimeler>kelimelerArrayList = new ArrayList<>();
         SQLiteDatabase dbx = vt.getWritableDatabase();

         Cursor c = dbx.rawQuery("SELECT * FROM kelimeler",null);
         while(c.moveToNext()){
             Kelimeler kelime = new Kelimeler(c.getInt(c.getColumnIndex("kelime_id")),
                     c.getString(c.getColumnIndex("ingilizce")),
                     c.getString(c.getColumnIndex("turkce")));
             kelimelerArrayList.add(kelime);
         }
         return kelimelerArrayList;

     }
     public void kelimeSil(VeritabaniYardimcisi vt,int kelime_id){
         SQLiteDatabase dbx = vt.getWritableDatabase();
         dbx.delete("kelimeler","kelime_id=?",new String[]{String.valueOf(kelime_id)});
         dbx.close();
     }
     public void kelimeGuncelleme(VeritabaniYardimcisi vt,int kelime_id,String ingilizce,String turkce){
         SQLiteDatabase dbx = vt.getWritableDatabase();
         ContentValues degerler = new ContentValues();

         degerler.put("ingilizce",ingilizce);
         degerler.put("turkce",turkce);

         dbx.update("kelimeler",degerler,"kelime_id",new String[]{String.valueOf(kelime_id)});
         dbx.close();
     }
}
