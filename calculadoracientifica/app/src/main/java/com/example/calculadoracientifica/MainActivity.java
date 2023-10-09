package com.example.calculadoracientifica;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, tPunto, sumar, restar, multiplicar;
    Button dividir, borrar, borrarTodo, raiz, potencia, igual, seno, coseno, tangente;
    Button modulo, div, cuadrado, factorial, logaritmo, logaritmoN, notacion, reversa;
    Button reversaDiv, tPi, tAbs;
    EditText num;
    TextView res;
    Double opt1, opt2;
    int operador;
    String primero, segundo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = (EditText) findViewById(R.id.numero);
        res = (TextView) findViewById(R.id.operacion);
        t0 = (Button) findViewById(R.id.t0);
        t1 = (Button) findViewById(R.id.t1);
        t2 = (Button) findViewById(R.id.t2);
        t3 = (Button) findViewById(R.id.t3);
        t4 = (Button) findViewById(R.id.t4);
        t5 = (Button) findViewById(R.id.t5);
        t6 = (Button) findViewById(R.id.t6);
        t7 = (Button) findViewById(R.id.t7);
        t8 = (Button) findViewById(R.id.t8);
        t9 = (Button) findViewById(R.id.t9);
        tPi = (Button) findViewById(R.id.tPi);
        tPunto = (Button) findViewById(R.id.tPunto);
        sumar = (Button) findViewById(R.id.tSumar);
        restar = (Button) findViewById(R.id.tRestar);
        multiplicar = (Button) findViewById(R.id.tMulti);
        dividir = (Button) findViewById(R.id.tDividir);
        borrar = (Button) findViewById(R.id.tBorrar);
        borrarTodo = (Button) findViewById(R.id.tBorrarTodo);
        raiz = (Button) findViewById(R.id.tRaiz);
        potencia = (Button) findViewById(R.id.tPotencia);
        igual = (Button) findViewById(R.id.tIgual);
        seno = (Button) findViewById(R.id.tSeno);
        coseno = (Button) findViewById(R.id.tCoseno);
        tangente = (Button) findViewById(R.id.tTangente);
        modulo = (Button) findViewById(R.id.tModulo);
        div = (Button) findViewById(R.id.tDiv);
        cuadrado = (Button) findViewById(R.id.tCuadrado);
        factorial = (Button) findViewById(R.id.tFactorial);
        logaritmo = (Button) findViewById(R.id.tLogaritmo);
        logaritmoN = (Button) findViewById(R.id.tLogaritmoNatural);
        notacion = (Button) findViewById(R.id.tNotacion);
        reversaDiv = (Button) findViewById(R.id.tInvDiv);
        reversa = (Button) findViewById(R.id.tReverse);
        tAbs = (Button) findViewById(R.id.tAbs);
        t0.setOnClickListener(this);
        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        t3.setOnClickListener(this);
        t4.setOnClickListener(this);
        t5.setOnClickListener(this);
        t6.setOnClickListener(this);
        t7.setOnClickListener(this);
        t8.setOnClickListener(this);
        t9.setOnClickListener(this);
        tPi.setOnClickListener(this);
        tPunto.setOnClickListener(this);
        sumar.setOnClickListener(this);
        restar.setOnClickListener(this);
        multiplicar.setOnClickListener(this);
        dividir.setOnClickListener(this);
        raiz.setOnClickListener(this);
        potencia.setOnClickListener(this);
        borrar.setOnClickListener(this);
        borrarTodo.setOnClickListener(this);
        igual.setOnClickListener(this);
        seno.setOnClickListener(this);
        coseno.setOnClickListener(this);
        tangente.setOnClickListener(this);
        modulo.setOnClickListener(this);
        div.setOnClickListener(this);
        cuadrado.setOnClickListener(this);
        factorial.setOnClickListener(this);
        logaritmo.setOnClickListener(this);
        logaritmoN.setOnClickListener(this);
        notacion.setOnClickListener(this);
        reversaDiv.setOnClickListener(this);
        reversa.setOnClickListener(this);
        tAbs.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        primero = num.getText().toString();
        try{
            if(view.getId() == R.id.t0){
                num.setText(num.getText()+"0");
            }else if(view.getId() == R.id.t1){
                num.setText(num.getText()+"1");
            }else if(view.getId() == R.id.t2){
                num.setText(num.getText()+"2");
            }else if(view.getId() == R.id.t3){
                num.setText(num.getText()+"3");
            }else if(view.getId() == R.id.t4){
                num.setText(num.getText()+"4");
            }else if(view.getId() == R.id.t5){
                num.setText(num.getText()+"5");
            }else if(view.getId() == R.id.t6){
                num.setText(num.getText()+"6");
            }else if(view.getId() == R.id.t7){
                num.setText(num.getText()+"7");
            }else if(view.getId() == R.id.t8){
                num.setText(num.getText()+"8");
            }else if(view.getId() == R.id.t9){
                num.setText(num.getText()+"9");
            }else if(view.getId() == R.id.tPunto){
                num.setText(num.getText()+".");

                //Funcionan con 2 digitos
            }else if(view.getId() == R.id.tSumar){
                opt1 = Double.parseDouble(primero);
                res.setText(num.getText()+"+");
                num.setText("");
                operador = 0;
            }else if(view.getId() == R.id.tRestar){
                opt1 = Double.parseDouble(primero);
                res.setText(num.getText()+"-");
                num.setText("");
                operador = 1;
            }else if(view.getId() == R.id.tMulti){
                opt1 = Double.parseDouble(primero);
                res.setText(num.getText()+"*");
                num.setText("");
                operador = 2;
            }else if(view.getId() == R.id.tDividir){
                opt1 = Double.parseDouble(primero);
                res.setText(num.getText()+"/");
                num.setText("");
                operador = 3;
            }else if(view.getId() == R.id.tPotencia){
                opt1 = Double.parseDouble(primero);
                res.setText(num.getText()+"^");
                num.setText("");
                operador = 4;
            }else if(view.getId() == R.id.tModulo){
                opt1 = Double.parseDouble(primero);
                res.setText(num.getText() + "%");
                num.setText("");
                operador = 5;
            }else if(view.getId() == R.id.tDiv){
                opt1 = Double.parseDouble(primero);
                res.setText(num.getText() + "I/");
                num.setText("");
                operador = 6;
            }else if(view.getId() == R.id.tNotacion){
                opt1 = Double.parseDouble(primero);
                res.setText(num.getText() + "10^X");
                num.setText("");
                operador = 7;
            }else if(view.getId() == R.id.tLogaritmo){
                opt1 = Double.parseDouble(primero);
                res.setText(num.getText() + "lg");
                num.setText("");
                operador = 8;

                //Funcionan solos
            }else if(view.getId() == R.id.tSeno){
                opt1 = Double.parseDouble(primero);
                res.setText((Math.sin(Math.toRadians(opt1)) + ""));
                num.setText("");
            }else if(view.getId() == R.id.tCoseno){
                opt1 = Double.parseDouble(primero);
                res.setText((Math.cos(Math.toRadians(opt1)) + ""));
                num.setText("");
            }else if(view.getId() == R.id.tTangente){
                opt1 = Double.parseDouble(primero);
                res.setText((Math.tan(Math.toRadians(opt1)) + ""));
                num.setText("");
            }else if(view.getId() == R.id.tRaiz){
                opt1 = Double.parseDouble(primero);
                res.setText(Math.sqrt(opt1) + "");
                num.setText("");
            }else if(view.getId() == R.id.tCuadrado){
                opt1 = Double.parseDouble(primero);
                res.setText((Math.pow(opt1, 2)) + "");
                num.setText("");
            }else if(view.getId() == R.id.tFactorial){
                Double fact = 1.0;
                opt1 = Double.parseDouble(primero);
                Double aux = opt1;
                while(aux > 1){
                    fact *= aux;
                    aux--;
                }
                res.setText(opt1 + "! = " + fact + "");
                num.setText("");
            }else if(view.getId() == R.id.tLogaritmoNatural){
                opt1 = Double.parseDouble(primero);
                res.setText(Math.log(opt1) + "");
                num.setText("");
            }else if(view.getId() == R.id.tInvDiv){
                opt1 = Double.parseDouble(primero);
                res.setText(Math.pow(opt1, (-1)) + "");
                num.setText("");
            }else if(view.getId() == R.id.tReverse){
                opt1 = Double.parseDouble(primero);
                num.setText(opt1 * (-1) + "");
            }else if(view.getId() == R.id.tPi){
                num.setText(Math.PI + "");
            }else if(view.getId() == R.id.tAbs){
                opt1 = Double.parseDouble(primero);
                res.setText(Math.abs(opt1) + "");
                num.setText("");

                //Tecla de igual
            }else if(view.getId() == R.id.tIgual){
                if(operador == 0){
                    opt2 = Double.parseDouble(primero);
                    res.setText((opt1+opt2) + "");
                }else if(operador == 1){
                    opt2 = Double.parseDouble(primero);
                    res.setText((opt1-opt2) + "");
                }else if(operador == 2){
                    opt2 = Double.parseDouble(primero);
                    res.setText((opt1*opt2) + "");
                }else if(operador == 3){
                    opt2 = Double.parseDouble(primero);
                    res.setText((opt1/opt2) + "");
                }else if(operador == 4){
                    opt2 = Double.parseDouble(primero);
                    res.setText((Math.pow(opt1, opt2)) + "");
                }else if(operador == 5) {
                    opt2 = Double.parseDouble(primero);
                    res.setText((opt1 / opt2) % 1 + "");
                }else if(operador == 6) {
                    opt2 = Double.parseDouble(primero);
                    double dec = (opt1 / opt2) % 1;
                    res.setText((opt1 / opt2) - dec + "");
                }else if(operador == 7) {
                    opt2 = Double.parseDouble(primero);
                    res.setText(opt1 * Math.pow(10, opt2) + "");
                }else if(operador == 7) {
                    opt2 = Double.parseDouble(primero);
                    res.setText(opt1 * Math.pow(10, opt2) + "");
                }else if(operador == 8){
                    opt2 = Double.parseDouble(primero);
                    res.setText((opt1 % opt2) + "");
                }
                num.setText("");
            }else if(view.getId() == R.id.tBorrar){
                num.setText("");
            }else if(view.getId() == R.id.tBorrarTodo){
                num.setText("");
                res.setText("0");
            }
        }catch(Exception e){}
    }
}