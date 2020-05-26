package com.uisrael.luisprado_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resumen extends AppCompatActivity {

    Bundle datoRecibir;
    TextView tv1, tv2, tv3, tv5, tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        tv1 = findViewById(R.id.r1);
        tv2 = findViewById(R.id.r2);
        tv3 = findViewById(R.id.r3);
        tv5 = findViewById(R.id.r5);
        tv6 = findViewById(R.id.r6);

        datoRecibir = getIntent().getExtras();
        String rp1 = datoRecibir.getString("q1");
        String rp2 = datoRecibir.getString("q2");
        String rp3 = datoRecibir.getString("q3");
        String rp5 = datoRecibir.getString("name");
        String rp6 = datoRecibir.getString("starting_amount");
        tv1.setText(rp1);
        tv2.setText(rp2);
        tv3.setText(rp3);
        tv5.setText(rp5);
        tv6.setText(rp6);
    }
}
