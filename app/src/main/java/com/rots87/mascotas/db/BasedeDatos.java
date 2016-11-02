package com.rots87.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.rots87.mascotas.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by rots on 10-13-16.
 */

public class BasedeDatos extends SQLiteOpenHelper {

    private Context context;

    public BasedeDatos(Context context) {
        super(context, ConstantesDB.DATABASE_NAME, null, ConstantesDB.DATAVASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTabMascotas=   "CREATE TABLE " + ConstantesDB.TABLE_MASCOTAS + "("+
                                        ConstantesDB.TABLE_MASCOTAS_ID      + " INTEGER PRIMARY KEY," +
                                        ConstantesDB.TABLE_MASCOTAS_NAME    + " TEXT,"      +
                                        ConstantesDB.TABLE_MASCOTAS_PHOTO   + " INTEGER,"    +
                                        ConstantesDB.TABLE_MASCOTAS_YBONE   + " INTEGER,"    +
                                        ConstantesDB.TABLE_MASCOTAS_WBONE   + " INTEGER"    +
                                        ")";

        String queryCrearTabMascotasLikes = "CREATE TABLE " + ConstantesDB.TABLE_MASCOTASLIKES + "("+
                                        ConstantesDB.TABLE_MASCOTASLIKES_ID             + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesDB.TABLE_MASCOTASLIKES_ID_CONTACTO    + " INTEGER, " +
                                        ConstantesDB.TABLE_MASCOTASLIKES_LIKES          + " INTEGER, " +
                                        " FOREIGN KEY ("+ConstantesDB.TABLE_MASCOTASLIKES_ID_CONTACTO + ")" +
                                        " REFERENCES "+ ConstantesDB.TABLE_MASCOTAS + "(" + ConstantesDB.TABLE_MASCOTAS_ID + ")" +
                ")";

        db.execSQL(queryCrearTabMascotas);
        db.execSQL(queryCrearTabMascotasLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesDB.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesDB.TABLE_MASCOTASLIKES);
        onCreate(db);
    }

    public ArrayList<Mascotas> obtenerTodasLasMascotas(){
        ArrayList <Mascotas> mascota = new ArrayList<>();
        String query = "SELECT * FROM "+ ConstantesDB.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setYbone(registros.getInt(3));
            mascotaActual.setWbone(registros.getInt(4));
            mascotaActual.setWbone(registros.getInt(4));
            String query2 = "SELECT COUNT (" + ConstantesDB.TABLE_MASCOTASLIKES_LIKES + ")"+
                    " FROM " + ConstantesDB.TABLE_MASCOTASLIKES +
                    " WHERE " + ConstantesDB.TABLE_MASCOTASLIKES_ID_CONTACTO + "="+mascotaActual.getId();
            Cursor registros2 = db.rawQuery(query2,null);

            while (registros2.moveToNext()){
                mascotaActual.setNumero(String.valueOf(registros2.getInt(0)));
            }
            mascota.add(mascotaActual);
        }
        db.close();

        return mascota;
    }

    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDB.TABLE_MASCOTAS,null,contentValues);
        db.close();
    }

    public void insertarLikeMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDB.TABLE_MASCOTASLIKES,null,contentValues);
        db.close();
    }

    public int obtenerLikesMascotas(Mascotas mascota){
        int likes = 0;

        String query = "SELECT COUNT (" + ConstantesDB.TABLE_MASCOTASLIKES_LIKES + ")"+
                " FROM " + ConstantesDB.TABLE_MASCOTASLIKES +
                " WHERE " + ConstantesDB.TABLE_MASCOTASLIKES_ID_CONTACTO + "="+mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        if (likes != 0){
            return likes;
        }else {
            return 0;
        }


    }
}
