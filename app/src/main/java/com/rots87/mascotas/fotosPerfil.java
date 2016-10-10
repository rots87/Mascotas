package com.rots87.mascotas;

/**
 * Created by rots on 10-09-16.
 */

public class fotosPerfil {
    private int foto;
    private int ybone;
    private String numero;

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
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

    public fotosPerfil(int foto, int ybone, String numero){
        this.foto = foto;
        this.ybone = ybone;
        this.numero = numero;
    }
}
