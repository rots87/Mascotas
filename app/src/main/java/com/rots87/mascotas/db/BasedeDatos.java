package com.rots87.mascotas.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
                                        ConstantesDB.TABLE_MASCOTAS_ID      + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                                        ConstantesDB.TABLE_MASCOTAS_NAME    + " TEXT,"      +
                                        ConstantesDB.TABLE_MASCOTAS_PHOTO   + " INTEGER"    +
                                        ")";

        String queryCrearTabMascotasLikes = "CREATE TABLE " + ConstantesDB.TABLE_MASCOTASLIKES + "("+
                                        ConstantesDB.TABLE_MASCOTASLIKES_ID             + "INTEGER PRIMERY KEY AUTOINCREMENT, " +
                                        ConstantesDB.TABLE_MASCOTASLIKES_ID_CONTACTO    + "INTEGER," +
                                        ConstantesDB.TABLE_MASCOTASLIKES_LIKES          + "INTEGER" +
                                        "FOREING KEY("+ConstantesDB.TABLE_MASCOTASLIKES_ID_CONTACTO + ")" +
                                        "REFERENCES "+ ConstantesDB.TABLE_MASCOTAS + "(" + ConstantesDB.TABLE_MASCOTASLIKES_ID + ")" +
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

    //public Ar
}
