package com.eskere.tpo3.model;

import java.io.Serializable;

// serializable para poder pasar el objeto entre activities con un un Intent
public class Libro implements Serializable {
    private String titulo;
    private String autor;
    private String descripcion;
    private int imagenResId; // R.drawable
    private int anio;
    public Libro(String titulo, String autor, String descripcion, int imagenResId, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
        this.imagenResId = imagenResId;
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagenResId() {
        return imagenResId;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }



    public void setImagenResId(int imagenResId) {
        this.imagenResId = imagenResId;
    }
}