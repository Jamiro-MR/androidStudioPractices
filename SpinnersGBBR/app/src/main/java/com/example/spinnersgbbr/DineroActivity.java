package com.example.spinnersgbbr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;

public class DineroActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    EditText valor;
    TextView resultado, moneda1, moneda2;
    Spinner dato1, dato2;
    String datoE, datoS, valorE;
    Double valorN, vPesos, vFinal;
    Button calcular;
    String[][] divisas;
    String[] codigos = {"Selecciona", "EUR","USD","JPY","BGN","CZK","DKK","GBP","HUF","PLN","RON","SEK","CHF",
            "ISK","NOK","RUB","TRY","AUD","BRL","CAD","CNY","HKD","IDR","ILS","INR","KRW","MXN","MYR",
            "NZD","PHP","SGD","THB","ZAR"};
    String[] monedas = {"0", "Euro", "Dolar americano", "Yen japones", "Leva búlgara", "Corona checa",
            "Corona danesa", "Libra esterlina", "Forinto húngaro", "Esloti", "Leu rumano", "Corona sueca",
            "Franco suizo", "Corona islandesa", "Corona noruega", "Rublo ruso", "Lira turca",
            "Dolar australiano", "Real brasileño", "Dolar canadiense", "Yuan chino", "Dolar de Hong Kong",
            "Rupia indonesia", "Nuevo séquel", "Rupia india", "Won sur coreano", "Peso mexicano",
            "Ringgit malayo", "Dolar neozelandés", "Peso filipino", "Dolar de Singapur", "Baht tailandés", "Rand sudafricano"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinero);

        valor = (EditText) findViewById(R.id.valor);
        moneda1 = (TextView) findViewById(R.id.moneda1);
        moneda2 = (TextView) findViewById(R.id.moneda2);
        resultado = (TextView) findViewById(R.id.resultado);
        calcular = (Button) findViewById(R.id.calcular);
        dato1 = (Spinner) findViewById(R.id.dato1);
        dato2 = (Spinner) findViewById(R.id.dato2);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(DineroActivity.this, android.R.layout.simple_dropdown_item_1line,codigos);
        dato1.setAdapter(aa);
        dato2.setAdapter(aa);
        dato1.setOnItemSelectedListener(this);
        dato2.setOnItemSelectedListener(this);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            URL url = new URL("https://www.floatrates.com/daily/mxn.json");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();
            divisas = new String[entries.size()][3];

            int i = 0;

            for (Map.Entry<String, JsonElement> entry : entries) {
                String code = entry.getKey();
                JsonObject currencyObject = entry.getValue().getAsJsonObject();
                double rate = currencyObject.get("rate").getAsDouble();
                double inverseRate = currencyObject.get("inverseRate").getAsDouble();

                divisas[i][0] = code;
                divisas[i][1] = String.valueOf(rate);
                divisas[i][2] = String.valueOf(inverseRate);

                i++;
            }

            connection.disconnect();
        }catch (Exception e) {
            Toast.makeText(DineroActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }

        calcular.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(i > 0){
            if(adapterView.getId()==R.id.dato1){
                datoE = codigos[i];
                moneda1.setText("Moneda de origen: " + monedas[i]);
            }
            if(adapterView.getId()==R.id.dato2){
                datoS = codigos[i];
                moneda2.setText("Moneda de salida: " + monedas[i]);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        valorE = valor.getText().toString();

        if(datoE.isEmpty() || datoS.isEmpty() || valorE.isEmpty()){
            Toast.makeText(DineroActivity.this, "Favor de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }else{
            valorN = Double.parseDouble(valorE);
            if(datoE.equals("MXN")){
                for(int i = 0; i < divisas.length; i++){
                    if(datoS.equals(divisas[i][0].toUpperCase())){
                        vFinal = valorN * Double.parseDouble(divisas[i][1]);
                    }
                }
            }else if(datoE.equals(datoS)){
                vFinal = valorN;
            }else{
                vPesos = valorN;
                for(int i = 0; i < divisas.length; i++){
                    if(datoE.equals(divisas[i][0].toUpperCase())){
                        vPesos *= Double.parseDouble(divisas[i][2]);
                    }
                }
                for(int i = 0; i < divisas.length; i++){
                    if(datoS.equals("MXN")){
                        vFinal = vPesos;
                    }else{
                        if(datoS.equals(divisas[i][0].toUpperCase())){
                            vFinal = vPesos * Double.parseDouble(divisas[i][1]);
                        }
                    }
                }
            }

            resultado.setText(valorE + " " + datoE + " = " + vFinal + " " + datoS);
        }
    }
}