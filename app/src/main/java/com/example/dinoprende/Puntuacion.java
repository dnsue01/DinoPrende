package com.example.dinoprende;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Puntuacion extends AppCompatActivity {

    TextView textView2;
    String datos;
    Button Volver_Jugar,salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuacion);

        //recoger los parametros pasados
        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            datos = parametros.getString("usuario");
        }


        textView2 = (TextView) findViewById(R.id.textView2);
        recuperar(getApplicationContext());

        Volver_Jugar = (Button) findViewById(R.id.volver_Jugar);
        salir = (Button) findViewById(R.id.salir);




        Volver_Jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), ModosJuego.class);
                intent.putExtra("usuario", datos);
                startActivity(intent);
                finish();
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


    public void recuperar(Context context) {
        String nomarchivo = datos+".txt";

        File file = new File(context.getFilesDir(), nomarchivo);
        try {


            FileInputStream fIn = new FileInputStream(file);
            InputStreamReader archivo = new InputStreamReader(fIn);
            BufferedReader br = new BufferedReader(archivo);
            String linea = br.readLine();
            String todo = "";
            while (linea != null) {
                todo = todo + linea+ " \n " ;
                linea = br.readLine();
            }
            br.close();
            archivo.close();

            textView2.setText(todo);

        } catch (IOException e) {
            textView2.setText("No hay ninguna partida guardada, prubea a jugar!!!!");
        }
    }
}