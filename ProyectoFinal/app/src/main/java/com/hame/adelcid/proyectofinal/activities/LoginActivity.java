package com.hame.adelcid.proyectofinal.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hame.adelcid.proyectofinal.R;
import com.hame.adelcid.proyectofinal.clases.UsuarioDB;

public class LoginActivity extends Activity {

    private EditText etUsuario;
    private EditText etContraseña;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniciaComponent();
    }

    public void iniciaComponent(){
        etUsuario = findViewById(R.id.et_Usuario);
        etContraseña = findViewById(R.id.et_Contraseña);
    }

    public void ingresoAplicacion(View view){
        context = this;
        UsuarioDB usuario = new UsuarioDB(context);
        //if (etUsuario.getText().toString().equals("Allan")&& etContraseña.getText().toString().equals("1")){
        if (usuario.confirmarUsuario(etUsuario.getText().toString(), etContraseña.getText().toString(),context)){
            Intent intent = new Intent(LoginActivity.this, ListadoIngresosActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this, getString(R.string.error_login  ) , Toast.LENGTH_LONG).show();
        }

    }
}
