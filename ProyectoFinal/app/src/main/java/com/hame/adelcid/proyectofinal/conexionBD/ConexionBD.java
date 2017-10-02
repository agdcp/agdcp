package com.hame.adelcid.proyectofinal.conexionBD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by adelcid on 1/10/2017.
 */

public class ConexionBD extends SQLiteOpenHelper {

    private SQLiteDatabase mdb;
    public static final String nombreBD = "Proyecto Final.db";

    public static final int versionBD = 1;
    private static final String text_type = " TEXT ";
    private static final String int_type = " INTEGER ";
    private static final String coma = " , ";
    private static final String llave_primaria = " PRIMARY KEY AUTOINCREMENT ";

    //Tabla Cliente
    public static final String tbCliente = "Cliente";
    public static final String idCliente = "Id";
    public static final String imagenCliente = "Imagen";
    public static final String nombreCliente = "Cliente";
    public static final String direccionCliente = "Direccion";
    public static final String nitCliente = "Nit";
    public static final String telefonoCliente = "Telefono";
    public static final String correoCliente = "Correo";
    public static final String cordenadaXCliente = "CordenadaX";
    public static final String cordenadaYCliente = "cordenadaY";

    //Tabla Imagen

    public static final String tbImagen = "Imagen";
    public static final String idImagen = "Id";
    public static final String imagenImagen = "Imagen";
    public static final String srcImagen = "Src";

    //Tabla Usuario
    public static final String tbUsuario = " Usuario";
    public static final String idUsuario = " Id";
    public static final String nombreUsuario = " Nombre";
    public static final String contraseñaUsuario = " Contraseña";


    public static final String createTablaCliente = "Create table " + tbCliente + "("
            + idCliente + int_type + llave_primaria + coma
            + imagenCliente + text_type + coma
            + nombreCliente + text_type + coma
            + direccionCliente + text_type + coma
            + nitCliente + text_type + coma
            + telefonoCliente + text_type + coma
            + correoCliente + text_type + coma
            + cordenadaXCliente + text_type + coma
            + cordenadaYCliente + text_type
            + ");";

    public static final String createTablaImagen = "Create table " + tbImagen + "("
            + idImagen + int_type + llave_primaria + coma
            + imagenImagen + text_type + coma
            + srcImagen + text_type
            + ");";

    public static final String createTablaUsuario = "Create table " + tbUsuario + "("
            + idUsuario + int_type + llave_primaria + coma
            + nombreUsuario + text_type + coma +
            contraseñaUsuario + text_type
            + ");";

    public ConexionBD(Context context) {
        super(context, nombreBD, null, versionBD);
    }

    public void openReadTable() {
        mdb = this.getReadableDatabase();
    }

    public void openWriteTable() {
        mdb = this.getWritableDatabase();
    }

    public void FvConexion() {
        if (mdb != null) {
            mdb.close();
        }
    }

    @Override
    public void onOpen(SQLiteDatabase sqldb) {
        super.onOpen(sqldb);
        if (!sqldb.isReadOnly()) {
            sqldb.execSQL("PRAGMA foreing_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("query", createTablaCliente);
        sqLiteDatabase.execSQL(createTablaCliente);
        Log.e("query", createTablaImagen);
        sqLiteDatabase.execSQL(createTablaImagen);
        Log.e("query", createTablaUsuario);
        sqLiteDatabase.execSQL(createTablaUsuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
