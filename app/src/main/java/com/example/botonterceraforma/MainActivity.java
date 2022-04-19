package com.example.botonterceraforma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Atributos
    private TextView tvResultado;
    private EditText etPalabra;
    private Button btnInvertir, btnMensaje;

    private String palabra;
    //Métodos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        //Configurar a los botones para que puedan estar atentos a los eventos click
        /*
            Métodos -> recibir inputs, parámetros o argumentos...
            parámetros de tipo Primitivas...(int, String, float)
            parámetros de tipo Objeto -- instacias de una clase
            parámetros de tipo función --> funciones anónimas o funciones lambda o funciones flecha
            ejemplo en JavaScript -- map, filter
            como parámetro una función, ese método que recibe la función como parámetro
            ejecuta esa función pero en un ámbito local
        */
        //3ra forma la función anónima se activa de forma local
        //solamente para el bóton en cuestión
        btnInvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerInformacion();
                invertirPalabra();
            }
        });// esperando una función anónima como
    }

    private void inicializarVistas(){
        tvResultado = findViewById(R.id.tvResultado);
        etPalabra = findViewById(R.id.etPalabra);
        btnInvertir = findViewById(R.id.btnInvertir);
        btnMensaje = findViewById(R.id.btnMensaje);
    }

    private void obtenerInformacion(){
        palabra = etPalabra.getText().toString();
    }

    private void invertirPalabra(){
        //separar palabras - array
        String invertido = "";
        /*
            En Java existe una función o método que les permite
            analizar una cadena como un vector, cada letra de la
            cadena es asociada a un índice como en un array.
            Ese método les devuelve una letra en determinada posición
            como si quiseran un elemento en un índice de un array
            --Cuidado: La cadena es uun String, las letras que componen una
            cadena son concidas como un char
            String -> hola ---- en la posición 0 tiene el char -> h
        */
        for (int i = palabra.length() - 1; i >= 0; i--) {
            invertido += palabra.charAt(i);
        }
        tvResultado.setText(invertido);
    }
}