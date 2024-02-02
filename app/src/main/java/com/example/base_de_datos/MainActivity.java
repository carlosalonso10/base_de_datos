package com.example.base_de_datos;

import static com.example.base_de_datos.R.id.nombres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Configuracion.SQLiteconexion;
import Configuracion.Transacciones;

public class MainActivity extends AppCompatActivity {

    EditText nombres, apellidos, telefono, edad, correo;
    Button btnproceso;
    private android.content.Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombres = (EditText) findViewById(R.id.nombres);
        apellidos = (EditText) findViewById(R.id.apellidos);
        telefono = (EditText) findViewById(R.id.telefono);
        edad = (EditText) findViewById(R.id.edad);
        correo = (EditText) findViewById(R.id.correo);
        btnproceso = (Button)findViewById(R.id.btnproceso);

        btnproceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               AddPerson();
                }
            });
        }

    private void AddPerson() {
        SQLiteconexion conexion = new SQLiteconexion(this, Transacciones.DBname, null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombres, nombres.getText().toString());
        valores.put(Transacciones.apellidos, apellidos.getText().toString());
        valores.put(Transacciones.telefono, telefono.getText().toString());
        valores.put(Transacciones.edad, edad.getText().toString());
        valores.put(Transacciones.correo, correo.getText().toString());

        Long resultado = db.insert(Transacciones.Tablepersonas, Transacciones.id, valores);
        Toast.makeText(getApplicationContext(), "Registro Ingresado con exito" + resultado.toString(),
                Toast.LENGTH_LONG).show();

        db.close();
    }
}
