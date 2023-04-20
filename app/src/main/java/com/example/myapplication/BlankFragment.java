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
import com.example.myapplication.databinding.FragmentBlankBinding;
import com.example.myapplication.entidades.Pessoa;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BlankFragment extends Fragment {

    FragmentBlankBinding binding;

    public BlankFragment (){
        super(R.layout.fragment_blank);
    }
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        binding = FragmentBlankBinding .inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getView()).navigate(R.id.action_blankFragment_to_blankFragment2);
            }
        });

        binding.btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseSingleton databaseSingleton = DatabaseSingleton.getInstancia(getContext());
                MyDatabase db = databaseSingleton.db;
                PessoaDao pessoaDao = db.pessoaDao();

                ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) pessoaDao.listarPessoas();
                ArrayList<String> nomesPessoas = new ArrayList<>();
                ArrayList<String> tipoPessoas = new ArrayList<>();

                pessoas.forEach(pessoa -> {
                    nomesPessoas.add(pessoa.getNome());
                    tipoPessoas.add(pessoa.getTipo());
                });

                if(binding.nome.getText().toString().equals("") || binding.tipo.getText().equals("")){
                    return;
                }

                for (int i = 0; i < nomesPessoas.size(); i++){
                    for (int j = 0; j < tipoPessoas.size(); j++){
                        if (nomesPessoas.get(i).equals(binding.nome.getText().toString())){
                            if(tipoPessoas.get(j).equals(binding.tipo.getText().toString())){
                                if (tipoPessoas.get(j).equals("professor")){
                                    Navigation.findNavController(getView()).navigate(R.id.action_blankFragment_to_blankFragment4);
                                    return;
                                }
                                Navigation.findNavController(getView()).navigate(R.id.action_blankFragment_to_blankFragment3);
                            }
                        }
                    }
                }
            }
        });
    }
}