package com.rots87.mascotas.presentador;

import android.content.Context;

import com.rots87.mascotas.adapter.MascotaAdaptador;
import com.rots87.mascotas.fragment.RecyclerViewFragmentView;
import com.rots87.mascotas.mascotas;

import java.util.ArrayList;

/**
 * Created by rots on 10-15-16.
 */

public class ReciclerViewFramentPresenter implements IRecyclerViewFragmentPresenter {

    private RecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;

    public ReciclerViewFramentPresenter(RecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
    }

    @Override
    public void obtenerMascotasDB() {

    }

    @Override
    public void mostrarMascotasRV() {

    }
}
