package com.rots87.mascotas.fragment;

import com.rots87.mascotas.adapter.MascotaAdaptador;
import com.rots87.mascotas.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by rots on 10-15-16.
 */

public interface RecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascotas> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador mascotas);

}
