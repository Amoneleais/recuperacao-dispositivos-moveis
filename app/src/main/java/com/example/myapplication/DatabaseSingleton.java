package com.example.myapplication;

import android.content.Context;

import androidx.room.Room;

import com.example.myapplication.database.MyDatabase;

public class DatabaseSingleton {

    static DatabaseSingleton objeto;

    public MyDatabase db;

    public static DatabaseSingleton getInstancia(Context contexto){
        if (objeto == null){
            objeto = new DatabaseSingleton();
            objeto.db = Room.databaseBuilder(contexto, MyDatabase.class, "database-name").allowMainThreadQueries().build();
        }
        return objeto;
    }

    private DatabaseSingleton(){

    }
}
