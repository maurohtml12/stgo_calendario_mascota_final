package com.example.basecalendariomascota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.ParseException;

import Pojos.Insumos;

public class Insumos_act extends AppCompatActivity {

    Insumos insumos = new Insumos();
    private Spinner tipo;
    private RatingBar calidad;
    private EditText peso;
    private TextView resultado, resultado2;
    int pesoingresado;
    int gramosextras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);
        tipo = findViewById(R.id.spnmarca);
        calidad = findViewById(R.id.rbmarca);
        peso = findViewById(R.id.txtpeso);
        resultado = findViewById(R.id.txtresultado);
        resultado2 = findViewById(R.id.txttotaly);

        Bundle bun = getIntent().getExtras();//recibo los extras
        String[] listado = bun.getStringArray("marcas");//recibo arreglo por referencia

        ArrayAdapter adaptInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        tipo.setAdapter(adaptInsumos);
    }


   public void calcular(View view){

        String opcion = tipo.getSelectedItem().toString();//obtiene seleccionado
        int totalgr = 0;


       for(int i=0; i<tipo.getCount(); i++){

           if(opcion.equals(insumos.getMarcas()[i]))//segun el insumo seleccionado muestro el gramaje
           {
               //totalgr = insumos.getGramos()[i];// obtengo precios
               totalgr = insumos.anadiradicional(insumos.getGramos()[i], 2);//regla de negocio
               calidad.setRating(i+1);
               break;
           }


       }
       resultado.setText("El total en gramos de "+opcion +" cantidad por kilo "+totalgr+"gr.");
         pesoingresado= Integer.parseInt(peso.getText().toString());
       resultado2.setText("El total segun su peso "+totalgr* pesoingresado);
    }


}