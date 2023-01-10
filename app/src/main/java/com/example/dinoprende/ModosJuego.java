package com.example.dinoprende;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ModosJuego extends AppCompatActivity {

    TextView usuario;
    Button numeros,palabras,puntos;
    Bundle parametros;
    String datos;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modos_juego);

        //recoger los parametros pasados
         parametros = this.getIntent().getExtras();
        if(parametros !=null){
          datos = parametros.getString("usuario");
            usuario = (TextView) findViewById(R.id.txtNombre2);
            usuario.setText("Hola "+datos+" !!!");

        }

        //asignacion de botones
        numeros = (Button) findViewById(R.id.bNumeros);
        palabras = (Button) findViewById(R.id.bPalabras);
        puntos = (Button) findViewById(R.id.bPuntos);

        numeros.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), ModoNumeros.class);
                intent.putExtra("usuario", datos);
                startActivity(intent);
                finish();
            }
        });
        palabras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ModoPalabras.class);
                intent.putExtra("usuario", datos);
                startActivity(intent);
                finish();
            }
        });

        puntos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), Puntuacion.class);
                intent.putExtra("usuario", datos);
                startActivity(intent);
                finish();
            }
        });

    }
}