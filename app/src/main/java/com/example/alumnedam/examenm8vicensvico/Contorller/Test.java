package com.example.alumnedam.examenm8vicensvico.Contorller;

import com.example.alumnedam.examenm8vicensvico.Model.Pregunta;

import java.util.ArrayList;

/**
 * Created by ALUMNEDAM on 13/12/2016.
 */

public class Test {
    ArrayList<Pregunta> llistaPreguntes = new ArrayList<Pregunta>();
    int numeroPreguntes;
    String tema;

    public Test(String tema, int numeroPreguntes){
        this.tema = tema;
        this.numeroPreguntes = numeroPreguntes;
        omplirPreguntes(tema, numeroPreguntes);
    }

    public void omplirPreguntes(String tema, int numeroPreguntes){
        for(int i = 0; i < numeroPreguntes; i++){
            if(tema.equals("Sumes")){
                llistaPreguntes.add(new Pregunta("Pregunta numero" + i + ", Quant fan " + i + "+" + i +" ?", i+i));
            }else if(tema.equals("Restes")){
                llistaPreguntes.add(new Pregunta("Pregunta numero" + i + ", Quant fan " + i + "-" + i +" ?", i-i));
            }else if(tema.equals("Multiplicacions")){
                llistaPreguntes.add(new Pregunta("Pregunta numero" + i + ", Quant fan " + i + "x" + i +" ?", i*i));
            }else{
                llistaPreguntes.add(new Pregunta("Pregunta numero" + i + ", Quant fan " + i + "/" + i +" ?", i/i));
            }

        }
    }

    public ArrayList<Pregunta> getLlistaPreguntes() {
        return llistaPreguntes;
    }
}
