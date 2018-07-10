package com.example.alunos.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alunos.recyclerview.adapter.LivroAdapter;
import com.example.alunos.recyclerview.model.Livro;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTitulo;
    EditText editAutor;
    EditText editDesc;

    ArrayList<Livro> listaLivros = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTitulo = (EditText)findViewById(R.id.editTitulo);
        editAutor = (EditText)findViewById(R.id.editAutor);
        editDesc = (EditText)findViewById(R.id.editDesc);

    }
    public void salvar(View V){
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        String titulo = editTitulo.getText().toString();
        String autor  = editAutor.getText().toString();
        String descricao = editDesc.getText().toString();
        if(titulo.matches("") && autor.matches("") && descricao.matches("") ){
            Toast toast = Toast.makeText(MainActivity.this,
                    "Digite algo...", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        SharedPreferences.Editor editor = arquivo.edit();
        editor.putString("titulo", titulo);
        editor.putString("autor", autor);
        editor.putString("descricao", descricao);
        editor.commit();
        editTitulo.setText("");
        editAutor.setText("");
        editDesc.setText("");

        listaLivros.add(new Livro(titulo, autor, descricao));
    }
    public void mostrarLivro(View v){
        Log.d("tamanho da lista", Integer.toString(listaLivros.size()));
        Intent it = new Intent(this, mostraLivro.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("livros", listaLivros);
        it.putExtras(bundle);
        startActivity(it);
    }
}
