package com.hame.adelcid.parcelable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.hame.adelcid.parcelable.objetos.Alumno;
import com.hame.adelcid.parcelable.objetos.Clase;
import android.util.Log;
import java.util.List;

public class Datos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        Clase clase = getIntent().getParcelableExtra("vaClaseU");
        Log.i("Parcelable", "Curso: " + clase.getNombre());
        Log.i("Parcelable", "Descripcion: " + clase.getNombre());

        List<Alumno> alumnosEnviados = clase.getListAlumno();

        for (int i = 0; i < alumnosEnviados.size(); i++) {
            Log.i("Alumon registrados: ", alumnosEnviados.get(i).getNombre() + " " + alumnosEnviados.get(i).getApellido());
        }
    }
}
