package com.example.proyectomapas;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.content.Intent;
import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    public static final long SPLASH_SCREEN_DELAY = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TimerTask time = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent().setClass(Splash.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(time,SPLASH_SCREEN_DELAY);
    }
}
