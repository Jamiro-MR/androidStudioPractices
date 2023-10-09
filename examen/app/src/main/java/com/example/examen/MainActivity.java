package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Calendar;
public class MainActivity extends AppCompatActivity {
    EditText nombre, dia, mes, year;
    Button next;
    String fn, name, edad, d, m, y, month;
    Intent ev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText) findViewById(R.id.nombre);
        dia = (EditText) findViewById(R.id.dia);
        mes = (EditText) findViewById(R.id.mes);
        year = (EditText) findViewById(R.id.year);
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                name = nombre.getText().toString();
                d= dia.getText().toString();
                m= mes.getText().toString();
                y= year.getText().toString();
                if (d.equals(".") || m.equals(".") || y.equals(".") || name.equals("") || d.equals("") || m.equals("") || y.equals("")){
                    Toast.makeText(MainActivity.this, "Asegurate de rellenar correctamente todos los campos",
                            Toast.LENGTH_LONG).show();
                }else {
                    if(m.equals("1") || m.equals("01")){
                        month = "Enero";
                    }else if(m.equals("2") || m.equals("01")){
                        month = "Febrero";
                    }else if(m.equals("3") || m.equals("03")){
                        month = "Marzo";
                    }else if(m.equals("4") || m.equals("04")){
                        month = "Abril";
                    }else if(m.equals("5") || m.equals("05")){
                        month = "Mayo";
                    }else if(m.equals("6") || m.equals("06")){
                        month = "Junio";
                    }else if(m.equals("7") || m.equals("07")){
                        month = "Julio";
                    }else if(m.equals("8") || m.equals("08")){
                        month = "Agosto";
                    }else if(m.equals("9") || m.equals("09")){
                        month = "Septiembre";
                    }else if(m.equals("10")){
                        month = "Octubre";
                    }else if(m.equals("11")){
                        month = "Noviembre";
                    }else if(m.equals("12")){
                        month = "Diciembre";
                    }else{

                    }
                    fn = (d + " de " + month + " de " + y);

                    int day = Integer.parseInt(d);
                    int month = Integer.parseInt(m);
                    int year = Integer.parseInt(y);

                    Calendar birthDate = Calendar.getInstance();
                    birthDate.set(year, month - 1, day); // Enero inicia en 0

                    Calendar currentDate = Calendar.getInstance();

                    int age = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

                    if (currentDate.get(Calendar.MONTH) < birthDate.get(Calendar.MONTH)
                            || (currentDate.get(Calendar.MONTH) == birthDate.get(Calendar.MONTH)
                            && currentDate.get(Calendar.DAY_OF_MONTH) < birthDate.get(Calendar.DAY_OF_MONTH))) {
                        age--;
                    }
                    edad = Integer.toString(age);

                    ev = new Intent(MainActivity.this, etapa.class);
                    ev.putExtra("nombre", name);
                    ev.putExtra("edad", edad);
                    ev.putExtra("fechaN", fn);
                    startActivity(ev);

                    next.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            ev = new Intent(MainActivity.this, etapa.class);
                            startActivity(ev);
                        }
                    });
                }
            }
        });
    }
}