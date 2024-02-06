package com.example.base_de_datos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Configuracion.SQLiteconexion;
import Configuracion.Transacciones;

public class MainActivityActualizar extends AppCompatActivity {



        SQLiteconexion conexion;
        EditText id,nombres,apellidos,telefono,edad,correo,direccion;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_actualizar);

            // llamar a la conexión de bd
            conexion = new SQLiteconexion(this, Transacciones.DBname, null, 1);

            //Area de Botones
            Button btnbuscar = (Button) findViewById (R.id.btnbuscar);
            Button btneliminar = (Button) findViewById (R .id.btneliminar);
            Button btnactualizar = (Button) findViewById (R.id.btnactualizar);

            id = (EditText) findViewById (R.id.id);
            nombres = (EditText) findViewById (R.id.nom);
            apellidos = (EditText) findViewById (R.id.apelli);
            telefono = (EditText) findViewById(R.id.telef);
            edad = (EditText) findViewById (R.id.eda);
            correo = (EditText) findViewById (R.id.correos);
            direccion = (EditText) findViewById (R.id.direcciones);

            btnbuscar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    buscar();
                }
            });

            btnactualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Actualizar();
                }
            });

            btneliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Eliminar();
                }
            });
        }
        private void buscar()
        {
            SQLiteDatabase db = conexion.getWritableDatabase();
            //Configuracion de la sentencia SELECT
            String [] params = {id.getText (). toString()}; //parametro de la busqueda
            String [] fields = {Transacciones.nombres,
                    Transacciones.apellidos,
                    Transacciones.telefono,
                    Transacciones.edad,
                    Transacciones.correo,
                    Transacciones.direccion};
            String wherecond = Transacciones.id + "=?";

            try {
                Cursor cdata = db.query (Transacciones .Tablepersonas, fields, wherecond, params,null,null,null);

                cdata.moveToFirst ();
                nombres.setText (cdata.getString (0));
                apellidos.setText (cdata.getString (1));
                telefono.setText(cdata.getString(2));
                edad.setText (cdata.getString (3));
                correo.setText ( cdata.getString (4));
                direccion.setText ( cdata.getString (5));


                Toast.makeText (getApplicationContext (), "Busqueda realizada con exito", Toast.LENGTH_LONG) .show ();
            }

            catch (Exception ex)
            {
                ClearScreen ();
                Toast.makeText(getApplicationContext(),"Registro no encontrado", Toast.LENGTH_LONG).show();
            }
        }
        private void Eliminar()
        {
            SQLiteDatabase db = conexion.getWritableDatabase();

            String [] params = {id.getText (). toString ()};
            String wherecond = Transacciones.id + "=?";
            db.delete (Transacciones.Tablepersonas, wherecond, params) ;
            Toast.makeText (getApplicationContext (), "Dato eliminado", Toast.LENGTH_LONG) .show ();
            ClearScreen ();
        }


        private void Actualizar()
        {
            SQLiteDatabase db = conexion.getWritableDatabase ();

            String [] params = {id.getText (). toString ()};
            ContentValues valores = new ContentValues();

            valores.put (Transacciones.nombres, nombres.getText (). toString ( ));
            valores.put (Transacciones.apellidos, apellidos.getText (). toString ());
            valores.put (Transacciones.edad, edad.getText (). toString ());
            valores.put (Transacciones.correo, correo .getText (). toString ());
            valores.put (Transacciones.direccion, direccion.getText (). toString ( ));

            db.update (Transacciones.Tablepersonas, valores, Transacciones.id + "=?", params);
            Toast.makeText (getApplicationContext (), "Dato actualizado", Toast.LENGTH_LONG).show();
            ClearScreen ();
        }



    private void ClearScreen() {
        nombres.setText("");
        apellidos.setText("");
        telefono.setText("");
        edad.setText("");
        correo.setText("");
        direccion.setText("");
    }
}
