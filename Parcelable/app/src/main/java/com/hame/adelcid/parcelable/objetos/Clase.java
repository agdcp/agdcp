package com.hame.adelcid.parcelable.objetos;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by adelcid on 6/09/2017.
 */

//public class Clase {
//    public String nombre;
//    public String descripcion;
//    public List<Alumno> listAlumno;
//}

public class Clase implements Parcelable {

    public String nombre;
    public String descripcion;
    public List<Alumno> listAlumno;

    public Clase(){

    }

    public Clase(String nombre, String descripcion, List<Alumno> listAlumno) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listAlumno = listAlumno;

    }

    protected Clase(Parcel in) {
        nombre = in.readString();
        descripcion = in.readString();
        if (in.readByte() == 0x01) {
            listAlumno = new ArrayList<Alumno>();
            in.readList(listAlumno, Alumno.class.getClassLoader());
        } else {
            listAlumno = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(descripcion);
        if (listAlumno == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(listAlumno);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Clase> CREATOR = new Parcelable.Creator<Clase>() {
        @Override
        public Clase createFromParcel(Parcel in) {
            return new Clase(in);
        }

        @Override
        public Clase[] newArray(int size) {
            return new Clase[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Alumno> getListAlumno() {
        return listAlumno;
    }

    public void setListAlumno(List<Alumno> listAlumno) {
        this.listAlumno = listAlumno;
    }
}