package com.hame.adelcid.parcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.hame.adelcid.parcelable.objetos.Alumno;
import com.hame.adelcid.parcelable.objetos.Clase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Clase claseU = new Clase();
        claseU.setNombre("Hame");
        claseU.setDescripcion("Clase curso Android");

        Alumno alumnoClase = new Alumno("Allan","Del Cid");
        List<Alumno> listAlumno = new ArrayList<>();
        listAlumno.add(alumnoClase);
        alumnoClase = new Alumno("Jose","Caal");
        listAlumno.add(alumnoClase);
        claseU.setListAlumno(listAlumno);

        Intent intent = new Intent(this, Datos.class);
        intent.putExtra("vaClaseU", claseU);
        startActivity(intent);

        finish();
    }

}
