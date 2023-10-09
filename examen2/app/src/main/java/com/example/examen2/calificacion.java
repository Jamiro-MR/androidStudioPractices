package com.example.examen2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.examen2.MainActivity;
import com.example.examen2.R;

public class calificacion extends AppCompatActivity {
    TextView nombre, materia, calificacion, estado;
    Button regresar;
    String name, mate, calf, est;
    Intent i;
    double c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificacion);
        nombre = (TextView) findViewById(R.id.nombre);
        materia = (TextView) findViewById(R.id.resu);
        calificacion = (TextView) findViewById(R.id.tr);
        estado = (TextView) findViewById(R.id.estado);
        regresar = (Button) findViewById(R.id.re);
        name = getIntent().getStringExtra("nombre");
        mate = getIntent().getStringExtra("materia");
        calf = getIntent().getStringExtra("calf");
        nombre.setText(name);
        materia.setText(mate);
        calificacion.setText(calf);
        double c = Double.parseDouble(calf);
        if (c<=6){
            estado.setText("Reprobado");
        }else{
            estado.setText("Aprobado");
        }
        regresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                i = new Intent(calificacion.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    }
