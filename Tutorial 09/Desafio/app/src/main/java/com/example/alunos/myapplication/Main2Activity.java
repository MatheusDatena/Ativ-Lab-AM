package com.example.alunos.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.alunos.myapplication.adapter.PessoaAdapter;
import com.example.alunos.myapplication.model.Pessoa;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView listview = findViewById(R.id.listView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        try{
            ArrayList<Pessoa> lista = bundle.getParcelableArrayList(
                    "contatos");
            PessoaAdapter adapter = new PessoaAdapter(
                    Main2Activity.this, lista);
            listview.setAdapter(adapter);
        }
        catch (Exception e){
            Log.d(e.getClass().toString(), e.getMessage());
        }
    }
}
