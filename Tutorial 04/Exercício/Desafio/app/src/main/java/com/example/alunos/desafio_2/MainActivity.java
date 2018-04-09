package com.example.alunos.desafio_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import android.widget.Toast;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    int num;
    int tentativas = 0;
    int placar = 1000;
    int ranking[] =  new int[];
    int jogadas = 0;

    ArrayList<HashMap<Integer, Integer>> valores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sorteia();
    }

    public void sorteia() {
        Random r = new Random();
        num = r.nextInt(1000) + 1;
    }

    public void jogar(View v) {
        jogadas = 1;
        TextView txtResultado = findViewById(R.id.txtResultado);
        EditText userInput = findViewById(R.id.editText);
        String teste = userInput.getText().toString();
        int n = Integer.parseInt(teste);

        if (n < num) {
            tentativas++;
            Toast toast = Toast.makeText(MainActivity.this,
                    "Seu palpite foi MENOR que o número sorteado!", Toast.LENGTH_SHORT);
            toast.show();
            userInput.setText("");
            return;
        } else if (n > num) {
            tentativas++;
            Toast toast = Toast.makeText(MainActivity.this,
                    "Seu palpite foi MAIOR que o número sorteado!", Toast.LENGTH_SHORT);
            toast.show();
            userInput.setText("");
            return;
        } else {
            placar = 1000 - tentativas;
            String strPlacar = Integer.toString(placar);
            Toast toast = Toast.makeText(MainActivity.this,
                    "Parabéns! Você ganhou", Toast.LENGTH_SHORT);
            toast.show();
            userInput.setText("");
            return;

            txtResultado.setText(strPlacar);

            placar = 1000 - tentativas;
            String strPlacar = Integer.toString(placar);
            SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = arquivo.edit();
            editor.putString("placar", strPlacar);
            editor.commit();

            Intent i = new Intent(MainActivity.this, Placar.class);

            Bundle bundle = new Bundle();
            bundle.putString("placar", strPlacar);
            i.putExtras(bundle);
            startActivity(i);

            for (int i = 0; i < 5; i++){
                HashMap<Integer, Integer> item = new HashMap<>();
                item.put("ranking", ranking[i]);
                valores.add(item);
            }

            valores.add();
        }
        }
    }

    public void reiniciar(View v){
        sorteia();
        placar = 1000;
        tentativas = 0;
    }

    public void placar(View v){
        //placar = 1000 - tentativas;
        String strPlacar = Integer.toString(placar);
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = arquivo.edit();
        editor.putString("placar", strPlacar);
        editor.commit();

        for(int i = 0; i < 5; i++){
            Intent it = new Intent(MainActivity.this, Ranking.class);
            Bundle bundle = new Bundle();
            bundle.putString("placar", strPlacar);
            it.putExtras(bundle);
            startActivity(it);
        }
    }
}