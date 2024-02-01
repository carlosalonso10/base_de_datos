package com.example.base_de_datos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class MainActivitypage extends AppCompatActivity {
       TextView nombres, apellidos, telefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitypage);

        nombres =(TextView)  findViewById(R.id.lblnombres);
        apellidos = (TextView) findViewById(R.id.lblapellidos);
        telefono = (TextView) findViewById(R.id.lbltelefono);

        Bundle recibirDatos = getIntent().getExtras();

        if (recibirDatos != null) {

            String nombresInfo = recibirDatos.getString("keynombres");
            String apellidosInfo = recibirDatos.getString("keyapellidos");
            String telefonoInfo = recibirDatos.getString("keytelefono");

            nombres.setText(nombresInfo);
            apellidos.setText(apellidosInfo);
            telefono.setText(telefonoInfo);
        }
    }
}