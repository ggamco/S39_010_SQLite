package com.gmbdesign.modelos;

/**
 * Created by ggamboa on 8/2/17.
 */

public class Coche {

    private int id;
    private String modelo;
    private Persona persona;

    public Coche(String modelo, Persona persona) {
        this.modelo = modelo;
        this.persona = persona;
    }

    public Coche(String modelo) {
        this.modelo = modelo;
    }

    public Coche() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
