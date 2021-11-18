package com.example.basecalendariomascota;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;

public class calendar_act extends AppCompatActivity {

    private TextView citas, horas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


        citas = findViewById(R.id.textView9);
        horas = findViewById(R.id.textView17);
    }

    public void agregacita(View View)
    {
        Calendar cal = Calendar.getInstance();
        int anio = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        int minutos = cal.get(Calendar.MINUTE);

        TimePickerDialog tpd = new TimePickerDialog(calendar_act.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {

                String hora =  hour + ":" + minute;
                horas.setText("horario" + hora);
            }
        },hora, minutos, true);
        tpd.show();

        DatePickerDialog dpd = new DatePickerDialog(calendar_act.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                String fecha =  day + "/" + month + "/" + year;
                citas.setText("Mauricio Tienes una Cita Medica con tu mascota : " + fecha);
            }
        },anio, mes, dia);
        dpd.show();


    }


}