package com.hame.adelcid.proyectofinal.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hame.adelcid.proyectofinal.R;
import com.hame.adelcid.proyectofinal.clases.Cliente;
import com.hame.adelcid.proyectofinal.clases.ClienteDB;
import com.hame.adelcid.proyectofinal.clases.UsuarioDB;

public class ListaImagenesActivity extends AppCompatActivity {

    private Context context;
    private Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_imagenes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cliente = getIntent().getParcelableExtra("cliente");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void salir(View view) {
        this.finish();
    }

    public void guardar(View view) {
        context = this;
        ClienteDB clienteDB = new ClienteDB(context);

        clienteDB.setId(cliente.getId());
        clienteDB.setCliente(cliente.getCliente());
        clienteDB.setDireccion(cliente.getDireccion());
        clienteDB.setTelefono(cliente.getTelefono());
        clienteDB.setCorreo(cliente.getCorreo());
        clienteDB.setNit(cliente.getNit());
        clienteDB.setCordenadaX(cliente.getCordenadaX());
        clienteDB.setCordenadaY(cliente.getCordenadaY());
        clienteDB.insertar(context);
        this.finish();


    }
}



