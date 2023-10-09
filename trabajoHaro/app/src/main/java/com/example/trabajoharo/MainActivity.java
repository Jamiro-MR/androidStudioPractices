package com.example.trabajoharo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button sumar, restar, sumarDiez, restarDiez, reiniciar, reverse;

    TextView texto;
    int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Encontrar ID de los botones
        sumar = (Button) findViewById(R.id.btnSumar);
        restar = (Button) findViewById(R.id.btnRestar);
        sumarDiez = (Button) findViewById(R.id.btnSumarDiez);
        restarDiez = (Button) findViewById(R.id.btnRestarDiez);
        reiniciar = (Button) findViewById(R.id.btnReiniciar);
        reverse = (Button) findViewById(R.id.btnReverse);
        //Texto
        texto = (TextView) findViewById(R.id.txt);
        //Inicio de OnClick
        sumar.setOnClickListener(this);
        restar.setOnClickListener(this);
        sumarDiez.setOnClickListener(this);
        restarDiez.setOnClickListener(this);
        reiniciar.setOnClickListener(this);
        reverse.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){

        int id = view.getId();
        if(id == R.id.btnSumar){
            num++;
            texto.setText(num + "");
        }else if(id == R.id.btnRestar){
            num--;
            texto.setText(num + "");
        }else if(id == R.id.btnSumarDiez){
            num+=10;
            texto.setText(num + "");
        }else if(id == R.id.btnRestarDiez){
            num-=10;
            texto.setText(num + "");
        }else if(id == R.id.btnReiniciar){
            num=0;
            texto.setText(num + "");
        }else if(id == R.id.btnReverse){
            num*=(-1);
            texto.setText(num + "");
        }
    }
}