package com.hame.adelcid.proyectofinal.clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hame.adelcid.proyectofinal.conexionBD.ConexionBD;

/**
 * Created by adelcid on 1/10/2017.
 */

public class UsuarioDB {

    public String id;
    public String Nombre;
    public String Contraseña;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public UsuarioDB(String nombre, String contraseña) {
        Nombre = nombre;
        Contraseña = contraseña;
    }

    private ConexionBD cn;
    private SQLiteDatabase db;


    public UsuarioDB(Context pContext) {
        cn = new ConexionBD(pContext);
    }

    public ContentValues obtenerValores(String pTipoMetodo, Context pContext) {

        ContentValues valor = new ContentValues();
        //if (pTipoMetodo.compareToIgnoreCase("Insertar") == 0) {
        //    valor.put(ConexionBD.idUsuario, getId());
        //} else {
        //   valor.put(ConexionBD.idUsuario, getId());
        //}
        valor.put(ConexionBD.nombreUsuario, getNombre());
        valor.put(ConexionBD.contraseñaUsuario, getContraseña());

        return valor;
    }

    public void insertar(Context pContext) {
        db = cn.getWritableDatabase();
        db.insert(ConexionBD.tbUsuario, null, obtenerValores("Insertar", pContext));
    }

    public void actualizar(Context pContext) {

        db = cn.getWritableDatabase();
        db.update(ConexionBD.tbUsuario, obtenerValores("Actualizar", pContext), "id=" + getId(), null);
    }

    public void eliminar(int pIdUsuario) {
        db = cn.getWritableDatabase();
        db.delete(ConexionBD.tbUsuario, "id=" + pIdUsuario, null);
    }

    public Cursor obtener() {

        db = cn.getReadableDatabase();
        Cursor cQuery = db.query(cn.tbUsuario, null, null, null, null, null, null);
        if (cQuery.moveToFirst()) {
            return cQuery;
        }
        return null;

    }

    public Cursor obtener(int pIdUsuario) {

        db = cn.getReadableDatabase();
        Cursor cQuery = db.query(cn.tbUsuario, null, "id=" + pIdUsuario, null, null, null, null);
        if (cQuery.moveToFirst()) {
            return cQuery;
        }
        return null;

    }

    public boolean confirmarUsuario(String pUsuario, String pContraseña, Context context) {

        db = cn.getReadableDatabase();
        String WHERE = cn.nombreUsuario.replace(" ", "") + "=? and " + cn.contraseñaUsuario.replace(" ", "") + "=?";
        String[] whereArgs = {pUsuario, pContraseña};
        Cursor cQuery = db.query(cn.tbUsuario, null, WHERE, whereArgs, null, null, null);
        if (cQuery.moveToFirst()) {
            return true;
        }
        return false;
    }

}
