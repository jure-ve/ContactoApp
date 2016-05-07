package com.jure.contactoapp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  {

    private SimpleDateFormat dateFormatter;
    private EditText input_fecha;
    private DatePickerDialog inputDatePickerDialog;
    private  Button button_siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        Calendar newCalendar = Calendar.getInstance();
        //
        // Inicializa el dialogo  DatePicker
        //
        inputDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                input_fecha.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        inputDatePickerDialog.setTitle(getResources().getString(R.string.hint_fecha));

        input_fecha = (EditText) findViewById(R.id.input_fecha);

        input_fecha.setInputType(InputType.TYPE_NULL);
        //
        //  Redefinimos el evento Onfocus de input_fecha
        //
        input_fecha.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                //
                // Cierra el softkeyboart si está abierto
                //
                if(hasFocus) {
                    InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    }
                    //
                    // Abre el Dialogo con el DatePicker
                    //
                    inputDatePickerDialog.show();
                }
            }
        });

        button_siguiente = (Button)findViewById(R.id.button_siguiente);
        //
        // Define el OnClick en el Boton
        //
        button_siguiente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //
                // Define en intent
                //
                Intent intent = new Intent(MainActivity.this, ConfirmacionActivity.class);

                EditText input_nombre = (EditText) findViewById(R.id.input_nombre);
                EditText input_fecha = (EditText) findViewById(R.id.input_fecha);
                EditText input_telefono = (EditText) findViewById(R.id.input_telefono);
                EditText input_correo = (EditText) findViewById(R.id.input_correo);
                EditText input_descripcion = (EditText) findViewById(R.id.input_descripcion);
                //
                // Extrae los textos de los EditText y coloca como extra en el intent
                //
                intent.putExtra("nombre", input_nombre.getText().toString());
                intent.putExtra("fecha", input_fecha.getText().toString());
                intent.putExtra("telefono", input_telefono.getText().toString());
                intent.putExtra("correo", input_correo.getText().toString());
                intent.putExtra("descripcion", input_descripcion.getText().toString());
                //
                // Inicia la siguiente actividad
                //
                startActivity(intent);
            }

        });

    }
}
