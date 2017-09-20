package com.hame.adelcid.materialdesign.Clases;

/**
 * Created by adelcid on 19/09/2017.
 */

public class ClaseImagen {
    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public ClaseImagen(String nombreImagen, int idImage) {
        this.nombreImagen = nombreImagen;
        this.idImage = idImage;
    }

    public String nombreImagen;
    public int idImage;





}
