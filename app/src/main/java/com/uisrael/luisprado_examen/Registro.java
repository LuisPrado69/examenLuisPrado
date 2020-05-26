package com.uisrael.luisprado_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {


    EditText et1, et2, et3;
    Button btncalculate, btnsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et1 = findViewById(R.id.eT1);
        et2 = findViewById(R.id.eT2);
        et3 = findViewById(R.id.eT3);
        btncalculate = findViewById(R.id.btnCalculate);
        btnsend = findViewById(R.id.btnSend);
        // Click button
        btncalculate.setOnClickListener(new View.OnClickListener() {
            // Click button
            @Override
            public void onClick(View v) {
                if (et1.getText().toString().length() != 0 && et2.getText().toString().length() != 0) {

                    String q2 = et2.getText().toString();
                    double value = Integer.parseInt(q2);
                    double res = ((1800 - value) / 3) + ((1800 - value) * 0.05);
                    String requestData = Double.toString(res);
                    et3.setText(requestData);
                    Toast.makeText(getApplicationContext(), "Su monto a pagar por tres meses es: " + requestData, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Campos obligatorios", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Click button
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et1.getText().toString().length() != 0 && et2.getText().toString().length() != 0 && et3.getText().toString().length() != 0) {
                    String val1 = et1.getText().toString();
                    String val3 = et3.getText().toString();
                    Intent intentEnvio = new Intent(Registro.this, Encuesta.class);
                    intentEnvio.putExtra("name", val1);
                    intentEnvio.putExtra("starting_amount", val3);
                    Toast.makeText(getApplicationContext(), "Elemento guardado con éxito", Toast.LENGTH_SHORT).show();
                    startActivity(intentEnvio);
                } else {
                    Toast.makeText(getApplicationContext(), "Campos obligatorios", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
