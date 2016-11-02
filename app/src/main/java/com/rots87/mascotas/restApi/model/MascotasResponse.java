package com.rots87.mascotas.restApi.model;

import com.rots87.mascotas.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by rots on 10-31-16.
 */

public class MascotasResponse {
    ArrayList<Mascotas> mascota;

    public ArrayList<Mascotas> getMascota() {
        return mascota;
    }

    public void setMascota(ArrayList<Mascotas> mascota) {
        this.mascota = mascota;
    }
}

