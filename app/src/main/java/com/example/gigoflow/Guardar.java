package com.example.gigoflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Guardar extends AppCompatActivity {


    private TextView txtNombre;
    private TextView txtView;
    private Bundle bundle;
    Button siguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar);
        txtNombre = (TextView) findViewById(R.id.txtNombreDos);
        txtView = (TextView) findViewById(R.id.textView);



        bundle = getIntent().getExtras();

        String nombre = bundle.getString("txtNombre");
        String datos = "Email:" + bundle.getString("txtEmail") + "\nInfo:" + bundle.getString("txtInfo") + "\nPreferencias:" + bundle.getString("cbxPreferencias") + "\nHorario:" + bundle.getString("tiempo");
        txtNombre.setText(nombre);
        txtView.setText(datos);
        siguiente=(Button)findViewById(R.id.button2);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent( Guardar.this, Contactos.class);
                startActivity(i);
            }
        });

        }
}

