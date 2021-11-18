package com.example.basecalendariomascota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Iot_act extends AppCompatActivity {

    private TextView tempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iot);

        tempo = findViewById(R.id.txttime);
    }

    public void comida(View View)
    {
        Calendar cal = Calendar.getInstance();
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        int minutos = cal.get(Calendar.MINUTE);

        TimePickerDialog tpd = new TimePickerDialog(Iot_act.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {

                String hora =  hour + ":" + minute;
                tempo.setText("horario de comida Programado : " + hora+ "horas");
            }
        },hora, minutos, true);
        tpd.show();

    }
}