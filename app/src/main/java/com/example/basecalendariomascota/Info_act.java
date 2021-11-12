package com.example.basecalendariomascota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import Pojos.Evaluacion;

public class Info_act extends AppCompatActivity {

    private Evaluacion ev = new Evaluacion();// instancia objetos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    public void evaluacion(View View)
    {
        Intent i = new Intent(this, Eva_Act.class);
        Bundle bun = new Bundle();
        bun.putStringArray("areas", ev.getAreas());
        i.putExtras(bun);
        startActivity(i);// inicia actividad
        Toast.makeText(Info_act.this, "Envianos tus comentarios", Toast.LENGTH_SHORT).show();

    }

    public void llamanos(View view) {
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:"+"911122233"));
        startActivity(i);

    }

    public void localizacion(View view) {
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);

    }


}