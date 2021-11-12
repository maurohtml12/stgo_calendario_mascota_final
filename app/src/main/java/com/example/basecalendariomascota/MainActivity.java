package com.example.basecalendariomascota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import Pojos.Administrador;
import Pojos.Evaluacion;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private Administrador adm =  new Administrador();
    private ProgressBar barra;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.txtusu);
        pass = findViewById(R.id.txtpass);
        barra = findViewById(R.id.pb);
        btn = findViewById(R.id.btn);

        barra.setVisibility(View.INVISIBLE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Task().execute();

            }
        });
    }

    class Task extends AsyncTask<String, Void, String> {
        //define la configuracion inicial
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);
        }
        //correr proceso pesado en segundo plano
        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }
        //finaliza mi tarea asincrona
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            barra.setVisibility(View.INVISIBLE);

            String usuario = user.getText().toString().trim();
            String contrasenia = pass.getText().toString().trim();

            String uspjo = adm.getUser().trim();
            String passpjo = adm.getPass().trim();

            switch (usuario)
            {
                case "mauricio":
                    if(usuario.equals(uspjo) && contrasenia.equals(passpjo))
                    {
                        Intent i = new Intent(getBaseContext(), Home_Act.class);
                        startActivity(i);// inicia actividad
                        Toast.makeText(MainActivity.this, "Inicio de sesion exitoso", Toast.LENGTH_LONG).show();
                    }
                    break;
                case "":
                    if (usuario.isEmpty() && contrasenia.isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Por favor ingrese Usuario y Contraseña ", Toast.LENGTH_LONG).show();
                    }
                    break;
                default:
                    if (!usuario.equals(uspjo) || !contrasenia.equals(passpjo))
                    {
                        Toast.makeText(MainActivity.this, "Datos incorrectos, Intente nuevamente", Toast.LENGTH_LONG).show();
                    }
                    break;
            }

        }
    }


    public void sobrenosotros(View View)
    {
        Intent i = new Intent(this, Info_act.class);
        Bundle bun = new Bundle();
        //bun.putStringArray("areas", ev.getAreas());
        //i.putExtras(bun);
        startActivity(i);// inicia actividad
        Toast.makeText(MainActivity.this, "Sobre nosotros", Toast.LENGTH_SHORT).show();

    }

    public void youtube(View View)
    {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:sKj_5VAdPAs" ));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=sKj_5VAdPAs"));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }

    }
    public void twitter(View View)
    {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/petcalendar" ));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://twitter.com/petcalendar"));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }

    }
    public void facebook(View View)
    {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com/petcalendar" ));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://facebook.com/petcalendar"));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }

    }
}