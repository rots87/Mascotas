package com.rots87.mascotas.fragment;

import com.rots87.mascotas.adapter.MascotaAdaptador;
import com.rots87.mascotas.mascotas;

import java.util.ArrayList;

/**
 * Created by rots on 10-15-16.
 */

public interface RecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<mascotas> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador mascotas);

}
