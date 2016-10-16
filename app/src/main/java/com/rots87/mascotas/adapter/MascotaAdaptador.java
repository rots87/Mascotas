package com.rots87.mascotas.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rots87.mascotas.R;
import com.rots87.mascotas.db.ConstructorMascotas;
import com.rots87.mascotas.mascotas;

import java.util.ArrayList;

/**
 * Created by rots on 10-02-16.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotasViewHolder> {

    ArrayList<mascotas> mascota;
    Activity activity;


    public MascotaAdaptador(ArrayList<mascotas> mascota, Activity activity){
        this.mascota = mascota;
        this.activity = activity;
    }

    @Override
    public MascotasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);
        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotasViewHolder mascotasViewHolder, int position) {
        final mascotas pet = mascota.get(position);
        mascotasViewHolder.foto.setImageResource(pet.getFoto());
        mascotasViewHolder.nombre.setText(pet.getNombre());
        mascotasViewHolder.numero.setText(pet.getNumero());
        mascotasViewHolder.bone.setImageResource(pet.getWbone());
        mascotasViewHolder.ybone.setImageResource(pet.getYbone());

        mascotasViewHolder.ybone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Hola" + pet.getNombre(), Toast.LENGTH_SHORT).show();
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLike(pet);
                mascotasViewHolder.numero.setText(constructorMascotas.obtenerLikesMascotas(pet));

            }
        });
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mascota.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{

        private ImageView foto;
        private ImageView bone;
        private TextView nombre;
        private TextView numero;
        private ImageView ybone;

        public MascotasViewHolder(View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.foto);
            bone = (ImageView) itemView.findViewById(R.id.bone);
            ybone = (ImageView) itemView.findViewById(R.id.ybone);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            numero = (TextView) itemView.findViewById(R.id.numero);
        }
    }
}
