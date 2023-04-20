package com.example.myapplication.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapplication.entidades.Pessoa;

@Database(entities = {Pessoa.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    public abstract PessoaDao pessoaDao();
}
