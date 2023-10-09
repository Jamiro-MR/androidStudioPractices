package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class etapa extends AppCompatActivity {
    TextView nombre, date, et, edad;
    String uName, bDate, ed;
    Intent r;
    Button regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityetapa);
        edad = (TextView) findViewById(R.id.ed);
        nombre = (TextView) findViewById(R.id.n);
        et = (TextView) findViewById(R.id.et);
        date = (TextView) findViewById(R.id.fn);
        uName = getIntent().getStringExtra("nombre");
        bDate = getIntent().getStringExtra("bDate");
        ed = getIntent().getStringExtra("edad");
        regresar = (Button) findViewById(R.id.regresar) ;

        nombre.setText("Nombre: " + uName);
        edad.setText(ed + "");
        et.setText("edad: " + ed);
        date.setText(bDate + "");
        int e = Integer.parseInt(ed);

        if(e>=0 && e<=2){
            et.setText("Maternal");
        }else if(e>=3 && e<=5){
            et.setText("Kinder");
        }else if(e>=6 && e<=12){
            et.setText("Primaria");
        }else if(e>=13 && e<=15){
            et.setText("Secundaria");
        }else if(e>=16 && e<=18){
            et.setText("Prepa");
        }else if(e>=19 && e<=24){
            et.setText("Universidad");
        }else if(e>=25 && e<=65){
            et.setText("Trabajo");
        }else if(e>=65){
            et.setText("Jubilado");
        }
        regresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                r = new Intent(etapa.this, MainActivity.class);
                startActivity(r);
            }
        });
    }
}