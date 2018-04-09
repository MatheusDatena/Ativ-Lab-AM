package com.example.alunos.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mudaTexto(View v) {
        TextView etiqueta = (TextView) findViewById(R.id.textView);
        etiqueta.setText(getResources().getString(R.string.lblHello2));
    }
}
