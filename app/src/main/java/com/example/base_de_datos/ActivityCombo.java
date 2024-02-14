package com.example.base_de_datos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import Configuracion.SQLiteconexion;
import Configuracion.Transacciones;
import Models.Personas;

public class ActivityCombo extends AppCompatActivity {
  SQLiteconexion conexion;
  Spinner combopersonas;

  EditText nombres, apellidos, telefono, edad, correo, direccion;

  ArrayList<Personas> lista;

  ArrayList<String> Arreglo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo);

        conexion = new SQLiteconexion(this, Transacciones.DBname, null, 1);
        combopersonas = (Spinner) findViewById(R.id.spinner);
        nombres = (EditText) findViewById(R.id.cbnombre);
        apellidos = (EditText) findViewById(R.id.cbapellido);
        telefono = (EditText) findViewById(R.id.cbtelefono);
        edad = (EditText) findViewById(R.id.cbedad);
        correo = (EditText) findViewById(R.id.cbcorreo);
        direccion = (EditText) findViewById(R.id.cbdireccion);


    ObtenerDatos();
    ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this,
            android.R.layout.simple_spinner_item,
       Arreglo);

    combopersonas.setAdapter(adapter);
  combopersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
      { try

      {

              nombres.setText(lista.get(position).getNombres());
              apellidos.setText(lista.get(position).getApellidos());
              telefono.setText(lista.get(position).getTelefono());
              edad.setText(lista.get(position).getEdad());
              correo.setText(lista.get(position).getCorreo());
              direccion.setText(lista.get(position).getDireccion());


          }
      catch(Exception ex)

          {
              ex.toString();
          }
      }
      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
  });
    }

    private void ObtenerDatos() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas person= null;
        lista = new ArrayList<Personas>();

        //cursor de  base de datos para recorrer los datos
        Cursor cursor = db.rawQuery(Transacciones.SelectAllPersonas, null);
        while (cursor.moveToNext())
        {
            person = new Personas();
            person.setId(cursor.getInt(0));
            person.setNombres(cursor.getString(1));
            person.setApellidos(cursor.getString(2));
            person.setTelefono(cursor.getInt(3));
            person.setEdad(cursor.getInt( 4));
            person.setCorreo(cursor.getString(5));
            person.setDireccion(cursor.getString(6));

            lista.add(person);
        }
        cursor.close();

        FillData();
    }
    private void  FillData()
    {
        Arreglo = new ArrayList<String>();
        for (int i= 0; i < lista.size(); i ++)
        {
            Arreglo.add(lista.get(i).getId() + " - "+
                    lista.get(i).getNombres() + " - "+
                    lista.get(i).getApellidos() + " - "+
                    lista.get(i).getTelefono()+ " - " +
                    lista.get(i).getEdad()+ " - " +
                    lista.get(i).getCorreo()+ "- " +
                    lista.get(i).getDireccion());
        }
    }
}

