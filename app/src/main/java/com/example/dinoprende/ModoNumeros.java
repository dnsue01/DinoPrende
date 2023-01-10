package com.example.dinoprende;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.AccessController;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ModoNumeros extends AppCompatActivity {

    TextView usuario,niveltxt;
    String datos;


    ImageView huecoN1,huecoN2,huecoN3,huecoN4,huecoSim;

    Button respuesta1,respuesta2,respuesta3,respuesta4;
    int contador = 3;

    int nivel = 1;
    int num1;
    int num2;
    int resultado;


    int[] resultados = new int[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_numeros);



        respuesta1 = (Button) findViewById(R.id.respuesta1);
        respuesta2 = (Button) findViewById(R.id.respuesta2);
        respuesta3 = (Button) findViewById(R.id.respuesta3);
        respuesta4 = (Button) findViewById(R.id.respuesta4);

        findViewById(R.id.respuesta1).setOnClickListener(onClickListener);
        findViewById(R.id.respuesta2).setOnClickListener(onClickListener);
        findViewById(R.id.respuesta3).setOnClickListener(onClickListener);
        findViewById(R.id.respuesta4).setOnClickListener(onClickListener);



        huecoN1= (ImageView) findViewById(R.id.huecoN1);
        huecoN2= (ImageView) findViewById(R.id.huecoN2);
        huecoN3= (ImageView) findViewById(R.id.huecoN3);
        huecoN4= (ImageView) findViewById(R.id.huecoN4);

        huecoSim = (ImageView) findViewById(R.id.huecoSim);

        niveltxt = (TextView) findViewById(R.id.niveltxt);

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
        if(parametros !=null){
             datos = parametros.getString("usuario");

            usuario = (TextView) findViewById(R.id.txtNombre2);
            usuario.setText(datos);
        }


        generarNumeros();

    }

    @SuppressLint("SetTextI18n")
    public void generarNumeros(){
        this.resultados = null;
        switch (nivel){
            case 1:
                niveltxt.setText("nivel "+nivel);
                sumar();
                break;
            case 2:
                niveltxt.setText("nivel "+nivel);
                restar();
                break;

            case 3:
                niveltxt.setText("nivel "+nivel);
                multiplicar();
                break;

            case 4:
                niveltxt.setText("nivel "+nivel);
                dividir();
                break;

            case 5:
                niveltxt.setText("nivel "+nivel);
                sumarComplicado();

                break;
            case 6:
                niveltxt.setText("nivel "+nivel);
                restarComplicado();
                break;

            case 7:
                niveltxt.setText("nivel "+nivel);
                multiplicarComplicado();
                break;
            case 8:
                niveltxt.setText("nivel "+nivel);
                dividirComplicado();
                break;
            case 9:
                niveltxt.setText("nivel "+nivel);
                multiplicarComplicado();
                break;
            case 10:
                niveltxt.setText("nivel "+nivel);
                dividirComplicado();
                break;

        }

    }
    // Implementing Fisher–Yates shuffle
    static void shuffleArray(int[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
    // Implementing Fisher–Yates shuffle
    public int[] generarRespestasSuma()
    {

        int[] array = new int[4];

        for (int i =0 ; i <2; i++)
        {
            int numero = (int)(Math.random()*18+1);

            while (numero == this.resultado){
                numero = (int)(Math.random()*18+1);
            }

            array[i] = numero;
        }
        array[3] = this.resultado;

        return array;
    }
    // Implementing Fisher–Yates shuffle
    public int[] generarRespestasSumaComplicada()
    {

        int[] array = new int[4];

        for (int i =0 ; i <2; i++)
        {
            int numero = (int)(Math.random()*99+1);

            while (numero == this.resultado){
                numero = (int)(Math.random()*99+1);
            }

            array[i] = numero;
        }
        array[3] = this.resultado;

        return array;
    }


    public int[] generarRespestasResta()
    {

        int[] array = new int[4];

        for (int i =0 ; i <2; i++)
        {
            int numero = (int)(Math.random()*9+1);

            while (numero == this.resultado){
                numero = (int)(Math.random()*10+1);
            }

            array[i] = numero;
        }
        array[3] = this.resultado;

        return array;
    }
    // Implementing Fisher–Yates shuffle
    public int[] generarRespestasMultiplicacion()
    {

        int[] array = new int[4];

        for (int i =0 ; i <2; i++)
        {
            int numero = (int)(Math.random()*81+1);

            while (numero == this.resultado){
                numero = (int)(Math.random()*80+1);
            }

            array[i] = numero;
        }
        array[3] = this.resultado;

        return array;
    }
    public int[] generarRespestasDivision()
    {

        int[] array = new int[4];

        for (int i =0 ; i <2; i++)
        {
            int numero = (int)(Math.random()*30+1);

            while (numero == this.resultado){
                numero = (int)(Math.random()*30+1);
            }

            array[i] = numero;
        }
        array[3] = this.resultado;

        return array;
    }
    public int[] generarRespestasMultiplicacionComplicada()
    {

        int[] array = new int[4];

        for (int i =0 ; i <2; i++)
        {
            int numero = (int)(Math.random()*99+1);

            while (numero == this.resultado){
                numero = (int)(Math.random()*99+1);
            }

            array[i] = numero;
        }
        array[3] = this.resultado;

        return array;
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            pressed(view);
        }
    };

    private void pressed(View view){

        switch(view.getId()){
            case R.id.respuesta1:

                if(respuesta1.getText().equals(Integer.toString(resultado))){
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

                break;
            case R.id.respuesta2:
                if(respuesta2.getText().equals(Integer.toString(resultado))){
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
                break;
            case R.id.respuesta3:
                if(respuesta3.getText().equals(Integer.toString(resultado))){
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
                break;

            case R.id.respuesta4:

                if(respuesta4.getText().equals(Integer.toString(resultado))){
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
                break;
        }
    }

    public void restarVidas(View view){
        contador--;

        switch (contador){
            case 0:



                Intent intent = new Intent(view.getContext(), GameOver.class);
                intent.putExtra("usuario", usuario.getText());
                intent.putExtra("puntuacion",Integer.toString(nivel));
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
public void sumar(){
    this.num1 = (int)(Math.random()*9+1);
    this.num2 = (int)(Math.random()*9+1);

    String n1 = "n"+this.num1;
    String n2 = "n"+this.num2;


    this.resultado = num1+num2;

    this.huecoSim.setImageResource(R.drawable.sm);
    this.huecoN2.setImageResource(getResources().getIdentifier(n1, "drawable", getPackageName()));
    this.huecoN3.setImageResource(getResources().getIdentifier(n2, "drawable", getPackageName()));


    this.resultados = generarRespestasSuma();
    shuffleArray(this.resultados);

    this.respuesta1.setText(Integer.toString(this.resultados[0]));
    this.respuesta2.setText(Integer.toString(this.resultados[1]));
    this.respuesta3.setText(Integer.toString(this.resultados[2]));
    this.respuesta4.setText(Integer.toString(this.resultados[3]));
}
    public void sumarComplicado(){

        this.huecoN1.setImageResource(0);
        this.huecoN2.setImageResource(0);
        this.huecoN3.setImageResource(0);
        this.huecoN4.setImageResource(0);

        this.num1 = (int)(Math.random()*49+2);
        this.num2 = (int)(Math.random()*49+1);



        if(num1>=10){
            String compuesto1 = ""+this.num1;
            String n1 = "n"+compuesto1.charAt(0);
            String n2 = "n"+compuesto1.charAt(1);
            this.huecoN1.setImageResource(getResources().getIdentifier(n1, "drawable", getPackageName()));
            this.huecoN2.setImageResource(getResources().getIdentifier(n2, "drawable", getPackageName()));
        }else{
            String n1 = "n"+this.num1;
            this.huecoN2.setImageResource(getResources().getIdentifier(n1, "drawable", getPackageName()));
        }
        if(num2>=10){
            String compuesto2 = ""+this.num2;
            String n3 = "n"+compuesto2.charAt(0);
            String n4 = "n"+compuesto2.charAt(1);
            this.huecoN3.setImageResource(getResources().getIdentifier(n3, "drawable", getPackageName()));
            this.huecoN4.setImageResource(getResources().getIdentifier(n4, "drawable", getPackageName()));
        }else{
            String n3 = "n"+this.num2;
            this.huecoN3.setImageResource(getResources().getIdentifier(n3, "drawable", getPackageName()));
        }


        this.resultado = num1+num2;

        this.huecoSim.setImageResource(R.drawable.sm);



        this.resultados = generarRespestasSumaComplicada();
        shuffleArray(this.resultados);

        this.respuesta1.setText(Integer.toString(this.resultados[0]));
        this.respuesta2.setText(Integer.toString(this.resultados[1]));
        this.respuesta3.setText(Integer.toString(this.resultados[2]));
        this.respuesta4.setText(Integer.toString(this.resultados[3]));
    }
    public void restar(){
        this.huecoN1.setImageResource(0);
        this.huecoN2.setImageResource(0);
        this.huecoN3.setImageResource(0);
        this.huecoN4.setImageResource(0);


        this.num1 = (int)(Math.random()*9+1);
        this.num2 = (int)(Math.random()*9+1);

        if(num2>num1){
            int numero = num2;
            num1 = num2;
            num2 = numero;
        }
        String n1 = "n"+this.num1;
        String n2 = "n"+this.num2;


        this.resultado = num1-num2;

        this.huecoSim.setImageResource(R.drawable.rs);
        this.huecoN2.setImageResource(getResources().getIdentifier(n1, "drawable", getPackageName()));
        this.huecoN3.setImageResource(getResources().getIdentifier(n2, "drawable", getPackageName()));


        this.resultados = generarRespestasResta();
        shuffleArray(this.resultados);

        this.respuesta1.setText(Integer.toString(this.resultados[0]));
        this.respuesta2.setText(Integer.toString(this.resultados[1]));
        this.respuesta3.setText(Integer.toString(this.resultados[2]));
        this.respuesta4.setText(Integer.toString(this.resultados[3]));
    }
    public void multiplicar(){

        this.huecoN1.setImageResource(0);
        this.huecoN2.setImageResource(0);
        this.huecoN3.setImageResource(0);
        this.huecoN4.setImageResource(0);


        this.num1 = (int)(Math.random()*9+1);
        this.num2 = (int)(Math.random()*9+1);


        String n1 = "n"+this.num1;
        String n2 = "n"+this.num2;


        this.resultado = num1*num2;

        this.huecoSim.setImageResource(R.drawable.mul);
        this.huecoN2.setImageResource(getResources().getIdentifier(n1, "drawable", getPackageName()));
        this.huecoN3.setImageResource(getResources().getIdentifier(n2, "drawable", getPackageName()));


        this.resultados = generarRespestasMultiplicacion();
        shuffleArray(this.resultados);

        this.respuesta1.setText(Integer.toString(this.resultados[0]));
        this.respuesta2.setText(Integer.toString(this.resultados[1]));
        this.respuesta3.setText(Integer.toString(this.resultados[2]));
        this.respuesta4.setText(Integer.toString(this.resultados[3]));
    }
    public void dividir(){
        this.huecoN1.setImageResource(0);
        this.huecoN2.setImageResource(0);
        this.huecoN3.setImageResource(0);
        this.huecoN4.setImageResource(0);

       boolean valido = false;

        while(!valido){


        this.num1 = (int)(Math.random()*9+1);
        this.num2 = (int)(Math.random()*9+1);


        if(num2>num1){
            int numero = num2;
            num1 = num2;
            num2 = numero;
        }

        if(num1%num2 == 0){
            valido = true;
        }

        }

        String n1 = "n"+this.num1;
        String n2 = "n"+this.num2;


        this.resultado = num1/num2;

        this.huecoSim.setImageResource(R.drawable.div);
        this.huecoN2.setImageResource(getResources().getIdentifier(n1, "drawable", getPackageName()));
        this.huecoN3.setImageResource(getResources().getIdentifier(n2, "drawable", getPackageName()));


        this.resultados = generarRespestasDivision();
        shuffleArray(this.resultados);

        this.respuesta1.setText(Integer.toString(this.resultados[0]));
        this.respuesta2.setText(Integer.toString(this.resultados[1]));
        this.respuesta3.setText(Integer.toString(this.resultados[2]));
        this.respuesta4.setText(Integer.toString(this.resultados[3]));
    }

    public void dividirComplicado(){
        this.huecoN1.setImageResource(0);
        this.huecoN2.setImageResource(0);
        this.huecoN3.setImageResource(0);
        this.huecoN4.setImageResource(0);

        boolean valido = false;

        while(!valido){


            this.num1 = (int)(Math.random()*30+1);
            this.num2 = (int)(Math.random()*9+1);


            if(num2>num1){
                int numero = num2;
                num1 = num2;
                num2 = numero;
            }

            if(num1%num2 == 0){
                valido = true;
            }

        }

        if(num1>=10){
            String compuesto1 = ""+this.num1;
            String n1 = "n"+compuesto1.charAt(0);
            String n2 = "n"+compuesto1.charAt(1);
            this.huecoN1.setImageResource(getResources().getIdentifier(n1, "drawable", getPackageName()));
            this.huecoN2.setImageResource(getResources().getIdentifier(n2, "drawable", getPackageName()));
        }else {
            String n1 = "n" + this.num1;
            this.huecoN2.setImageResource(getResources().getIdentifier(n1, "drawable", getPackageName()));
        }

            String n3 = "n"+this.num2;
            this.huecoN3.setImageResource(getResources().getIdentifier(n3, "drawable", getPackageName()));


        this.resultado = num1/num2;

        this.huecoSim.setImageResource(R.drawable.div);

        this.resultados = generarRespestasDivision();
        shuffleArray(this.resultados);

        this.respuesta1.setText(Integer.toString(this.resultados[0]));
        this.respuesta2.setText(Integer.toString(this.resultados[1]));
        this.respuesta3.setText(Integer.toString(this.resultados[2]));
        this.respuesta4.setText(Integer.toString(this.resultados[3]));



    }
    public void restarComplicado(){

        this.huecoN1.setImageResource(0);
        this.huecoN2.setImageResource(0);
        this.huecoN3.setImageResource(0);
        this.huecoN4.setImageResource(0);

        this.num1 = (int)(Math.random()*49+1);
        this.num2 = (int)(Math.random()*49+1);

        if(num2>num1){
            int numero = num2;
            num1 = num2;
            num2 = numero;
        }

        if(num1>=10){
            String compuesto1 = ""+this.num1;
            String n1 = "n"+compuesto1.charAt(0);
            String n2 = "n"+compuesto1.charAt(1);
            this.huecoN1.setImageResource(getResources().getIdentifier(n1, "drawable", getPackageName()));
            this.huecoN2.setImageResource(getResources().getIdentifier(n2, "drawable", getPackageName()));
        }else{
            String n1 = "n"+this.num1;
            this.huecoN2.setImageResource(getResources().getIdentifier(n1, "drawable", getPackageName()));
        }
        if(num2>=10){
            String compuesto2 = ""+this.num2;
            String n3 = "n"+compuesto2.charAt(0);
            String n4 = "n"+compuesto2.charAt(1);
            this.huecoN3.setImageResource(getResources().getIdentifier(n3, "drawable", getPackageName()));
            this.huecoN4.setImageResource(getResources().getIdentifier(n4, "drawable", getPackageName()));
        }else{
            String n1 = "n"+this.num2;
            this.huecoN3.setImageResource(getResources().getIdentifier(n1, "drawable", getPackageName()));
        }


        this.resultado = num1-num2;

        this.huecoSim.setImageResource(R.drawable.rs);



        this.resultados = generarRespestasSumaComplicada();
        shuffleArray(this.resultados);

        this.respuesta1.setText(Integer.toString(this.resultados[0]));
        this.respuesta2.setText(Integer.toString(this.resultados[1]));
        this.respuesta3.setText(Integer.toString(this.resultados[2]));
        this.respuesta4.setText(Integer.toString(this.resultados[3]));
    }
    public void multiplicarComplicado(){

        this.huecoN1.setImageResource(0);
        this.huecoN2.setImageResource(0);
        this.huecoN3.setImageResource(0);
        this.huecoN4.setImageResource(0);

        this.num1 = (int)(Math.random()*50+1);
        this.num2 = (int)(Math.random()*9+1);



        if(num1>=10){
            String compuesto1 = ""+this.num1;
            String n1 = "n"+compuesto1.charAt(0);
            String n2 = "n"+compuesto1.charAt(1);
            this.huecoN1.setImageResource(getResources().getIdentifier(n1, "drawable", getPackageName()));
            this.huecoN2.setImageResource(getResources().getIdentifier(n2, "drawable", getPackageName()));
        }else{
            String n1 = "n"+this.num1;
            this.huecoN2.setImageResource(getResources().getIdentifier(n1, "drawable", getPackageName()));
        }

            String n3 = "n"+this.num2;
            this.huecoN3.setImageResource(getResources().getIdentifier(n3, "drawable", getPackageName()));



        this.resultado = num1*num2;

        this.huecoSim.setImageResource(R.drawable.mul);



        this.resultados = generarRespestasMultiplicacionComplicada();
        shuffleArray(this.resultados);

        this.respuesta1.setText(Integer.toString(this.resultados[0]));
        this.respuesta2.setText(Integer.toString(this.resultados[1]));
        this.respuesta3.setText(Integer.toString(this.resultados[2]));
        this.respuesta4.setText(Integer.toString(this.resultados[3]));
    }


}