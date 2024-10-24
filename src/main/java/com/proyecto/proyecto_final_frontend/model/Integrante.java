package com.proyecto.proyecto_final_frontend.model;

public class Integrante {

    private String nombre;
    private String apellido;

    public Integrante(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}