package com.example.dinoprende;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    TextView nombre;

    Button aceptar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombre = (TextView) findViewById(R.id.txtNombre3);
        aceptar = (Button) findViewById(R.id.Aceptar);


        aceptar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
               String usuario = String.valueOf(nombre.getText());

              if(usuario.equals("")){





                  ImageView image = new ImageView(view.getContext());
                  image.setImageResource(R.drawable.error);


                  AlertDialog.Builder builder =
                          new AlertDialog.Builder(view.getContext()).

                                  setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                      @Override
                                      public void onClick(DialogInterface dialog, int which) {
                                          dialog.dismiss();
                                      }
                                  }).
                                  setView(image);
                  builder.setIcon(R.drawable.logo);


                  builder.create().show();

                }else{


                  Intent intent = new Intent(view.getContext(), ModosJuego.class);
                  intent.putExtra("usuario", usuario);
                  startActivity(intent);
                  finish();



              }
            }
        });
    }
}