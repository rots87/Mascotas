package com.rots87.mascotas.db;

import android.content.Context;

import com.rots87.mascotas.R;
import com.rots87.mascotas.mascotas;

import java.util.ArrayList;

/**
 * Created by rots on 10-15-16.
 */

public class ConstructorMascotas {
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<mascotas> obtenerDatos(){
        ArrayList<mascotas> mascotas = new ArrayList<>();

        mascotas.add(new mascotas(R.drawable.puppy,"Puppy",R.drawable.bone,R.drawable.bone2,"1"));
        mascotas.add(new mascotas(R.drawable.kitty,"Kitty",R.drawable.bone,R.drawable.bone2,"2"));
        mascotas.add(new mascotas(R.drawable.puppy,"Puppy2",R.drawable.bone,R.drawable.bone2,"3"));
        mascotas.add(new mascotas(R.drawable.kitty,"Kitty2",R.drawable.bone,R.drawable.bone2,"4"));
        mascotas.add(new mascotas(R.drawable.puppy,"Puppy3",R.drawable.bone,R.drawable.bone2,"5"));
        return mascotas;
    }
}
