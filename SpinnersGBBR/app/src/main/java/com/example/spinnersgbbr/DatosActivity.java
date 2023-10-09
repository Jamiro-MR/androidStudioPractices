package com.example.spinnersgbbr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DatosActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    EditText valor;
    TextView resultado;
    Spinner dato1, dato2;
    String datoE, datoS, valorE;
    Double valorN, vBits, vFinal;
    Button calcular;
    String[] datos = {"Selecciona", "bit","Byte", "Kibibyte", "Kilobyte", "Megabyte", "Mebibyte", "Gigabyte", "Gibibyte", "Terabyte", "Tebibyte", "Petabyte", "Pebibyte"};
    String[] valores = {"0", "1", "8", "8192", "8000", "8e6", "8.389e6", "8e9", "8.59e9", "8e12", "8.796e12", "8e15", "9.007e15"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        valor = (EditText) findViewById(R.id.valor);
        resultado = (TextView) findViewById(R.id.resultado);
        calcular = (Button) findViewById(R.id.calcular);
        dato1 = (Spinner) findViewById(R.id.dato1);
        dato2 = (Spinner) findViewById(R.id.dato2);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(DatosActivity.this, android.R.layout.simple_dropdown_item_1line,datos);
        dato1.setAdapter(aa);
        dato2.setAdapter(aa);
        dato1.setOnItemSelectedListener(this);
        dato2.setOnItemSelectedListener(this);

        calcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        valorE = valor.getText().toString();

        if(datoE.isEmpty() || datoS.isEmpty() || valorE.isEmpty()){
            Toast.makeText(DatosActivity.this, "Favor de rellenar todos los campos", Toast.LENGTH_SHORT).show();
        }else{
            valorN = Double.parseDouble(valorE);
            if(datoE.equals("bit")){
                for(int i = 0; i < datos.length; i++){
                    if(datoS.equals(datos[i])){
                        vFinal = valorN / Double.parseDouble(valores[i]);
                    }
                }
            }else{
                vBits = valorN;
                for(int i = 0; i < datos.length; i++){
                    if(datoE.equals(datos[i])){
                        vBits *= Double.parseDouble(valores[i]);
                    }
                }
                for(int i = 0; i < datos.length; i++){
                    if(datoS.equals(datos[i])){
                        vFinal = vBits / Double.parseDouble(valores[i]);
                    }
                }
            }

            resultado.setText(vFinal + " " + datoS);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(i > 0){
            if(adapterView.getId()==R.id.dato1){
                datoE = datos[i];
            }
            if(adapterView.getId()==R.id.dato2){
                datoS = datos[i];
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}