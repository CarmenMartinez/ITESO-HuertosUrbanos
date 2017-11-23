package com.weharvest2.weharvest20.beans;

/**
 * Created by fernando on 22/11/17.
 */

public class Post {
    private User user;
    private String titulo;
    private String contenido;
    private String fecha;
    private String categoria;

    public Post() {

    }

    public Post(User user, String titulo, String contenido, String fecha, String categoria) {
        this.user = user;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
        this.categoria = categoria;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
