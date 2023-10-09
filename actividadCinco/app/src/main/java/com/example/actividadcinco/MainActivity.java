package com.example.actividadcinco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText usuario, edad;
    Button calorias, boston;
    RadioGroup sexos;
    String usu, age, sexo;
    Toast mensaje;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText) findViewById(R.id.nombre);
        edad = (EditText) findViewById(R.id.edad);
        sexos = (RadioGroup) findViewById(R.id.sexos);
        sexos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                if(checkedId == R.id.sexHombre){
                    sexo = "Hombre";
                }else if(checkedId == R.id.sexMujer){
                    sexo = "Mujer";
                }
            }
        });
        boston = (Button) findViewById(R.id.btnBoston);
        calorias = (Button) findViewById(R.id.btnCalorias);
        boston.setOnClickListener(this);
        calorias.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){   
        usu = usuario.getText().toString();
        age = edad.getText().toString();

        if (usu.isEmpty() || age.isEmpty()) {
            Toast.makeText(MainActivity.this, "Por favor, ingresa tu nombre y edad", Toast.LENGTH_SHORT).show();
        }else{
            if(view.getId() == R.id.btnCalorias){
                changeActivity(1);
            }else if(view.getId() == R.id.btnBoston){
                changeActivity(2);
            }            
        }

    }

    public void changeActivity(int opt){
        if(opt == 1){
            mensaje = Toast.makeText(MainActivity.this, "Calculadora de calorias", Toast.LENGTH_LONG);
            i = new Intent(MainActivity.this, CaloriasActivity.class);
        }else if(opt == 2){
            mensaje = Toast.makeText(MainActivity.this, "Maraton de Boston", Toast.LENGTH_LONG);
            i = new Intent(MainActivity.this, BostonActivity.class);
        }
        i.putExtra("usuario", usu);
        i.putExtra("edad", age);
        i.putExtra("sexo", sexo);
        startActivity(i);
        usuario.setText("");
        edad.setText("");
        mensaje.show();
    }
}