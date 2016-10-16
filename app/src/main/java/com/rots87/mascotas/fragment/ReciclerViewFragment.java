package com.rots87.mascotas.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rots87.mascotas.R;
import com.rots87.mascotas.adapter.MascotaAdaptador;
import com.rots87.mascotas.mascotas;
import com.rots87.mascotas.presentador.IRecyclerViewFragmentPresenter;
import com.rots87.mascotas.presentador.ReciclerViewFramentPresenter;

import java.util.ArrayList;

/**
 * Created by rots on 10-09-16.
 */

public class ReciclerViewFragment extends Fragment implements RecyclerViewFragmentView {
    private ArrayList<mascotas> mascota;
    private RecyclerView listamascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_reciclerview, container, false);
        listamascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new ReciclerViewFramentPresenter(this, getContext());
        return v;
    }



    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listamascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<mascotas> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador mascotas) {
        listamascotas.setAdapter(mascotas);

    }
}
