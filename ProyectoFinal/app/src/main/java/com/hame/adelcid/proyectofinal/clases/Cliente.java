package com.hame.adelcid.proyectofinal.clases;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by adelcid on 28/09/2017.
 */
public class Cliente implements Parcelable {



    private int id;
    private String imagen;
    private String cliente;
    private String direccion;
    private String nit;
    private String telefono;
    private String correo;
    private String cordenadaX;
    private String cordenadaY;

    public Cliente(int id, String imagen, String cliente, String direccion, String nit, String telefono, String correo, String cordenadaX, String cordenadaY) {
        this.id = id;
        this.imagen = imagen;
        this.cliente = cliente;
        this.direccion = direccion;
        this.nit = nit;
        this.telefono = telefono;
        this.correo = correo;
        this.cordenadaX = cordenadaX;
        this.cordenadaY = cordenadaY;
    }

    public Cliente() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCordenadaX() {
        return cordenadaX;
    }

    public void setCordenadaX(String cordenadaX) {
        this.cordenadaX = cordenadaX;
    }

    public String getCordenadaY() {
        return cordenadaY;
    }

    public void setCordenadaY(String cordenadaY) {
        this.cordenadaY = cordenadaY;
    }

    protected Cliente(Parcel in) {
        id = in.readInt();
        imagen = in.readString();
        cliente = in.readString();
        direccion = in.readString();
        nit = in.readString();
        telefono = in.readString();
        correo = in.readString();
        cordenadaX = in.readString();
        cordenadaY = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(imagen);
        dest.writeString(cliente);
        dest.writeString(direccion);
        dest.writeString(nit);
        dest.writeString(telefono);
        dest.writeString(correo);
        dest.writeString(cordenadaX);
        dest.writeString(cordenadaY);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Cliente> CREATOR = new Parcelable.Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel in) {
            return new Cliente(in);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };
}
