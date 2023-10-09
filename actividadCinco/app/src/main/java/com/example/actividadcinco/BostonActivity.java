package com.example.actividadcinco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class BostonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boston);
        TextView txtNombre, txtEdad, txtSexo, txtTiempo;
        Button btnTiempo, btnVolver;
        String nombre, edad, sexo;
        nombre = getIntent().getStringExtra("usuario");
        edad = getIntent().getStringExtra("edad");
        sexo = getIntent().getStringExtra("sexo");
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtEdad = (TextView) findViewById(R.id.txtEdad);
        txtSexo = (TextView) findViewById(R.id.txtSexo);
        txtTiempo = (TextView) findViewById(R.id.txtTiempo);
        btnTiempo = (Button) findViewById(R.id.btnTiempo);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        txtNombre.setText("Bienvenido(a) " + nombre);
        txtEdad.setText("Edad: " + edad);
        txtSexo.setText("Sexo: " + sexo);
        
        //Toast.makeText(BostonActivity.this, nombre + edad + sexo + "", Toast.LENGTH_SHORT).show();

        btnVolver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i;
                i = new Intent(BostonActivity.this, MainActivity.class);
                startActivity(i);
                txtTiempo.setText("");
            }
        });
        btnTiempo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int edadN;
                String time = "";
                edadN = Integer.parseInt(edad);
                if(sexo.equals("Hombre")){
                    if(edadN >= 18 && edadN <= 34){
                        time = "3:00hrs";
                    }else if(edadN >= 35 && edadN <= 39){
                        time = "3:05hrs";
                    }else if(edadN >= 40 && edadN <= 44){
                        time = "3:10hrs";
                    }else if(edadN >= 45 && edadN <= 49){
                        time = "3:20hrs";
                    }else if(edadN >= 50 && edadN <= 54){
                        time = "3:25hrs";
                    }else if(edadN >= 55 && edadN <= 59){
                        time = "3:35hrs";
                    }else if(edadN >= 60 && edadN <= 64){
                        time = "3:50hrs";
                    }else if(edadN >= 65 && edadN <= 69){
                        time = "4:05hrs";
                    }else if(edadN >= 70 && edadN <= 74){
                        time = "4:20hrs";
                    }else if(edadN >= 75 && edadN <= 79){
                        time = "4:35hrs";
                    }else if(edadN >= 80){
                        time = "4:50hrs";
                    }else{
                        Toast.makeText(BostonActivity.this, "Edad no permitida para clasificar al Maratón", Toast.LENGTH_SHORT).show();
                    }
                }else if(sexo.equals("Mujer")){
                    if(edadN >= 18 && edadN <= 34){
                        time = "3:30hrs";
                    }else if(edadN >= 35 && edadN <= 39){
                        time = "3:35hrs";
                    }else if(edadN >= 40 && edadN <= 44){
                        time = "3:40hrs";
                    }else if(edadN >= 45 && edadN <= 49){
                        time = "3:50hrs";
                    }else if(edadN >= 50 && edadN <= 54){
                        time = "3:55hrs";
                    }else if(edadN >= 55 && edadN <= 59){
                        time = "4:05hrs";
                    }else if(edadN >= 60 && edadN <= 64){
                        time = "4:20hrs";
                    }else if(edadN >= 65 && edadN <= 69){
                        time = "4:35hrs";
                    }else if(edadN >= 70 && edadN <= 74){
                        time = "4:50hrs";
                    }else if(edadN >= 75 && edadN <= 79){
                        time = "5:05hrs";
                    }else if(edadN >= 80){
                        time = "5:20hrs";
                    }else{
                        Toast.makeText(BostonActivity.this, "Edad no permitida para clasificar al Maratón", Toast.LENGTH_SHORT).show();
                    }
                }

                txtTiempo.setText("Tiempo requerido: " + time);
            }
        });
    }
}