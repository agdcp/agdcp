package com.hame.adelcid.proyectofinal.clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hame.adelcid.proyectofinal.conexionBD.ConexionBD;

import java.util.ArrayList;

/**
 * Created by adelcid on 1/10/2017.
 */

public class ClienteDB {

    private int id;
    private String imagen;
    private String cliente;
    private String direccion;
    private String nit;
    private String telefono;
    private String correo;
    private String cordenadaX;
    private String cordenadaY;

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

    public ClienteDB(int id, String imagen, String cliente, String direccion, String nit, String telefono, String correo, String cordenadaX, String cordenadaY) {
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

    private ConexionBD cn;
    private SQLiteDatabase db;

    public ClienteDB(int id, String imagen, String cliente, String direccion, String nit, String telefono, String correo, String cordenadaX, String cordenadaY, Context context) {
        this.id = id;
        this.imagen = imagen;
        this.cliente = cliente;
        this.direccion = direccion;
        this.nit = nit;
        this.telefono = telefono;
        this.correo = correo;
        this.cordenadaX = cordenadaX;
        this.cordenadaY = cordenadaY;
        cn = new ConexionBD(context);
    }

    public ClienteDB(Context pContext) {
        cn = new ConexionBD(pContext);
    }

    public ContentValues obtenerValores(String pTipoMetodo, Context pContext) {

        ContentValues valor = new ContentValues();
        if (pTipoMetodo.compareToIgnoreCase("Insertar") == 0) {
            //valor.put(ConexionBD.idCliente, getId());
        } else {
            //valor.put(ConexionBD.idCliente, getId());
        }
        valor.put(ConexionBD.nombreCliente, getCliente());
        valor.put(ConexionBD.direccionCliente, getDireccion());
        valor.put(ConexionBD.nitCliente, getNit());
        valor.put(ConexionBD.telefonoCliente, getTelefono());
        valor.put(ConexionBD.correoCliente, getCorreo());
        valor.put(ConexionBD.cordenadaXCliente, getCordenadaX());
        valor.put(ConexionBD.cordenadaYCliente, getCordenadaY());
        return valor;
    }

    public void insertar(Context pContext) {
        db = cn.getWritableDatabase();
        db.insert(ConexionBD.tbCliente, null, obtenerValores("Insertar", pContext));
    }

    public void actualizar(Context pContext) {

        db = cn.getWritableDatabase();
        db.update(ConexionBD.tbCliente, obtenerValores("Actualizar", pContext), "id=" + getId(), null);
    }

    public void eliminar(int pIdCliente) {
        db = cn.getWritableDatabase();
        db.delete(ConexionBD.tbCliente, "id=" + pIdCliente, null);
    }

    public Cursor obtener() {

        db = cn.getReadableDatabase();
        Cursor cQuery = db.query(cn.tbCliente, null, null, null, null, null, null);
        if (cQuery.moveToFirst()) {
            return cQuery;
        }
        return null;

    }

    public ArrayList<Cliente> obtenerListaCliente() {

        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        db = cn.getReadableDatabase();

        Cursor cQuery = db.query(cn.tbCliente, null, null, null, null, null, null);
        Cliente cliente;

        if (cQuery.moveToFirst())
        {
            do {
                cliente = new Cliente();
                cliente.setId(cQuery.getInt(0));
                cliente.setImagen(cQuery.getString(1));
                cliente.setCliente(cQuery.getString(2));
                cliente.setDireccion(cQuery.getString(3));
                cliente.setNit(cQuery.getString(4));
                cliente.setTelefono(cQuery.getString(5));
                cliente.setCorreo(cQuery.getString(6));
                cliente.setCordenadaX(cQuery.getString(7));
                cliente.setCordenadaY(cQuery.getString(8));
                listaCliente.add(cliente);
            }
            while (cQuery.moveToNext());

            cQuery.close();

        }
        return listaCliente;
    }

    public Cliente obtenerCliente(String pIdCliente) {

        Cliente cliente = new Cliente();
        db = cn.getReadableDatabase();
        Cursor cQuery = db.query(cn.tbCliente, null, "id=" + pIdCliente, null, null, null, null);
        if (cQuery.moveToFirst()) {

            cliente = new Cliente();
            cliente.setId(cQuery.getInt(0));
            cliente.setImagen(cQuery.getString(1));
            cliente.setCliente(cQuery.getString(2));
            cliente.setDireccion(cQuery.getString(3));
            cliente.setNit(cQuery.getString(4));
            cliente.setTelefono(cQuery.getString(5));
            cliente.setCorreo(cQuery.getString(6));
            cliente.setCordenadaX(cQuery.getString(7));
            cliente.setCordenadaY(cQuery.getString(8));
            return cliente;
        }
        return null;

    }

}
