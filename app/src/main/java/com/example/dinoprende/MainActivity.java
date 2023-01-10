package com.example.dinoprende;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

   
    private final int DURACION_SPLASH = 4000; // 3 segundos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        new Handler().postDelayed(new Runnable(){
            public void run(){

// Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicación

                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);
    }


    }
