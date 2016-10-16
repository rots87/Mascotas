package com.rots87.mascotas.db;

import android.content.ContentValues;
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
        /*ArrayList<mascotas> mascotas = new ArrayList<>();

        mascotas.add(new mascotas(R.drawable.puppy,"Puppy",R.drawable.bone,R.drawable.bone2,"1"));
        mascotas.add(new mascotas(R.drawable.kitty,"Kitty",R.drawable.bone,R.drawable.bone2,"2"));
        mascotas.add(new mascotas(R.drawable.puppy,"Puppy2",R.drawable.bone,R.drawable.bone2,"3"));
        mascotas.add(new mascotas(R.drawable.kitty,"Kitty2",R.drawable.bone,R.drawable.bone2,"4"));
        mascotas.add(new mascotas(R.drawable.puppy,"Puppy3",R.drawable.bone,R.drawable.bone2,"5"));
        return mascotas;*/
        BasedeDatos db = new BasedeDatos(context);
        insertarCincoMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public void insertarCincoMascotas(BasedeDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NAME,"Kaiser");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_PHOTO,R.drawable.puppy);
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_YBONE,R.drawable.bone2);
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_WBONE,R.drawable.bone);
        db.insertarMascotas(contentValues);
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NAME,"Mish");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_PHOTO,R.drawable.kitty);
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_YBONE,R.drawable.bone2);
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_WBONE,R.drawable.bone);
        db.insertarMascotas(contentValues);
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NAME,"Blacky");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_PHOTO,R.drawable.puppy);
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_YBONE,R.drawable.bone2);
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_WBONE,R.drawable.bone);
        db.insertarMascotas(contentValues);
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NAME,"Leoncio");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_PHOTO,R.drawable.kitty);
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_YBONE,R.drawable.bone2);
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_WBONE,R.drawable.bone);
        db.insertarMascotas(contentValues);
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NAME,"Kitty");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_PHOTO,R.drawable.kitty);
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_YBONE,R.drawable.bone2);
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_WBONE,R.drawable.bone);
        db.insertarMascotas(contentValues);

    }
}
