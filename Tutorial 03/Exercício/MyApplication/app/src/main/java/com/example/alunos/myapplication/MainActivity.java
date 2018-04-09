package com.example.alunos.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void criaAleatorio(){
        Random ran = new Random();
        num = ran.nextInt(10)+1;
    }

    public void Tentar(View v) {
        TextView etiqueta = (TextView) findViewById(R.id.textView);
        EditText tentativa = findViewById(R.id.editText);
        int erros = 0;
            if(tentativa == num){
                etiqueta.setText(getResources().getString(R.string.lblAcertou));
                erros = 0;
                criaAleatorio();
            }else{
                etiqueta.setText(getResources().getString(R.string.lblTenta));
                erros++;
            }
        if(erros == 3){
            etiqueta.setText(getResources().getString(R.string.lblErrou));
        }

        etiqueta.setText(getResources().getString(R.string.lblHello));
    }

}
