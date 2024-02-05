package com.example.base_de_datos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import Configuracion.SQLiteconexion;

public class MainActivityList extends AppCompatActivity {
     SQLiteconexion conexion;

     ListView listpersonas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
    }
}