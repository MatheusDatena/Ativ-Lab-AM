package com.example.alunos.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.alunos.recyclerview.adapter.LivroAdapter;
import com.example.alunos.recyclerview.adapter.LivroViewHolder;
import com.example.alunos.recyclerview.model.Livro;

import java.util.ArrayList;

public class mostraLivro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_livro);

        RecyclerView rview = findViewById(R.id.recyclerView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        try{
            ArrayList<Livro> lista = bundle.getParcelableArrayList(
                    "livros");
            Log.d("tamanho", Integer.toString(lista.size()));
            LivroAdapter adapter = new LivroAdapter(
                    lista, getBaseContext());
            rview.setAdapter(adapter);
            RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                    LinearLayoutManager.VERTICAL, false);
            rview.setLayoutManager(layout);
        }
        catch (Exception e){
            Log.d(e.getClass().toString(), e.getMessage());
        }
    }
}

