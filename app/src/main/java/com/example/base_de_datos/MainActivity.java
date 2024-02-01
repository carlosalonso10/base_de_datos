package com.example.base_de_datos;

import static com.example.base_de_datos.R.id.nombres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nombres, apellidos, telefono;
    Button btnproceso;
    private android.content.Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombres = (EditText) findViewById(R.id.nombres);
        apellidos = (EditText) findViewById(R.id.apellidos);
        telefono = (EditText) findViewById(R.id.telefono);
        btnproceso = (Button)findViewById(R.id.btnproceso);

        btnproceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String nombresValor = nombres.getText().toString();
                String apellidosValor = apellidos.getText().toString();
                String telefonoValor = telefono.getText().toString();
                
                if (nombresValor.isEmpty()|| apellidosValor.isEmpty()  || telefonoValor.isEmpty()){
                    Toast.makeText( MainActivity.this, "complete todos los  campos", Toast.LENGTH_SHORT
                    ).show();
                }else {
                    Bundle enviarDatos = new Bundle();
                    enviarDatos.putString("keynombres", nombresValor);
                    enviarDatos.putString("keyapellidos", apellidosValor);
                    enviarDatos.putString("keytelefono", telefonoValor);

                    Intent intent = new Intent(MainActivity.this, MainActivitypage.class);
                    intent.putExtras(enviarDatos);
                    startActivity(intent);
                }
            }
        });
    }
}
