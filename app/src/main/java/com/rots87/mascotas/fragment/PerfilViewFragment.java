package com.rots87.mascotas.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.rots87.mascotas.R;
import com.rots87.mascotas.adapter.petFotosAdapter;
import com.rots87.mascotas.fotosPerfil;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilViewFragment extends Fragment {
    private RecyclerView listafotos;
    ArrayList<fotosPerfil> mascotas;

    public PerfilViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        //Implementacion de la imagen circular
        CircularImageView circularImageView = (CircularImageView) v.findViewById(R.id.circularImage);
        circularImageView.setBorderColor(getResources().getColor(R.color.colorPrimary));
        circularImageView.setBorderWidth(10);
        circularImageView.addShadow();
        circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(Color.RED);
        //fin de la implementacion de imagen circular

        listafotos = (RecyclerView) v.findViewById(R.id.fotosmascotas);
        listafotos.setLayoutManager(new GridLayoutManager(getContext(), 3));
        InicioMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        petFotosAdapter adaptador = new petFotosAdapter(mascotas);
        listafotos.setAdapter(adaptador);
    }

    public void InicioMascotas(){
        mascotas = new ArrayList<fotosPerfil>();

        mascotas.add(new fotosPerfil(R.drawable.puppy,R.drawable.bone2,"1"));
        mascotas.add(new fotosPerfil(R.drawable.puppy,R.drawable.bone2,"1"));
        mascotas.add(new fotosPerfil(R.drawable.puppy,R.drawable.bone2,"1"));
        mascotas.add(new fotosPerfil(R.drawable.puppy,R.drawable.bone2,"1"));
        mascotas.add(new fotosPerfil(R.drawable.puppy,R.drawable.bone2,"1"));
        mascotas.add(new fotosPerfil(R.drawable.puppy,R.drawable.bone2,"1"));

    }

}
