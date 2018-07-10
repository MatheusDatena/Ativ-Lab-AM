package com.example.alunos.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView nome;
    private TextView sobrenome;
    private TextView email;
    private TextView endereco;
    private TextView cidade;
    private TextView estado;
    private TextView username;
    private TextView senha;
    private TextView nascimento;
    private TextView telefone;
    private ImageView foto;
    private ProgressBar load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetJson download = new GetJson();

        //load = (ProgressBar) findViewById(R.id.simpleProgressBar);

        nome = (TextView) findViewById(R.id.textNome);
        sobrenome = (TextView) findViewById(R.id.textSobrenome);
        email = (TextView) findViewById(R.id.textEmail);
        endereco = (TextView) findViewById(R.id.textEndereco);
        cidade = (TextView) findViewById(R.id.textCidade);
        estado = (TextView) findViewById(R.id.textEstado);
        username = (TextView) findViewById(R.id.textUsername);
        senha = (TextView) findViewById(R.id.textSenha);
        nascimento = (TextView) findViewById(R.id.textNascimento);
        telefone = (TextView) findViewById(R.id.textTelefone);
        foto = (ImageView) findViewById(R.id.imageView);

        //Chama Async Task
        download.execute();
    }

    private class GetJson extends AsyncTask<Void, Void, FakeUser> {

        @Override
        protected void onPreExecute(){
            //load.setVisibility(View.VISIBLE);
        }

        @Override
        protected FakeUser doInBackground(Void... params){
            Utils util = new Utils();

            return util.getInformacao("https://randomuser.me/api/0.7");
        }

        @Override
        protected void onPostExecute(FakeUser pessoa){
            String strNome = pessoa.getNome().substring(0, 1).toUpperCase()
                    + pessoa.getNome().substring(1);
            nome.setText(strNome);
            String strSobrenome = pessoa.getSobrenome().substring(0, 1).toUpperCase()
                    + pessoa.getSobrenome().substring(1);
            sobrenome.setText(strSobrenome);
            email.setText(pessoa.getEmail());
            endereco.setText(pessoa.getEndereço());
            String strCidade = pessoa.getCidade().substring(0,1).toUpperCase()
                    + pessoa.getCidade().substring(1);
            cidade.setText(strCidade);
            estado.setText(pessoa.getEstado());
            username.setText(pessoa.getUsername());
            senha.setText(pessoa.getSenha());
            nascimento.setText(pessoa.getNascimento());
            telefone.setText(pessoa.getTelefone());
            foto.setImageBitmap(pessoa.getFoto());
            //load.setVisibility(View.GONE);
        }
    }
}
