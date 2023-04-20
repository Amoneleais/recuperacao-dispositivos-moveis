package com.example.myapplication.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.entidades.Pessoa;

import java.util.List;

@Dao
public interface PessoaDao {

    @Insert
    long inserir(Pessoa pessoa);

    @Query("SELECT * FROM Pessoa")
    List<Pessoa> listarPessoas();
}
