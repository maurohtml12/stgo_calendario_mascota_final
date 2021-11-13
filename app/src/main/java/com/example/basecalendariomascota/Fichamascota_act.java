package com.example.basecalendariomascota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.basecalendariomascota.database.AdminSQLiteOpenHelper;

public class Fichamascota_act extends AppCompatActivity {
    private EditText nombre, nchip, tipo, raza, edad, nacimiento, nombrebuscador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fichamascota);
        nombre = findViewById(R.id.nmas);
        nchip = findViewById(R.id.cmas);
        tipo = findViewById(R.id.tma);
        raza = findViewById(R.id.rmas);
        edad = findViewById(R.id.emas);
        nacimiento = findViewById(R.id.namas);

    }

    public void savemascota(View view) {
        //obtengo mi base de datos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "calendariomascota", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();//permisos de sobre escritura...
        //obtengo los datos de la interfaz
        String numero = nchip.getText().toString();
        String name = nombre.getText().toString();
        String type = tipo.getText().toString();
        String pedr = raza.getText().toString();
        String edadm = edad.getText().toString();
        String naci = nacimiento.getText().toString();

        if (!numero.isEmpty() && !name.isEmpty() && !type.isEmpty() && !pedr.isEmpty() && !edadm.isEmpty() && !naci.isEmpty()) {
            //creo el registro
            ContentValues conten = new ContentValues();//contiene valores
            conten.put("numero", numero);
            conten.put("nombre", name);
            conten.put("tipo", type);
            conten.put("raza", pedr);
            conten.put("edad", edadm);
            conten.put("nacim", naci);
            //insertar el registro
            bd.insert("mascotas", null, conten);
            bd.close();
            cleanMascota(view);
            Toast.makeText(this, "Registro guardado", Toast.LENGTH_SHORT).show();

        } else {
            //mensaje de error
            Toast.makeText(this, "No se puede guardar mascota sin datos", Toast.LENGTH_SHORT).show();

        }
    }



    public void cleanMascota (View view){
        nombre.setText("");
        nchip.setText("");
        tipo.setText("");
        raza.setText("");
        edad.setText("");
        nacimiento.setText("");
        nombrebuscador.setText("");
    }

}

