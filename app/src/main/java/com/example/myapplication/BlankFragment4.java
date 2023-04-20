package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.example.myapplication.database.MyDatabase;
import com.example.myapplication.database.PessoaDao;
import com.example.myapplication.databinding.FragmentBlank4Binding;
import com.example.myapplication.entidades.Pessoa;

import java.util.ArrayList;

public class BlankFragment4 extends Fragment {

    FragmentBlank4Binding binding;

    public BlankFragment4 (){
        super(R.layout.fragment_blank4);
    }
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        binding = FragmentBlank4Binding .inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DatabaseSingleton databaseSingleton = DatabaseSingleton.getInstancia(getContext());
        MyDatabase db = databaseSingleton.db;
        PessoaDao pessoaDao = db.pessoaDao();

        ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) pessoaDao.listarPessoas();
        ArrayList<String> alunosTxT = new ArrayList<>();

        pessoas.forEach(pessoa -> {
            if (pessoa.getTipo().equals("aluno")){
                alunosTxT.add(pessoa.getNome());
            }
        });

        ArrayAdapter<Adapter> adapter = new ArrayAdapter<Adapter>();

        binding.listarAlunos.setAdapter(adapter);

        binding.listarAlunos.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_blankFragment4_to_blankFragment2, null));
    }

}