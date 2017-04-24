package com.enzoruiz.curso3semana2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DescripcionActivity extends AppCompatActivity {

    Button bEditar;
    TextView tvNombre, tvFechaNacimiento, tvTelefono, tvEmail, tvDescripcion;
    String [] arreglo = new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        bEditar             = (Button) findViewById(R.id.bEditar);
        tvNombre            = (TextView) findViewById(R.id.tvNombre);
        tvFechaNacimiento   = (TextView) findViewById(R.id.tvFechaNacimiento);
        tvTelefono          = (TextView) findViewById(R.id.tvTelefono);
        tvEmail             = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion       = (TextView) findViewById(R.id.tvDescripcion);

        Bundle bundle       = getIntent().getExtras();

        arreglo             = bundle.getStringArray("data");
        tvNombre.setText(getResources().getString(R.string.default_nombre) + ": " + arreglo[0]);
        tvFechaNacimiento.setText(getResources().getString(R.string.default_fechaNacimiento) + ": " + arreglo[1]);
        tvTelefono.setText(getResources().getString(R.string.default_telefono) + ": " + arreglo[2]);
        tvEmail.setText(getResources().getString(R.string.default_email) + ": " + arreglo[3]);
        tvDescripcion.setText(getResources().getString(R.string.default_descripcion) + ": " + arreglo[4]);

        bEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DescripcionActivity.this, MainActivity.class);

                String [] arregloRegreso = new String[5];
                arregloRegreso[0] = arreglo[0];
                arregloRegreso[1] = arreglo[1];
                arregloRegreso[2] = arreglo[2];
                arregloRegreso[3] = arreglo[3];
                arregloRegreso[4] = arreglo[4];
                intent.putExtra("dataRegreso", arregloRegreso);

                startActivity(intent);
                finish();
            }
        });

    }



}
