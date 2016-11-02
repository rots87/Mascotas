package com.rots87.mascotas.pojo;

/**
 * Created by rots on 10-02-16.
 */

public class Mascotas {

    private int id;
    private int foto;
    private String Nombre;
    private int wbone;
    private int ybone;
    private String numero;

    public Mascotas() {

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Mascotas(int foto, String Nombre, int wbone, int ybone, String numero){
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
