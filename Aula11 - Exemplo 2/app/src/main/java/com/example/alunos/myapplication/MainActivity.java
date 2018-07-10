package com.example.alunos.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Cria o layout

        TableLayout tabela = new TableLayout(this);
        tabela.setPadding(10, 10, 10, 10);
        tabela.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));

        //Expande a coluna 1
        tabela.setColumnStretchable(1, true);
        //Linha 1
        TableRow linha1 = new TableRow(this);
        TextView nome = new TextView(this);
        nome.setText("Nome: ");
        linha1.addView(nome);
        EditText tnome = new EditText(this);
        //Focus
        tnome.requestFocus();
        linha1.addView(tnome);

        //Linha 2
        TableRow linha2 = new TableRow(this);
        TextView senha = new TextView(this);
        senha.setText("Senha: ");
        linha2.addView(senha);
        EditText tsenha = new EditText(this);
        tsenha.setTransformationMethod(
                new PasswordTransformationMethod());
        linha2.addView(tsenha);

        //Linha 3

        TableRow linha3 = new TableRow(this);
        linha3.setGravity(Gravity.RIGHT);
        //Botão alinhado a direita
        Button ok = new Button(this);
        ok.setText("Login: ");
        linha3.addView(ok);

        //Adiciona as linhas
        tabela.addView(linha1);
        tabela.addView(linha2);
        tabela.addView(linha3);

        //Informa o layout
        setContentView(tabela);
    }
}
