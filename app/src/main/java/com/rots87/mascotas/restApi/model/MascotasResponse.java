package com.rots87.mascotas.restApi.model;

import com.rots87.mascotas.Pojo.mascotas;

import java.util.ArrayList;

/**
 * Created by rots on 10-31-16.
 */

public class MascotasResponse {
    ArrayList<mascotas> mascota;

    public ArrayList<mascotas> getMascota() {
        return mascota;
    }

    public void setMascota(ArrayList<mascotas> mascota) {
        this.mascota = mascota;
    }
}

