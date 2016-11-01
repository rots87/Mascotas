package com.rots87.mascotas.presentador;

import android.content.Context;
import com.rots87.mascotas.db.ConstructorMascotas;
import com.rots87.mascotas.fragment.RecyclerViewFragmentView;
import com.rots87.mascotas.Pojo.mascotas;

import java.util.ArrayList;

/**
 * Created by rots on 10-15-16.
 */

public class ReciclerViewFramentPresenter implements IRecyclerViewFragmentPresenter {

    private RecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<mascotas> mascota;

    public ReciclerViewFramentPresenter(RecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        //obtenerMascotasDB();
        obtenerMediosRecientes();
    }

    @Override
    public void obtenerMascotasDB() {
        constructorMascotas = new ConstructorMascotas(context);
        mascota = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void obtenerMediosRecientes() {
        
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascota));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
