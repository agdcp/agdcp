package com.hame.adelcid.proyectofinal.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hame.adelcid.proyectofinal.R;
import com.hame.adelcid.proyectofinal.clases.Cliente;
import com.hame.adelcid.proyectofinal.clases.ClienteDB;

public class IngresoClienteActivity extends AppCompatActivity {

    public EditText etNombrCliente;
    public EditText etDireccion;
    public EditText etNIT;
    public EditText etTelefono;
    public EditText etCorreo;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String idCliente = getIntent().getStringExtra("IdCliente");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                envioInformacionImagen();

            }
        });

        iniciaComponent();
        cargaInfomracion(idCliente);
    }

    public void iniciaComponent() {

        etNombrCliente = (EditText) findViewById(R.id.et_nombre_cliente);
        etDireccion = (EditText) findViewById(R.id.et_direccion);
        etNIT = (EditText) findViewById(R.id.et_nit);
        etTelefono = (EditText) findViewById(R.id.et_telefono);
        etCorreo = (EditText) findViewById(R.id.et_correo);


    }

    public void cargaInfomracion(String idCliente) {
        if (idCliente.toString().equals("-")){

        }else  {
            context = this;
            Cliente cliente = new Cliente();
            ClienteDB clienteDB = new ClienteDB(context);
            cliente = clienteDB.obtenerCliente(idCliente);
            etNombrCliente.setText(cliente.getCliente());
            etDireccion.setText(cliente.getDireccion());
            etNIT.setText(cliente.getNit());
            etTelefono.setText(cliente.getTelefono());
            etCorreo.setText(cliente.getCorreo());
        }



    }

    public void envioInformacionImagen() {

        Cliente cliente = new Cliente(0, "imagen", etNombrCliente.getText().toString(),
                etDireccion.getText().toString(), etNIT.getText().toString(),
                etTelefono.getText().toString(), etCorreo.getText().toString(),
                "000000000", "0000000000");

        Intent intent = new Intent(IngresoClienteActivity.this, ListaImagenesActivity.class);
        intent.putExtra("cliente", cliente);
        startActivity(intent);
    }
}
