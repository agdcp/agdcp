package com.hame.adelcid.proyectofinal.clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hame.adelcid.proyectofinal.conexionBD.ConexionBD;

/**
 * Created by adelcid on 1/10/2017.
 */

public class ImagenDB {

    private int id;
    private String imagen;
    private String src;


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

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public ImagenDB(int id, String imagen, String src) {
        this.id = id;
        this.imagen = imagen;
        this.src = src;
    }

    private ConexionBD cn;
    private SQLiteDatabase db;

    public ImagenDB(int id, String imagen, String src, Context context) {
        this.id = id;
        this.imagen = imagen;
        this.src = src;
        cn = new ConexionBD(context);

    }

    public ImagenDB(Context pContext) {
        cn = new ConexionBD(pContext);
    }

    public ContentValues obtenerValores(String pTipoMetodo, Context pContext) {

        ContentValues valor = new ContentValues();
        if (pTipoMetodo.compareToIgnoreCase("Insertar") == 0) {
            valor.put(ConexionBD.idImagen, getId());
        } else {
            valor.put(ConexionBD.idImagen, getId());
        }
        valor.put(ConexionBD.imagenImagen, getImagen());
        valor.put(ConexionBD.srcImagen, getSrc());

        return valor;
    }

    public void insertar(Context pContext) {
        db = cn.getWritableDatabase();
        db.insert(ConexionBD.tbImagen, null, obtenerValores("Insertar", pContext));
    }

    public void actualizar(Context pContext) {

        db = cn.getWritableDatabase();
        db.update(ConexionBD.tbImagen, obtenerValores("Actualizar", pContext), "id=" + getId(), null);
    }

    public void eliminar(int pIdImagen) {
        db = cn.getWritableDatabase();
        db.delete(ConexionBD.tbImagen, "id=" + pIdImagen, null);
    }

    public Cursor obtener() {

        db = cn.getReadableDatabase();
        Cursor cQuery = db.query(cn.tbImagen, null, null, null, null, null, null);
        if (cQuery.moveToFirst()) {
            return cQuery;
        }
        return null;

    }

    public Cursor obtener(int pIdImagen) {

        db = cn.getReadableDatabase();
        Cursor cQuery = db.query(cn.tbImagen, null, "id=" + pIdImagen, null, null, null, null);
        if (cQuery.moveToFirst()) {
            return cQuery;
        }
        return null;

    }


}

