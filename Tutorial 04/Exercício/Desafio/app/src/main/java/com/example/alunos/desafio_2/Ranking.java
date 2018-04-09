package com.example.alunos.desafio_2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Context;
import android.widget.Toast;

public class Ranking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        Intent intencao = getIntent();
        Bundle pacote = intencao.getExtras();

        String strPlacar = pacote.getString("placar");
        TextView txtRanking = (TextView) findViewById(R.id.txtRanking);
        txtRanking.setText(strPlacar);
    }
}
