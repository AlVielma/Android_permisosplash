package com.example.practica9_permisosplash.Models;

public class Permisos {
    private String nombre;
    private String descripcion;

    private boolean isGranted;


    public Permisos(String nombre, String descripcion, boolean isGranted) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.isGranted = isGranted;
    }

    public boolean isGranted() {
        return isGranted;
    }

    public void setGranted(boolean granted) {
        isGranted = granted;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
