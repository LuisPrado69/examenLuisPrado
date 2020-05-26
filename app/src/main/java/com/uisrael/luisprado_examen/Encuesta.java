package com.uisrael.luisprado_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Encuesta extends AppCompatActivity {

    Bundle datoRecibir;
    TextView userName;

    EditText et1;
    CheckBox cb1, cb2, cb3;
    RadioButton rB1, rB2;
    Button btnSendResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        userName = findViewById(R.id.userName);
        et1 = findViewById(R.id.et4);
        rB1 = findViewById(R.id.rB1);
        rB2 = findViewById(R.id.rB2);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        btnSendResume = findViewById(R.id.btnSendResume);

        datoRecibir = getIntent().getExtras();
        String name = datoRecibir.getString("name");
        userName.setText(name);

        btnSendResume.setOnClickListener(new View.OnClickListener() {
            // Click button
            @Override
            public void onClick(View v) {
                if (et1.getText().toString().length() != 0) {
                    Intent intentEnvio1 = new Intent(Encuesta.this, Resumen.class);
                    String message1 = "";
                    if (rB1.isChecked()) {
                        message1 += "Selecciono SI a su interes en otra lengua ";
                    } else if (rB2.isChecked()) {
                        message1 += "Selecciono NO a su interes en otra lengua ";
                    }
                    String message2 = "";
                    if (cb1.isChecked() || cb2.isChecked() || cb3.isChecked()) {
                        message2 += "Selecciono los siguientes deportes: ";
                    }
                    if (cb1.isChecked()) {
                        message2 += "Fútbol";
                    }
                    if (cb2.isChecked()) {
                        message2 += " Basket";
                    }
                    if (cb2.isChecked()) {
                        message2 += " Volley";
                    }
                    String q1 = et1.getText().toString();
                    datoRecibir = getIntent().getExtras();
                    String name = datoRecibir.getString("name");
                    String starting_amount = datoRecibir.getString("starting_amount");
                    Intent intentEnvio = new Intent(Encuesta.this, Resumen.class);
                    intentEnvio.putExtra("q1", q1);
                    intentEnvio.putExtra("q2", message1);
                    intentEnvio.putExtra("q3", message2);
                    intentEnvio.putExtra("name", name);
                    intentEnvio.putExtra("starting_amount", starting_amount);
                    startActivity(intentEnvio);
                    Toast.makeText(getApplicationContext(), "Envío de datos exitoso", Toast.LENGTH_SHORT).show();
                    startActivity(intentEnvio1);
                } else {
                    Toast.makeText(getApplicationContext(), "Campos obligatorios", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
