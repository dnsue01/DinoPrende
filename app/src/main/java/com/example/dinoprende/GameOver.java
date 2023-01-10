package com.example.dinoprende;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class GameOver extends AppCompatActivity {


    TextView usuario,txtPuntuacion;
    ImageView imgPuntuacion;
    Button Volver_Jugar,puntuacion;

    String datos,datos1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        Volver_Jugar = (Button) findViewById(R.id.Volver_Jugar);

        puntuacion = (Button) findViewById(R.id.puntuacion);
        //recoger los parametros pasados
        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
             datos = parametros.getString("usuario");
             datos1 = parametros.getString("puntuacion");

            Integer puntuacion = Integer.parseInt(datos1);
            puntuacion--;

            datos1 = Integer.toString(puntuacion);

            usuario = (TextView) findViewById(R.id.txtNombre3);
            usuario.setText("Muy bien "+datos);

            txtPuntuacion = (TextView) findViewById(R.id.txtPuntuacion3);
            txtPuntuacion.setText("Tu score es de ");

            String n1 = "n"+datos1;

            imgPuntuacion = (ImageView) findViewById(R.id.imgPuntuacion);

            this.imgPuntuacion.setImageResource(getResources().getIdentifier(n1, "drawable", getPackageName()));
        }

        grabar(getApplicationContext());

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


        rotarImagen(imgPuntuacion);
    }


    public void grabar(Context context){
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            String nomarchivo = datos + ".txt";
            String contenido = "Tu puntuacion fue de " + datos1;

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

    private void rotarImagen(View view){
        RotateAnimation animation = new RotateAnimation(0, 30,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        animation.setDuration(500);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);
        view.startAnimation(animation);
    }



}