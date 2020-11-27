package com.example.proyectomapas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NuevasMaravillas extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,mapaMaravillasNuevas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevas_maravillas);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NuevasMaravillas.this, MapsNuevos.class);
                String latitud = "-22.951916";
                String longitud = "-43.2104872";
                intent.putExtra("Latitud",latitud);
                intent.putExtra("Longitud",longitud);
            }
        });

        mapaMaravillasNuevas = findViewById(R.id.btn_MaravillasNuevas);
        mapaMaravillasNuevas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NuevasMaravillas.this,MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
