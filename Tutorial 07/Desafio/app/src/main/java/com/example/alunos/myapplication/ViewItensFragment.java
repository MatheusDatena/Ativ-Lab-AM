package com.example.alunos.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.alunos.myapplication.adapter.PessoaAdapter;
import com.example.alunos.myapplication.model.Pessoa;

import java.util.ArrayList;

public class ViewItensFragment extends Fragment{

    MainActivity main;

    ListView listView;

    ArrayList<Pessoa> Rlista;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        main = (MainActivity) getActivity();
        Rlista = main.getLista();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_view_items_layout,
                container, false);
        listView  = v.findViewById(R.id.listView);

        try{
            PessoaAdapter adapter = new PessoaAdapter(
                    main, Rlista);
            listView.setAdapter(adapter);
        }
        catch (Exception e){
            Log.d(e.getClass().toString(), e.getMessage());
        }
        return v;
    }

}
