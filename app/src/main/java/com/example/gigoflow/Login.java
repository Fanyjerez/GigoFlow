package com.example.gigoflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    private EditText txtNombre,txtEmail, txtInfo;
    private Button btnGuardar;
    private Spinner cbxPreferencias;
    private RadioButton rbCompleto, rbMedioTiempo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtEmail =(EditText) findViewById(R.id.txtEmail);
        txtInfo = (EditText) findViewById(R.id.txtInfo);
        cbxPreferencias = (Spinner) findViewById(R.id.cbxPreferencias);
        rbCompleto = (RadioButton) findViewById(R.id.rbCompleto);
        rbMedioTiempo = (RadioButton) findViewById(R.id.rbMedioTiempo);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNombre.getText().toString().isEmpty() || txtEmail.getText().toString().isEmpty()) {
                    Toast.makeText(Login.this, "Debe agregar los datos solicitados", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(Login.this, Guardar.class);
                        intent.putExtra("txtNombre", txtNombre.getText().toString());
                        intent.putExtra("txtEmail",txtEmail.getText().toString());
                        intent.putExtra("txtInfo", txtInfo.getText().toString());
                        intent.putExtra("cbxPreferencias", cbxPreferencias.getSelectedItem().toString());
                        String horario = "";
                        if (rbCompleto.isChecked()){
                            horario = "Efectivo";

                        } else {
                            horario = "Transferencia";

                        }
                        intent.putExtra("tiempo",horario);
                        startActivity(intent);
                }

            }
        });
    }
}