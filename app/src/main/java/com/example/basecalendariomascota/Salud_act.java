package com.example.basecalendariomascota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import Pojos.Evaluacion;
import Pojos.Insumos;

public class Salud_act extends AppCompatActivity {
    private Insumos in = new Insumos();// instancia objetos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salud);
    }

    public void vacunas(View View)
    {
        Intent i = new Intent(this, Vacunas_act.class);
        startActivity(i);// inicia actividad
        Toast.makeText(Salud_act.this, "Ingrese su vacuna", Toast.LENGTH_LONG).show();

    }
    public void antiparasitarios(View View)
    {
        Intent i = new Intent(this, Insumos_act.class);
        Bundle bun = new Bundle();
        bun.putStringArray("marcas", in.getMarcas());
        i.putExtras(bun);
        startActivity(i);// inicia actividad
        Toast.makeText(Salud_act.this, "Antiparasitarios", Toast.LENGTH_LONG).show();

    }
}