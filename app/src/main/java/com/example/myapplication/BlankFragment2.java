package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.database.MyDatabase;
import com.example.myapplication.database.PessoaDao;
import com.example.myapplication.databinding.FragmentBlank2Binding;
import com.example.myapplication.entidades.Pessoa;

public class BlankFragment2 extends Fragment {


    FragmentBlank2Binding binding;

    public BlankFragment2 (){
        super(R.layout.fragment_blank2);
    }
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        binding = FragmentBlank2Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DatabaseSingleton databaseSingleton = DatabaseSingleton.getInstancia(getContext());
        MyDatabase db = databaseSingleton.db;

        binding.btnCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pessoa pessoa = new Pessoa(0, binding.nome.getText().toString(), binding.tipo.getText().toString());
                db.pessoaDao().inserir(pessoa);
                Navigation.findNavController(getView()).navigate(R.id.action_blankFragment2_to_blankFragment);
            }
        });
    }
}