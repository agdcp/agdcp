package com.hame.adelcid.proyectofinal.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.hame.adelcid.proyectofinal.R;
import com.hame.adelcid.proyectofinal.clases.ClienteDB;
import com.hame.adelcid.proyectofinal.clases.UsuarioDB;

public class MainActivity extends Activity {

    private Handler handler;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        handler.postDelayed(receivedRunable, 5000);

    }

    private Runnable receivedRunable = new Runnable() {
        @Override
        public void run() {
            startReceivedInfo();
        }
    };

    private void startReceivedInfo() {
        crearUsuario();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void crearUsuario() {

        context = this;
        UsuarioDB usuario = new UsuarioDB(context);

        if (!usuario.confirmarUsuario("Allan", "1", context)) {
            usuario.setNombre("Allan");
            usuario.setContraseña("1");
            usuario.insertar(context);
        }
    }
}
