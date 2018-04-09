package com.example.alunos.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

        //Elementos do layout
        private Button btnScan;
        private TextView lblNome, lblEndereco;
        //QRCode scanner
        private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View objects
        btnScan = findViewById(R.id.btnScan);
        lblNome = findViewById(R.id.lblNome);
        lblEndereco = findViewById(R.id.lblEndereco);

        //intiallizing scan object
        qrScan = new IntentIntegrator(this);

        //attaching onclick listener
        btnScan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        qrScan.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Aqui, declaramos um objeto IntentResult, que vai receber os dados resultantes
        //da codificacao do QRCode
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            //Caso o resultado esteja vazio, devemos alertar o usuario
            //usando uma notificacao (objeto Toast)
            if(result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            }else{
                //Em caso positivo, vamos tratar o resultado
                try{
                    //Aqui, a string lida no QRCode e convertida em um objeto JSON
                    JSONObject obj = new JSONObject(result.getContents());
                    //Agora, colocaremos o resultado nos TextViews que colocamos
                    //na interface
                    lblNome.setText(obj.getString("name"));
                    lblEndereco.setText(obj.getString("address"));
                }catch (JSONException e){
                    e.printStackTrace();
                    //Se o controle entrar nesse ponto, significa um erro,
                    //no qual um QRCode diferente do esperado foi lido,
                    //Neste caso, mostraremos ao usuario qualquer que tenha sido
                    //este resultado em uma notificacao.
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        } else{
            //Caso o controle atinja esse ponto, significa que a decodificacao nao
            //conseguiu capturar um objeto. Entao, nos o repetimos
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
