package com.example.tareaformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.tareaformulario.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private String eLog = MainActivity.class.getSimpleName();
    private ActivityMainBinding eBinding;
    private String nombre, apellido, correo, clave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Log.d(eLog,"APP Iniciada");

        eBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(eBinding.getRoot());

        eBinding.btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eBinding.textView.getText().toString().isEmpty()) {
                    Log.d(eLog, "Nombre vacío");
                } else {
                    nombre = eBinding.textView.getText().toString();
                }

            }
        });
    }
}