package com.example.dinoprende;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ModoPalabras extends AppCompatActivity {

    String[] palabras5 = {"pizza", "papas", "magos", "volar", "gafas", "dados", "gatos"};
    String[] alfabeto = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    String[][] arrayMultidimensional = {
            {"libro", "Publicacion impresa que contiene informacion sobre un tema especifico"},
            {"pizarra", "Superficie lisa y horizontal donde se escriben o dibujan con tiza"},
            {"tiza", "Material de color blanco o gris que se utiliza para escribir o dibujar en la pizarra"},
            {"lapiz", "Instrumento de escritura con punta de grafito o lapiz de color"},
            {"cuaderno", "Libro con hojas sueltas donde se escriben o dibujan"},
            {"profesor", "Persona que enseña en una escuela o universidad"},
            {"escuela", "Edificio donde se imparten  lecciones a personas"},
            {"clase", "Periodo de tiempo durante el cual se imparte una leccion en la escuela"},
            {"tarea", "Actividad que se realiza fuera del horario escolar y que forma parte del aprendizaje"},
            {"examen", "Evaluacion que se realiza para medir el conocimiento o habilidades de un estudiante"}
    };



    TextView usuario, txtCorta, txtAyuda,niveltxt;
    String datos;
    String palabra;
    ImageView huecoP1, huecoP2, huecoP3, huecoP4;

    Button respuestaPa1, respuestaPa2, respuestaPa3, respuestaPa4;
    int contador = 3;
    int nivel = 1;

    char last;
    boolean isValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_palabras);


        // Create new fragment and transaction
        Fragment newFragment = new Corazon3();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.frame1, newFragment);
        transaction.addToBackStack(null);
        // Commit the transaction
        transaction.commit();

        //recoger los parametros pasados
        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null) {
            datos = parametros.getString("usuario");

            usuario = (TextView) findViewById(R.id.txtNombre2);
            usuario.setText(datos);
        }


        txtCorta = (TextView) findViewById(R.id.txtCorta);
        txtAyuda = (TextView) findViewById(R.id.txtAyuda);
        niveltxt = (TextView) findViewById(R.id.niveltxt);

        respuestaPa1 = (Button) findViewById(R.id.respuestaPa1);
        respuestaPa2 = (Button) findViewById(R.id.respuestaPa2);
        respuestaPa3 = (Button) findViewById(R.id.respuestaPa3);
        respuestaPa4 = (Button) findViewById(R.id.respuestaPa4);

        findViewById(R.id.respuestaPa1).setOnClickListener(onClickListener);
        findViewById(R.id.respuestaPa2).setOnClickListener(onClickListener);
        findViewById(R.id.respuestaPa3).setOnClickListener(onClickListener);
        findViewById(R.id.respuestaPa4).setOnClickListener(onClickListener);

        huecoP1 = (ImageView) findViewById(R.id.huecoP1);
        huecoP2 = (ImageView) findViewById(R.id.huecoP2);
        huecoP3 = (ImageView) findViewById(R.id.huecoP3);
        huecoP4 = (ImageView) findViewById(R.id.huecoP4);

        generarNumeros();


        niveltxt.setText("nivel "+Integer.toString(nivel));

    }

    @SuppressLint("SetTextI18n")
    public void generarNumeros() {
        switch (nivel) {
            case 1:
                niveltxt.setText("nivel " + nivel);
                palabraSimples();
                break;
            case 2:
                niveltxt.setText("nivel " + nivel);
                setPalabrasDificiles();
                break;

            case 3:
                niveltxt.setText("nivel " + nivel);
                palabraSimples();
                break;

            case 4:
                niveltxt.setText("nivel " + nivel);
                setPalabrasDificiles();
                break;

            case 5:
                niveltxt.setText("nivel " + nivel);
                palabraSimples();

                break;
            case 6:
                niveltxt.setText("nivel " + nivel);
                setPalabrasDificiles();
                break;

            case 7:
                niveltxt.setText("nivel " + nivel);
                palabraSimples();
                break;
            case 8:
                niveltxt.setText("nivel " + nivel);
                setPalabrasDificiles();
                break;
            case 9:
                niveltxt.setText("nivel " + nivel);
                palabraSimples();
                break;
            case 10:
                niveltxt.setText("nivel " + nivel);
                setPalabrasDificiles();
                break;

        }


    }


    public void palabraSimples() {
        String palabra = palabraAleatoria(palabras5);

        isValid = false;
        // Remove the last character from the string
        String palabraCorta = palabra.substring(0, palabra.length() - 1);

        getCharacters(palabraCorta);
        //ultimo
        last = palabra.charAt(palabra.length() - 1);

        txtCorta.setText("");
        txtAyuda.setText("");

        String[] respuestas = new String[4];
        respuestas = randomStrings(alfabeto, last);

        respuestas = shuffleArray(respuestas);

        respuestaPa1.setText(respuestas[0]);
        respuestaPa2.setText(respuestas[1]);
        respuestaPa3.setText(respuestas[2]);
        respuestaPa4.setText(respuestas[3]);
    }

    public void setPalabrasDificiles() {

        isValid = true;
        this.huecoP1.setImageResource(0);
        this.huecoP2.setImageResource(0);
        this.huecoP3.setImageResource(0);
        this.huecoP4.setImageResource(0);

        String[] palabraArray = palabrasDificiles(arrayMultidimensional);
         palabra = palabraArray[0];
        String Descripcion = palabraArray[1];




        txtAyuda.setText(Descripcion);

        String[] respuestas = new String[4];
        respuestas = randomStrings2(arrayMultidimensional,palabra);

        respuestas = shuffleArray(respuestas);

        respuestaPa1.setText(respuestas[0]);
        respuestaPa1.setTextSize(20);
        respuestaPa2.setText(respuestas[1]);
        respuestaPa2.setTextSize(20);
        respuestaPa3.setText(respuestas[2]);
        respuestaPa3.setTextSize(20);
        respuestaPa4.setText(respuestas[3]);
        respuestaPa4.setTextSize(20);
    }


    public void getCharacters(String input) {

        String p1 = input.substring(0, 1);
        String p2 = input.substring(1, 2);
        String p3 = input.substring(2, 3);
        String p4 = input.substring(3, 4);

        this.huecoP1.setImageResource(getResources().getIdentifier(p1, "drawable", getPackageName()));
        this.huecoP2.setImageResource(getResources().getIdentifier(p2, "drawable", getPackageName()));
        this.huecoP3.setImageResource(getResources().getIdentifier(p3, "drawable", getPackageName()));
        this.huecoP4.setImageResource(getResources().getIdentifier(p4, "drawable", getPackageName()));


    }


    public String palabraAleatoria(String[] palabras) {

        // Generate a random index
        int index = (int) (Math.random() * palabras.length);

        // Pick a random string from the array
        String randomString = palabras[index];

        return randomString;
    }

    public String[] randomStrings(String[] strings, char c) {
        // Create a new array of four strings
        String[] newStrings = new String[4];

        // Generate three random indices
        int index1 = (int) (Math.random() * strings.length);
        int index2 = (int) (Math.random() * strings.length);
        int index3 = (int) (Math.random() * strings.length);

        // Pick three random strings from the original array
        newStrings[0] = strings[index1];
        newStrings[1] = strings[index2];
        newStrings[2] = strings[index3];

        // Set the fourth string to the given character
        newStrings[3] = Character.toString(c);

        // Return the new array
        return newStrings;
    }

    public String[] randomStrings2(String[][] strings, String c) {
        // Create a new array of four strings
        String[] newStrings = new String[4];

        // Generate three random indices
        int index1 = (int) (Math.random() * strings.length);
        int index2 = (int) (Math.random() * strings.length);
        int index3 = (int) (Math.random() * strings.length);

        // Pick three random strings from the original array
        newStrings[0] = strings[index1][0];
        newStrings[1] = strings[index2][0];
        newStrings[2] = strings[index3][0];

        // Set the fourth string to the given character
        newStrings[3] = c;

        // Return the new array
        return newStrings;
    }

    public String[] palabrasDificiles(String[][] strings) {
        // Create a new array of four strings
        String[] newStrings = new String[2];

        // Generate three random indices
        int index1 = (int) (Math.random() * strings.length);

        newStrings = strings[index1];

        // Return the new array
        return newStrings;
    }


    static String[] shuffleArray(String[] ar) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }

    public void restarVidas(View view) {
        contador--;

        switch (contador) {
            case 0:
                Intent intent = new Intent(view.getContext(), GameOver.class);
                intent.putExtra("usuario", usuario.getText());
                intent.putExtra("puntuacion", Integer.toString(nivel));
                startActivity(intent);
                finish();
                break;

            case 1:
                ImageView image = new ImageView(this);
                image.setImageResource(R.drawable.triste3);

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(this).
                                setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                }).
                                setView(image);
                builder.create().show();

                Fragment newFragment = new Corazon1();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.frame1, newFragment);
                transaction.addToBackStack(null);

                transaction.commit();


                break;
            case 2:

                image = new ImageView(this);
                image.setImageResource(R.drawable.trsiste2);

                builder =
                        new AlertDialog.Builder(this).

                                setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                }).
                                setView(image);
                builder.create().show();

                newFragment = new Corazon2();
                transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.frame1, newFragment);
                transaction.addToBackStack(null);

                transaction.commit();
                break;

            case 3:

                image = new ImageView(this);
                image.setImageResource(R.drawable.triste1);

                builder =
                        new AlertDialog.Builder(this).

                                setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                }).
                                setView(image);
                builder.create().show();

                newFragment = new Corazon3();
                transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.frame1, newFragment);
                transaction.addToBackStack(null);

                transaction.commit();
                break;
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            pressed(view);
        }
    };

    private void pressed(View view) {

        switch (view.getId()) {
            case R.id.respuestaPa1:

                if(isValid){
                    if (respuestaPa1.getText().equals(palabra)) {
                        ImageView image = new ImageView(this);
                        image.setImageResource(R.drawable.happy);

                        AlertDialog.Builder builder =
                                new AlertDialog.Builder(this).
                                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        }).
                                        setView(image);
                        builder.create().show();
                        nivel++;


                        if(nivel == 11){
                            Intent intent = new Intent(view.getContext(), ganador.class);
                            intent.putExtra("usuario", usuario.getText());
                            startActivity(intent);
                            finish();
                        }else{
                            generarNumeros();
                        }

                    }else{
                        restarVidas(view);
                    }
                }else{
                    if (respuestaPa1.getText().equals(Character.toString(last))) {
                        ImageView image = new ImageView(this);
                        image.setImageResource(R.drawable.happy);

                        AlertDialog.Builder builder =
                                new AlertDialog.Builder(this).
                                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        }).
                                        setView(image);
                        builder.create().show();
                        nivel++;


                        if(nivel == 11){
                            Intent intent = new Intent(view.getContext(), ganador.class);
                            intent.putExtra("usuario", usuario.getText());
                            startActivity(intent);
                            finish();
                        }else{
                            generarNumeros();
                        }

                    }else{
                        restarVidas(view);
                    }
                }


                    break;
            case R.id.respuestaPa2:

                if(isValid){
                    if (respuestaPa2.getText().equals(palabra)) {
                        ImageView image = new ImageView(this);
                        image.setImageResource(R.drawable.happy);

                        AlertDialog.Builder builder =
                                new AlertDialog.Builder(this).
                                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        }).
                                        setView(image);
                        builder.create().show();
                        nivel++;

                        if(nivel == 11){
                            Intent intent = new Intent(view.getContext(), ganador.class);
                            intent.putExtra("usuario", usuario.getText());
                            startActivity(intent);
                            finish();
                        }else{
                            generarNumeros();
                        }

                    }else{
                        restarVidas(view);
                    }
                }else{
                    if (respuestaPa2.getText().equals(Character.toString(last))) {
                        ImageView image = new ImageView(this);
                        image.setImageResource(R.drawable.happy);

                        AlertDialog.Builder builder =
                                new AlertDialog.Builder(this).
                                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        }).
                                        setView(image);
                        builder.create().show();
                        nivel++;

                        if(nivel == 11){
                            Intent intent = new Intent(view.getContext(), ganador.class);
                            intent.putExtra("usuario", usuario.getText());
                            startActivity(intent);
                            finish();
                        }else{
                            generarNumeros();
                        }

                    }else{
                        restarVidas(view);
                    }
                }
                        break;
            case R.id.respuestaPa3:
                if(isValid){
                    if (respuestaPa3.getText().equals(palabra)) {
                        ImageView image = new ImageView(this);
                        image.setImageResource(R.drawable.happy);

                        AlertDialog.Builder builder =
                                new AlertDialog.Builder(this).
                                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        }).
                                        setView(image);
                        builder.create().show();
                        nivel++;

                        if(nivel == 11){
                            Intent intent = new Intent(view.getContext(), ganador.class);
                            intent.putExtra("usuario", usuario.getText());
                            startActivity(intent);
                            finish();
                        }else{
                            generarNumeros();
                        }

                    }else{
                        restarVidas(view);
                    }
                }else{
                    if (respuestaPa3.getText().equals(Character.toString(last))) {
                        ImageView image = new ImageView(this);
                        image.setImageResource(R.drawable.happy);

                        AlertDialog.Builder builder =
                                new AlertDialog.Builder(this).
                                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        }).
                                        setView(image);
                        builder.create().show();
                        nivel++;

                        if(nivel == 11){
                            Intent intent = new Intent(view.getContext(), ganador.class);
                            intent.putExtra("usuario", usuario.getText());
                            startActivity(intent);
                            finish();
                        }else{
                            generarNumeros();
                        }

                    }else{
                        restarVidas(view);
                    }
                }
                break;

            case R.id.respuestaPa4:

                if(isValid){
                    if (respuestaPa4.getText().equals(palabra)) {
                        ImageView image = new ImageView(this);
                        image.setImageResource(R.drawable.happy);

                        AlertDialog.Builder builder =
                                new AlertDialog.Builder(this).
                                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        }).
                                        setView(image);
                        builder.create().show();
                        nivel++;

                        if(nivel == 11){
                            Intent intent = new Intent(view.getContext(), ganador.class);
                            intent.putExtra("usuario", usuario.getText());
                            startActivity(intent);
                            finish();
                        }else{
                            generarNumeros();
                        }

                    }else{
                        restarVidas(view);
                    }
                }else{
                    if (respuestaPa4.getText().equals(Character.toString(last))) {
                        ImageView image = new ImageView(this);
                        image.setImageResource(R.drawable.happy);

                        AlertDialog.Builder builder =
                                new AlertDialog.Builder(this).
                                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        }).
                                        setView(image);
                        builder.create().show();
                        nivel++;
                        if(nivel == 11){
                            Intent intent = new Intent(view.getContext(), ganador.class);
                            intent.putExtra("usuario", usuario.getText());
                            startActivity(intent);
                            finish();
                        }else{
                            generarNumeros();
                        }

                    }else{
                        restarVidas(view);
                    }
                }



                        break;
                }
        }
    }
