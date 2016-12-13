package com.example.alumnedam.examenm8vicensvico.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.alumnedam.examenm8vicensvico.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText TBNom, TBNombrePreguntes;
    Spinner CBTema;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button BTContinuar = (Button) findViewById(R.id.BTContinuar);
        BTContinuar.setOnClickListener(this);

        TBNom = (EditText) findViewById(R.id.TBNom);
        CBTema = (Spinner) findViewById(R.id.CBTema);
        String [] temas = {"Sumes","Restes","Multiplicacions","Divisions","Generals"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, temas);
        CBTema.setAdapter(adapter);
        TBNombrePreguntes = (EditText) findViewById(R.id.TBNombrePreguntes);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.BTContinuar){
            final Intent intent = new Intent(this, PaginaPreguntes.class);

            String nom = TBNom.getText().toString();
            String valorTema = CBTema.getSelectedItem().toString();
            String nombrePreguntes = TBNombrePreguntes.getText().toString();

            intent.putExtra("nomAlumne", nom);
            intent.putExtra("tema", valorTema);
            intent.putExtra("nombrePreguntes", nombrePreguntes);

            startActivity(intent);
        }

    }
}
