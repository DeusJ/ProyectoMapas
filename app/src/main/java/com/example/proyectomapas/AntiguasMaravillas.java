package com.example.proyectomapas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AntiguasMaravillas extends AppCompatActivity {

    Button btn8,btn9,btn10,btn11,btn12,btn13,btn14,mapaMaravillasAntiguas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antiguas_maravillas);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btn10 = findViewById(R.id.button10);
        btn11 = findViewById(R.id.button11);
        btn12 = findViewById(R.id.button12);
        btn13 = findViewById(R.id.button13);
        btn14 = findViewById(R.id.button14);
        mapaMaravillasAntiguas = findViewById(R.id.btn_MaravillasAntiguas);
        mapaMaravillasAntiguas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AntiguasMaravillas.this,MapsActivity2.class);
                startActivity(intent);
            }
        });
    }
}
