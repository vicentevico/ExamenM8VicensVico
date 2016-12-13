package com.example.alumnedam.examenm8vicensvico.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alumnedam.examenm8vicensvico.Contorller.Test;
import com.example.alumnedam.examenm8vicensvico.R;

public class PaginaPreguntes extends AppCompatActivity  implements View.OnClickListener{

    Test test;
    int nombrePreguntes;
    TextView LBLPregunta, LBLValorEncerts, LBLValorErrades, LBLValorResposta;
    int contador = 0, encerts = 0, errades = 0;
    EditText TBResposta;
    Button BTSeguent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_preguntes);

        BTSeguent = (Button) findViewById(R.id.BTSeguent);
        BTSeguent.setOnClickListener(this);
        Button BTComprobar = (Button) findViewById(R.id.BTComprobar);
        BTComprobar.setOnClickListener(this);

        Intent intent = getIntent();

        String nomAlumne = intent.getStringExtra("nomAlumne");
        String tema = intent.getStringExtra("tema");
        nombrePreguntes = Integer.valueOf(intent.getStringExtra("nombrePreguntes"));

        test = new Test(tema, nombrePreguntes);

        LBLPregunta = (TextView) findViewById(R.id.LBLPregunta);
        TBResposta = (EditText) findViewById(R.id.TBResposta);

        LBLValorEncerts = (TextView) findViewById(R.id.LBLValorEncerts);
        LBLValorErrades = (TextView) findViewById(R.id.LBLValorErrades);
        LBLValorResposta = (TextView) findViewById(R.id.LBLValorResposta);

        mostrarPregunta();
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.BTComprobar){
            comprobarResposta();
        }else if(v.getId() == R.id.BTSeguent){
            if(contador != test.getLlistaPreguntes().size()){
                contador++;
                mostrarPregunta();
            }else if(contador == test.getLlistaPreguntes().size()){
                BTSeguent.setText("Finalizar");
            }
        }


    }

    public void mostrarPregunta(){
        LBLPregunta.setText(test.getLlistaPreguntes().get(contador).getPregunta());
    }

    /**
     * Obtiene el valor del editText, en caso de ser = a la respuesta de test aumenta acerts y actualiza el
     */
    public void comprobarResposta(){
        if(Double.valueOf(TBResposta.getText().toString()).equals(test.getLlistaPreguntes().get(contador).getResposta())){
            encerts++;
            LBLValorEncerts.setText(String.valueOf(encerts));
        }else{
            errades++;
            LBLValorErrades.setText(String.valueOf(errades));
            LBLValorResposta.setText(String.valueOf(test.getLlistaPreguntes().get(contador).getResposta()));
        }

    }
}
