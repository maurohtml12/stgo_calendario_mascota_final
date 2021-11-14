package com.example.basecalendariomascota.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    //contructor para instancia base de datos...

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
     //para definir modelo de trabajo...
    @Override
    public void onCreate(SQLiteDatabase db) {
         //se define modelo de trabajo...
        db.execSQL("CREATE TABLE vacunas(numero int primary key, vacuna text, inoculacion text, proxima text)");
        db.execSQL("CREATE TABLE mascotas(numeros int primary key, nombre text, tipo text,raza text,edad text, nacim text )");

    }
     //permite realizar cambio esquematicos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
