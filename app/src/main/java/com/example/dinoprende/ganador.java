package com.example.dinoprende;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class ganador extends AppCompatActivity {

    TextView txtNombre4;
    String datos;
    Button Volver_Jugar,puntuacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganador);

        //recoger los parametros pasados
        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null) {
             datos = parametros.getString("usuario");

            txtNombre4 = (TextView) findViewById(R.id.txtNombre4);
            txtNombre4.setText(datos);
        }
        grabar(getApplicationContext());

        Volver_Jugar = (Button) findViewById(R.id.volver_Jugar);

        puntuacion = (Button) findViewById(R.id.puntuacion);



        Volver_Jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), ModosJuego.class);
                intent.putExtra("usuario", datos);
                startActivity(intent);
                finish();
            }
        });

        puntuacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), Puntuacion.class);
                intent.putExtra("usuario", datos);
                startActivity(intent);
                finish();
            }
        });
    }

    public void grabar(Context context){
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            String nomarchivo = datos + ".txt";
            String contenido = "Tu puntuacion fue perfecta";

            File file = new File(context.getFilesDir(), nomarchivo);

            // Si el archivo no existe, se crea!
            if (!file.exists()) {
                file.createNewFile();
            }
            // flag true, indica adjuntar información al archivo.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.newLine();
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
            context = getApplicationContext();
            CharSequence text = "error";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }



}