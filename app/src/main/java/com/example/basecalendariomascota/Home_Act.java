package com.example.basecalendariomascota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

public class Home_Act extends AppCompatActivity {

    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        video=(VideoView) findViewById(R.id.videoView2);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.petcalendar;
        video.setVideoURI(Uri.parse(path));
        video.start();
        video.requestFocus();

        //MediaController media = new MediaController(this);
        //videoview.setMediaController(media); son los controles del video
    }

    public void calendario(View View)
    {
        Intent i = new Intent(this, calendar_act.class);
        startActivity(i);// inicia actividad
        Toast.makeText(Home_Act.this, "Ingresando a citas", Toast.LENGTH_LONG).show();

    }
    public void salud(View View)
    {
        Intent i = new Intent(this, Salud_act.class);
        startActivity(i);// inicia actividad
        Toast.makeText(Home_Act.this, "Salud de su mascota", Toast.LENGTH_LONG).show();

    }
    public void fichamascota(View View)
    {
        Intent i = new Intent(this, Fichamascota_act.class);
        startActivity(i);// inicia actividad
        Toast.makeText(Home_Act.this, "Datos de su mascota", Toast.LENGTH_LONG).show();

    }

    public void comedero(View View)
    {
        Intent i = new Intent(this, Iot_act.class);
        startActivity(i);// inicia actividad
        Toast.makeText(Home_Act.this, "Bienvenido a su comedero mascotas", Toast.LENGTH_LONG).show();

    }

}