package com.example.examen2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.examen2.R;

public class esp extends AppCompatActivity {
    String name, materia = "Español",calificacion;
    Button calificar;
    public RadioGroup p1,p2,p3,p4;
    double calf, a1,a2,a3,a4;

    Intent f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esp);
        name = getIntent().getStringExtra("nombre");
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        p4 = findViewById(R.id.p4);
        calificar = findViewById(R.id.cali);
        p1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String p1 = radioButton.getText().toString();
                p2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton radioButton = findViewById(checkedId);
                        String p2 = radioButton.getText().toString();
                        p3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {
                                RadioButton radioButton = findViewById(checkedId);
                                String p3 = radioButton.getText().toString();
                                p4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                    @Override
                                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                                        RadioButton radioButton = findViewById(checkedId);
                                        String p4 = radioButton.getText().toString();
                                        calificar.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View view){
                                                //   a, b, c, a
                                                if(p1.equals("Comer")){
                                                    a1=2.5;
                                                } else{
                                                    a1=0.0;
                                                }
                                                if(p2.equals("Él")){
                                                    a2=2.5;
                                                } else{
                                                    a2=0.0;
                                                }
                                                if(p3.equals("Enfadado")){
                                                    a3=2.5;
                                                } else{
                                                    a3=0.0;
                                                }
                                                if(p4.equals("Ella lee un libro")){
                                                    a4=2.5;
                                                } else{
                                                    a4=0.0;
                                                }
                                                calf = (a1+ a2+ a3 + a4);
                                                calificacion = Double.toString(calf);
                                                f = new Intent(esp.this, calificacion.class);
                                                f.putExtra("nombre",name);
                                                f.putExtra("calf", calificacion);
                                                f.putExtra("materia", materia);

                                                startActivity(f);
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
    }
}