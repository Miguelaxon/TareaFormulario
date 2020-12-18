package com.example.tareaformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tareaformulario.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private String eLog = MainActivity.class.getSimpleName();
    private ActivityMainBinding eBinding;
    private String nombre, apellido, correo, clave;
    private Cuenta ingreso = new Cuenta();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(eBinding.getRoot());

        Toast.makeText(MainActivity.this, "APP Iniciada",
                Toast.LENGTH_SHORT).show();

        eBinding.btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = eBinding.textView.getText().toString();
                apellido = eBinding.textView2.getText().toString();
                correo = eBinding.editTextTextEmailAddress.getText().toString();
                clave = eBinding.editTextTextPassword.getText().toString();
                if (nombre.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Casilla del Nombre vacío",
                            Toast.LENGTH_SHORT).show();
                } else if (apellido.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Casilla del Apellido vacío",
                            Toast.LENGTH_SHORT).show();
                } else if (correo.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Casilla del Correo vacío",
                            Toast.LENGTH_SHORT).show();
                } else if (clave.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Casilla de la Clave vacía",
                            Toast.LENGTH_SHORT).show();
                } else {
                    ingreso = new Cuenta(nombre, apellido, correo, clave);
                    Toast.makeText(MainActivity.this, "Datos ingresados con éxito " + ingreso.getNombre(),
                            Toast.LENGTH_SHORT).show();
                    onIntents(ingreso);
                }
            }
        });
    }

    public void onIntents(Cuenta objCuenta){
        Bundle eBundle = new Bundle();
        eBundle.putString("nombre", objCuenta.getNombre());
        eBundle.putString("apellido", objCuenta.getApellido());
        eBundle.putString("correo", objCuenta.getCorreo());
        eBundle.putString("clave", objCuenta.getClave());
        Intent cambio = new Intent(this, ShowActivity.class);
        cambio.putExtra("data",eBundle);
        startActivity(cambio);
    }
}