package com.rots87.mascotas.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rots87.mascotas.R;
import com.rots87.mascotas.fotosPerfil;

import java.util.ArrayList;

/**
 * Created by rots on 10-09-16.
 */

public class petFotosAdapter extends RecyclerView.Adapter<petFotosAdapter.petViewHolder> {

    ArrayList<fotosPerfil> pets;

    public petFotosAdapter (ArrayList<fotosPerfil> pets){
        this.pets = pets;
    }

    @Override
    public petViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas2,parent,false);
        return new petViewHolder(v);
    }

    @Override
    public void onBindViewHolder(petViewHolder petsViewHolder, int position) {
        fotosPerfil pet = pets.get(position);
        petsViewHolder.foto.setImageResource(pet.getFoto());
        petsViewHolder.numero.setText(pet.getNumero());
        petsViewHolder.ybone.setImageResource(pet.getYbone());
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class petViewHolder extends RecyclerView.ViewHolder{

        private ImageView foto;
        private TextView numero;
        private ImageView ybone;

        public petViewHolder(View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.foto2);
            ybone = (ImageView) itemView.findViewById(R.id.ybone2);
            numero = (TextView) itemView.findViewById(R.id.numero2);
        }
    }
}
