package com.hame.adelcid.parcelable.objetos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by adelcid on 6/09/2017.
 */

//public class Alumno {
//    public String apellido;
//    public String nombre;
//}

public class Alumno implements Parcelable {

    public String apellido;

    public String nombre;

    public Alumno (){
        new Alumno();
    }

    public Alumno(String apellido, String nombre) {
        this.apellido = apellido;
        this.nombre = nombre;
    }

    protected Alumno(Parcel in) {
        apellido = in.readString();
        nombre = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(apellido);
        dest.writeString(nombre);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Alumno> CREATOR = new Parcelable.Creator<Alumno>() {
        @Override
        public Alumno createFromParcel(Parcel in) {
            return new Alumno(in);
        }

        @Override
        public Alumno[] newArray(int size) {
            return new Alumno[size];
        }
    };

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}