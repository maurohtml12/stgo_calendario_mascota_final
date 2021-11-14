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
    private EditText nombre, nchip, tipo, raza, edad, nacimiento, busqueda;

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
        busqueda = findViewById(R.id.busq);

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
            conten.put("numeros", numero);
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
    public void consultmascota(View view) {
        //obtengo mi base de datos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "calendariomascota", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();//permisos de sobre escritura...

        String name = busqueda.getText().toString();

        if (!name.isEmpty()) {
            Cursor file = bd.rawQuery("select * from mascotas where numeros="+name, null);
            if (file.moveToFirst()) {
                //nchip.setText(file.getString(1));
                nombre.setText(file.getString(1));
                tipo.setText(file.getString(2));
                raza.setText(file.getString(3));
                edad.setText(file.getString(4));
                nacimiento.setText(file.getString(5));

            } else {
                Toast.makeText(this, "No existe mascota con ese numero", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "No se puede consultar mascota sin datos", Toast.LENGTH_SHORT).show();
        }
    }





        public void cleanMascota (View view){
            nombre.setText("");
            nchip.setText("");
            tipo.setText("");
            raza.setText("");
            edad.setText("");
            nacimiento.setText("");

        }
}

