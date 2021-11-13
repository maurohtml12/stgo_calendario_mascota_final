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

public class Vacunas_act extends AppCompatActivity {
    private EditText numero, vaccin, inoc, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacunas);
        numero = findViewById(R.id.number);
        vaccin = findViewById(R.id.vaccine);
        inoc = findViewById(R.id.dateinoc);
        next = findViewById(R.id.datenext);
    }

    // metodos para guardar vacunas

    public void saveVacuna(View view){
        //obtengo mi base de datos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "calendariomascota", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();//permisos de sobre escritura...
        //obtengo los datos de la interfaz
        String num = numero.getText().toString();
        String vac = vaccin.getText().toString();
        String ino = inoc.getText().toString();
        String nex = next.getText().toString();

        if (num.isEmpty() || vac.isEmpty() || !ino.isEmpty() || nex.isEmpty()){
            //creo el registro
            ContentValues conten = new ContentValues();//contiene valores
            conten.put("numero", num);
            conten.put("vacuna", vac);
            conten.put("inoculacion", ino);
            conten.put("proxima", nex);
            //insertar el registro
            bd.insert("vacunas", null, conten);
            bd.close();
            cleanVacuna(view);
            Toast.makeText(this, "Registro guardado", Toast.LENGTH_SHORT).show();

        }else{
            //mensaje de error
            Toast.makeText(this, "No se puede guardar vacuna sin datos", Toast.LENGTH_SHORT).show();

        }
    }



    // metodos para consultar vacunas

    public void consultVacuna(View view){
        //obtengo mi base de datos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "calendariomascota", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();//permisos de sobre escritura...

        String codigo = numero.getText().toString();

        if(!codigo.isEmpty()){
            Cursor file = bd.rawQuery("select * from vacunas where numero="+codigo, null);
            if(file.moveToFirst()){
                vaccin.setText(file.getString(1));
                inoc.setText(file.getString(2));
                next.setText(file.getString(3));

            }else{
                Toast.makeText(this, "No existe vacuna con ese numero", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "No se puede consultar vacuna sin datos", Toast.LENGTH_SHORT).show();
        }

    }
    //metodo para eliminar vacunas

    public void deleteVacuna(View view){
        //obtengo mi base de datos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "calendariomascota", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();//permisos de sobre escritura...

        String codigo = numero.getText().toString();

        if(!codigo.isEmpty()){
            int cant = bd.delete("vacunas", "numero="+codigo, null);
            if(cant == 1){
                bd.close();
                cleanVacuna(view);
                Toast.makeText(this, "Registro eliminado", Toast.LENGTH_SHORT).show();

            }
        }else{
            Toast.makeText(this, "No se puede eliminar vacuna sin datos", Toast.LENGTH_SHORT).show();
        }

    }
    //metodo para actualizar vacunas

    public void updateVacuna(View view){
        //obtengo mi base de datos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "calendariomascota", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();//permisos de sobre escritura...
        //obtengo los datos de la interfaz
        String num = numero.getText().toString();
        String vac = vaccin.getText().toString();
        String ino = inoc.getText().toString();
        String nex = next.getText().toString();

        if (num.isEmpty() || vac.isEmpty() || !ino.isEmpty() || nex.isEmpty()){
            //creo el registro
            ContentValues conten = new ContentValues();//contiene valores
            conten.put("numero", num);
            conten.put("vacuna", vac);
            conten.put("inoculacion", ino);
            conten.put("proxima", nex);
            //insertar el registro
            bd.update("vacunas", conten, "numero="+num, null);
            bd.close();
            cleanVacuna(view);
            Toast.makeText(this, "Registro actualizado", Toast.LENGTH_SHORT).show();

        }else{
            //mensaje de error
            Toast.makeText(this, "No se puede guardar vacuna sin datos", Toast.LENGTH_SHORT).show();

        }


    }
    //metodo para limpiar campos

    public void cleanVacuna(View view){
        numero.setText("");
        vaccin.setText("");
        inoc.setText("");
        next.setText("");
    }
}