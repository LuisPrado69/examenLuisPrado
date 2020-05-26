package com.uisrael.luisprado_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button btnLogin;
    EditText userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toast.makeText(getApplicationContext(), "Usuario: LUISPRADO", Toast.LENGTH_SHORT).show();

        // Variable
        userName = findViewById(R.id.etUserName);
        password = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            // Click button
            @Override
            public void onClick(View v) {
                // Validate if set value all fields
                if (userName.getText().toString().length() != 0 && password.getText().toString().length() != 0) {
                    String val1 = userName.getText().toString();
                    String val2 = password.getText().toString();
                    if (val1.equals("estudiante2020") && val2.equals("uisrael2020")) {
                        Toast.makeText(getApplicationContext(), "Usuario y contraseña correcto, continue con la segunda activiad", Toast.LENGTH_SHORT).show();
                        Intent intentEnvio = new Intent(Login.this, Registro.class);
                        intentEnvio.putExtra("userName", val1);
                        startActivity(intentEnvio);
                    } else {
                        Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Campos obligatorios", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
