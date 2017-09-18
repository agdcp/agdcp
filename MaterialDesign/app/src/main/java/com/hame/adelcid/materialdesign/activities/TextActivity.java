package com.hame.adelcid.materialdesign.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hame.adelcid.materialdesign.R;

public class TextActivity extends AppCompatActivity {

    private EditText etIngresado;
    private TextView tvMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        initComponentes();
    }

    private void initComponentes() {
        etIngresado = (EditText) findViewById(R.id.ed_insert_text);
        tvMostrar = (TextView) findViewById(R.id.tv_result);

    }

    public void readText(View view) {
        String texto = etIngresado.getText().toString();
        if ((texto != null) && (!texto.trim().isEmpty())) {
            tvMostrar.setText(texto);
        } else {
            tvMostrar.setText("");
            Toast.makeText(this, getString(R.string.msj_empty_text), Toast.LENGTH_LONG).show();
        }
    }

}
