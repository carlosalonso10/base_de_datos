package com.example.base_de_datos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ActivityFoto extends AppCompatActivity {
      static final int peticion_camara = 100;
      static final int peticion_foto = 102;

      String FotoPath;
      ImageView imageView;

      Button btntakefoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        imageView = (ImageView) findViewById(R.id.imageView);
        btntakefoto = (Button) finishAndRemoveTask(R.id.btntakefoto);

        btntakefoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permisos();
            }
        });

    }
    private void Permisos()
    {
        if (ContextCompat.chekSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
        != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new  String[]{Manifest.permission.CAMERA},
                    peticion_camara);


        }
        else
        {
            tomarfoto();
        }
    }
    private void tomarfoto()
    {

    }
}