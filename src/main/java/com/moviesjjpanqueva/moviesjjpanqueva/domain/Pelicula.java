package com.moviesjjpanqueva.moviesjjpanqueva.domain;

public class Pelicula {

    private boolean paraAdultos;
    private String paginaWeb;
    private int id;
    private String nombre;
    private int minutosDuracion;

    public boolean isParaAdultos() {
        return paraAdultos;
    }

    public void setParaAdultos(boolean paraAdultos) {
        this.paraAdultos = paraAdultos;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMinutosDuracion() {
        return minutosDuracion;
    }

    public void setMinutosDuracion(int minutosDuracion) {
        this.minutosDuracion = minutosDuracion;
    }


}
