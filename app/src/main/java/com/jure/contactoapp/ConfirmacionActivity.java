package com.jure.contactoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConfirmacionActivity extends AppCompatActivity {

    private Button boton_confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //
            // Extrae los datos
            //
            String nombre = extras.getString("nombre","Sin Datos");
            String fecha = extras.getString("fecha","Sin Datos");
            String telefono = extras.getString("telefono","Sin Datos");
            String correo = extras.getString("correo","Sin Datos");
            String descripcion = extras.getString("descripcion","Sin Datos");

            TextView datosNombre      = (TextView) findViewById(R.id.datos_nombre);
            TextView datosFecha       = (TextView) findViewById(R.id.datos_fecha);
            TextView datosTelefono    = (TextView) findViewById(R.id.datos_telefono);
            TextView datosCorreo      = (TextView) findViewById(R.id.datos_correo);
            TextView datosDescripcion = (TextView) findViewById(R.id.datos_descriptcion);
            //
            // Asigna los textos a los TextView
            //
            datosNombre.setText(nombre);
            datosFecha.setText(fecha);
            datosTelefono.setText(telefono);
            datosCorreo.setText(correo);
            datosDescripcion.setText(descripcion);

        }
        boton_confirmar = (Button)findViewById(R.id.boton_confirmar);

        boton_confirmar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }

        });

    }
}
