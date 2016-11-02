package com.rots87.mascotas.pojo;

/**
 * Created by rots on 10-02-16.
 */

public class Mascotas {

    private int id;
    private String foto;
    private String Nombre;
    private int wbone;
    private int ybone;
    private int numero;

    public Mascotas() {

    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getWbone() {
        return wbone;
    }

    public void setWbone(int wbone) {
        this.wbone = wbone;
    }

    public int getYbone() {
        return ybone;
    }

    public void setYbone(int ybone) {
        this.ybone = ybone;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Mascotas(String foto, String Nombre, int wbone, int ybone, int numero){
        this.foto = foto;
        this.Nombre = Nombre;
        this.wbone = wbone;
        this.ybone = ybone;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
