package com.devmobile;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
// Variaveis para Sorteio de numero entre intervalo
    int min, max, res=0;
    protected boolean validaEntrada(String str1 , String str2){
        return !TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setTitle("Sorteio");
        setContentView(R.layout.activity_main);
    // Objetos da Atividade para manipulacao
        EditText inicio = findViewById(R.id.inicio);
        EditText fim = findViewById(R.id.fim);
        TextView txt = findViewById(R.id.resultado);
        Button bt = findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // Valida dados inseridos
               if (validaEntrada(inicio.getText().toString().trim(),
                        fim.getText().toString().trim())){
               // Busca os valores inseridos na tela
                   min = Integer.parseInt(inicio.getText().toString());
                   max = Integer.parseInt(fim.getText().toString());
               // Verifica se o intervalo esta correto
                   if (min > max){
                       txt.setText("Inicio do intervalo maior ao fim do intervalo");
                   }else{
                        Random r = new Random();
                        res = r.nextInt(max - min + 1) + min;
                        txt.setText("Numero sorteado: " + res);                   }
               }else{
                   txt.setText("Inserir um intervalo valido !");
               }
            }
        });
    }
}