package com.example.basecalendariomascota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class Eva_Act extends AppCompatActivity {
    private Spinner selec;
    private RatingBar calificacion;
    private EditText comentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eva);

        selec = findViewById(R.id.spnopnes);
        calificacion = (RatingBar) findViewById(R.id.ratingBar2);
        comentario = findViewById(R.id.editTextTextMultiLine);

        Bundle bun = getIntent().getExtras();//recibo los extras
        String[] listado = bun.getStringArray("areas");//recibo arreglo por referencia

        ArrayAdapter adaptEvaluaciones = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        selec.setAdapter(adaptEvaluaciones);


    }

    public void enviar(View View)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Comentarios petcalendar");
        intent.putExtra(Intent.EXTRA_TEXT, "comentario :"+comentario.getText().toString()+"  estrellas :"+calificacion.getRating());
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"calendariomascotas@gmail.com"});
        startActivity(intent);
        Toast.makeText(Eva_Act.this, " Gracias por tu Feedback", Toast.LENGTH_SHORT).show();

    }
}