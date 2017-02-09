package com.gmbdesign.modelos;

/**
 * Created by ggamboa on 8/2/17.
 */

public class Persona {

    private int id;
    private String nombre;

    public Persona(int id, String nombre) {
        this.nombre = nombre;
        this.id = id;
    }

    public Persona() {

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
}
