package com.hame.adelcid.proyectofinal.activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hame.adelcid.proyectofinal.R;
import com.hame.adelcid.proyectofinal.adapters.ItemAdapterCliente;
import com.hame.adelcid.proyectofinal.clases.Cliente;
import com.hame.adelcid.proyectofinal.clases.ClienteDB;
import com.hame.adelcid.proyectofinal.holders.ItemHolderCliente;

import java.util.ArrayList;

public class ListadoIngresosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapterCliente itemAdapter;
    private Context context;
    private ArrayList<Cliente> claseCliente ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_ingresos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                trasladoPantalla("-");

            }
        });
        initComponents();
    }


    private void initComponents() {
        context = this;
        //Cliente cliente = new Cliente(1,"imagen","Allan","Guatemala", "123455-8","30172823","adelcid@gmail.com","000000000","0000000000");
        claseCliente = new ArrayList<>();
        //claseCliente.add(cliente);
        //cliente = new Cliente(2,"imagen","Luis","Guatemala", "1234567-8","50152853", "ldelcid@olmeca.com.gt","000000000","0000000000");
        //claseCliente.add(cliente);

        ClienteDB clienteDB = new ClienteDB(context);
        claseCliente  =  clienteDB.obtenerListaCliente();


        recyclerView = (RecyclerView) findViewById(R.id.lv_clientes);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        itemAdapter = new ItemAdapterCliente(context, claseCliente);
        recyclerView.setAdapter(itemAdapter);
    }

    public void trasladoPantalla(String idCliente){
        Intent intent = new Intent(ListadoIngresosActivity.this,IngresoClienteActivity.class);
        intent.putExtra("IdCliente",idCliente);
        startActivity(intent);
    }
}
