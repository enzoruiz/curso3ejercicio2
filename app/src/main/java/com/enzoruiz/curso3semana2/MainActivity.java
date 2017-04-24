package com.enzoruiz.curso3semana2;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    private DatePicker dp;
    private int mes;
    private String mesFinal;
    private Button bSiguiente;
    private TextInputEditText tietNombre, tietTelefono, tietEmail, tietDescripcion;
    String [] arreglo = new String[5];
    String [] arregloRegreso = new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp              = (DatePicker) findViewById(R.id.dpFechaNacimiento);
        bSiguiente      = (Button) findViewById(R.id.bSiguiente);
        tietNombre      = (TextInputEditText) findViewById(R.id.tietNombre);
        tietTelefono    = (TextInputEditText) findViewById(R.id.tietTelefono);
        tietEmail       = (TextInputEditText) findViewById(R.id.tietEmail);
        tietDescripcion = (TextInputEditText) findViewById(R.id.tietDescripcion);

        Bundle bundle   = getIntent().getExtras();
        if(bundle != null) {
            arregloRegreso = bundle.getStringArray("dataRegreso");
            tietNombre.setText(arregloRegreso[0]);
            String [] date = arregloRegreso[1].split("/");

            // RESTAMOS 1 AL MES PARA QUE PUEDA MOSTRAR CORRECTAMENTE EL DATEPICKER
            dp.init(Integer.parseInt(date[2]), Integer.parseInt(date[1]) - 1, Integer.parseInt(date[0]), null);
            tietTelefono.setText(arregloRegreso[2]);
            tietEmail.setText(arregloRegreso[3]);
            tietDescripcion.setText(arregloRegreso[4]);
        }

        bSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SUMAMOS 1 PARA MOSTRAR EN DESCRIPCION ACTIVITY CORRECTAMENTE EL MES
                mes = dp.getMonth() + 1;
                mesFinal = String.valueOf(mes);
                if(mes < 10){
                    mesFinal = "0" + mes;
                }

                Intent intent = new Intent(MainActivity.this, DescripcionActivity.class);

                arreglo[0] = tietNombre.getText().toString();
                arreglo[1] = dp.getDayOfMonth() + "/" + mesFinal + "/" + dp.getYear();
                arreglo[2] = tietTelefono.getText().toString();
                arreglo[3] = tietEmail.getText().toString();
                arreglo[4] = tietDescripcion.getText().toString();

                intent.putExtra("data", arreglo);

                startActivity(intent);
                finish();
            }
        });

    }
}
