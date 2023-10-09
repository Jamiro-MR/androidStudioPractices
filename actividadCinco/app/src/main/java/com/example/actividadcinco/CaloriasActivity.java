package com.example.actividadcinco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class CaloriasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorias);
        TextView txtNombre, txtEdad, txtSexo, txtCalorias;
        Button btnCalculo, btnVolver;
        EditText etPeso, etEstatura;
        String nombre, edad, sexo;

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtEdad = (TextView) findViewById(R.id.txtEdad);
        txtSexo = (TextView) findViewById(R.id.txtSexo);
        txtCalorias = (TextView) findViewById(R.id.txtCalorias);
        etEstatura = (EditText) findViewById(R.id.etEstatura);
        etPeso = (EditText) findViewById(R.id.etPeso);
        btnCalculo = (Button) findViewById(R.id.btnCalculo);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        nombre = getIntent().getStringExtra("usuario");
        edad = getIntent().getStringExtra("edad");
        sexo = getIntent().getStringExtra("sexo");
        txtNombre.setText("Bienvenido(a) " + nombre);
        txtEdad.setText("Edad: " + edad);
        txtSexo.setText("Sexo: " + sexo);
        btnVolver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i;
                i = new Intent(CaloriasActivity.this, MainActivity.class);
                startActivity(i);
                etPeso.setText("");
                etEstatura.setText("");
            }
        });
        btnCalculo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Double estatura, peso, edadN, calorias = 0.0;
                String strEstatura, strPeso;
                strPeso = etPeso.getText().toString();
                strEstatura = etEstatura.getText().toString();
                if (strEstatura.isEmpty() || strPeso.isEmpty()) {
                   Toast.makeText(CaloriasActivity.this, "Por favor, ingresa tu peso y estatura", Toast.LENGTH_SHORT).show();
                }else{
                    estatura = Double.parseDouble(strEstatura);
                    peso = Double.parseDouble(strPeso);
                    edadN = Double.parseDouble(edad);
                    if(sexo.equals("Hombre")){
                        calorias = calculoCalorias(peso, estatura, edadN, 5.0);
                    }else if(sexo.equals("Mujer")){
                        calorias = calculoCalorias(peso, estatura, edadN, -161.0);
                    }
                    txtCalorias.setText(calorias + "");
                }
            }
        });
    }

    public Double calculoCalorias(Double peso, Double estatura, Double edadN, Double s){
        return (10 * peso) + (6.25 * estatura) - (5 * edadN) + s;
    }
}