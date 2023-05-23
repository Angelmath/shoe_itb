package com.example.myapplication.DB.entidades;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.DB.sqlite.ConstantesDB;

public class AdminSqliteOpenHelper extends SQLiteOpenHelper{
        public AdminSqliteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
                super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
                sqLiteDatabase.execSQL(ConstantesDB.CREAR_TABLA_USUARIO);
                sqLiteDatabase.execSQL(ConstantesDB.AGREGAR_USUARIO_DEFAULT);
                sqLiteDatabase.execSQL(ConstantesDB.AGREGAR_USUARIO_DEFAULT2);
                sqLiteDatabase.execSQL(ConstantesDB.CREAR_TABLA_ARTICULO);

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
                sqLiteDatabase.execSQL(ConstantesDB.IF_EXIST + ConstantesDB.CREAR_TABLA_USUARIO);
                sqLiteDatabase.execSQL(ConstantesDB.IF_EXIST + ConstantesDB.CREAR_TABLA_ARTICULO);
                onCreate(sqLiteDatabase);
        }
}
