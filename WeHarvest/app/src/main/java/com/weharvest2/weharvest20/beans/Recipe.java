package com.weharvest2.weharvest20.beans;

/**
 * Created by fernando on 22/11/17.
 */

public class Recipe {
    private String username;
    private String titulo;
    private String contenido;
    private String fecha;
    private String categoria;

    public Recipe() {

    }

    public Recipe(String username, String titulo, String contenido, String fecha, String categoria) {
        this.username = username;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
        this.categoria = categoria;
    }


    public String getUser() {
        return username;
    }

    public void setUser(String username) {
        this.username = username;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
