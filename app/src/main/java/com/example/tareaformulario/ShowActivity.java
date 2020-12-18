package com.example.tareaformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Toast;

import com.example.tareaformulario.databinding.ActivityMainBinding;
import com.example.tareaformulario.databinding.ActivityShowBinding;

public class ShowActivity extends AppCompatActivity {
    private ActivityShowBinding e2Binding;
    private Cuenta muestra = new Cuenta();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        e2Binding = ActivityShowBinding.inflate(getLayoutInflater());
        setContentView(e2Binding.getRoot());

        //Bundle eBundle2 =
        Intent eIntent = getIntent();
        Bundle eBundle2 = eIntent.getExtras().getBundle("data");
        String nombre = eBundle2.getString("nombre");
        String apellido = eBundle2.getString("apellido");
        String correo = eBundle2.getString("correo");

        e2Binding.tvNombre.setText("Su Nombre es: " + nombre);
        e2Binding.tvApellido.setText("Su Apellido es: " + apellido);
        e2Binding.tvCorreo.setText("Su Correo es: " + correo);

        e2Binding.btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onIntents();
            }
        });
    }

    public void onIntents(){
        Intent nuevo = new Intent(this, MainActivity.class);
        startActivity(nuevo);
    }
}