package com.example.spinnersgbbr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button botonDatos, botonDinero;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonDatos = (Button) findViewById(R.id.botonDatos);
        botonDinero = (Button) findViewById(R.id.botonDinero);
        botonDatos.setOnClickListener(this);
        botonDinero.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.botonDatos){
            i = new Intent(MainActivity.this, DatosActivity.class);
        }else if(view.getId() == R.id.botonDinero){
            i = new Intent(MainActivity.this, DineroActivity.class);
        }
        startActivity(i);
    }
}