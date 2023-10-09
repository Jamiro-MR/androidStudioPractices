package com.example.examen2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nombre;
    public RadioGroup materia;
    Button aplicar;
    String usu;
    Intent mate,esp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText) findViewById(R.id.name);
        aplicar = (Button) findViewById(R.id.aplicar);

        materia = findViewById(R.id.m);
        materia.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String mat = radioButton.getText().toString();
                aplicar.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        usu = nombre.getText().toString();
                        if(usu.equals("")){
                            Toast.makeText(MainActivity.this, "Asegurate de rellenar ambos campos",
                                    Toast.LENGTH_LONG).show();
                        }else {
                            if(mat.equals("Matematicas")){
                                mate = new Intent(MainActivity.this, FMate.class);
                                mate.putExtra("nombre",usu);
                                startActivity(mate);
                            } else if (mat.equals("Español")){
                                esp = new Intent(MainActivity.this, esp.class);
                                esp.putExtra("nombre",usu);
                                startActivity(esp);
                            }
                        }
                    }
                });
            }
        });
    }
}