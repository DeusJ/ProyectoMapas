package com.example.proyectomapas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button MaravillasNuevas, MaravillasAntiguas, mapaDirecciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaravillasNuevas = findViewById(R.id.btn_mapaMaravillaNuevas);
        MaravillasNuevas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NuevasMaravillas.class);
                startActivity(intent);
            }
        });
        MaravillasAntiguas = findViewById(R.id.btn_mapaMaravillaAntiguas);
        MaravillasAntiguas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AntiguasMaravillas.class);
                startActivity(intent);
            }
        });
        mapaDirecciones = findViewById(R.id.btn_mapaDireccion);
        mapaDirecciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MapsDirection.class);
                startActivity(intent);
            }
        });
    }
}
