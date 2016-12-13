package com.example.alumnedam.examenm8vicensvico.Model;

/**
 * Created by ALUMNEDAM on 13/12/2016.
 */

public class Pregunta {
    String pregunta="";
    double resposta=0;

    public Pregunta(String pregunta, double resposta){
        this.pregunta = pregunta;
        this.resposta = resposta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public double getResposta() {
        return resposta;
    }
}
