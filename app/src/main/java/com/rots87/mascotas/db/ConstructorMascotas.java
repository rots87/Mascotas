package com.rots87.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.rots87.mascotas.R;
import com.rots87.mascotas.Pojo.mascotas;

import java.util.ArrayList;

/**
 * Created by rots on 10-15-16.
 */

public class ConstructorMascotas {
    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<mascotas> obtenerDatos(){
        BasedeDatos db = new BasedeDatos(context);
        insertarCincoMascotas(db); //Use solo cuando es la primera vez que ejecuta la app
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

    public void darLike(mascotas mascota){
        BasedeDatos db = new BasedeDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTASLIKES_ID_CONTACTO,mascota.getId());
        contentValues.put(ConstantesDB.TABLE_MASCOTASLIKES_LIKES,LIKE);
        db.insertarLikeMascotas(contentValues);

    }

    public int obtenerLikesMascotas(mascotas mascota){
        BasedeDatos db = new BasedeDatos(context);
        return  db.obtenerLikesMascotas(mascota);
    }
}
