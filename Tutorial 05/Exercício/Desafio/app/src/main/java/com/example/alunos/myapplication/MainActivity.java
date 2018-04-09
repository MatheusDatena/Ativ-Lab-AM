package com.example.alunos.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alunos.myapplication.model.Pessoa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pessoa> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editName = findViewById(R.id.editName);
        EditText editTelefone = findViewById(R.id.editTelefone);

        String name = editName.getText().toString();
        String telefone  = editTelefone.getText().toString();

        System.out.println(name);

        lista.add(new Pessoa(name, telefone,
                R.mipmap.ic_launcher_round));
        //lista.add(new Pessoa("Pedro da Silva", "3690-1234",
                //R.mipmap.ic_launcher_round));
    }

    public void mostrarLista(View v){
        Intent it = new Intent(this, mostraListaDinamica.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("contatos", lista);
        it.putExtras(bundle);
        startActivity(it);
    }
}
