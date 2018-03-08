package com.example.alunos.jogo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent intencao = getIntent();
        Bundle pacote = intencao.getExtras();

        String nome = pacote.getString("nome");
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(String.format("Olá, %s !", nome));
    }
}
