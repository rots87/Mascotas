package com.rots87.mascotas;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.rots87.mascotas.adapter.MascotaAdaptador;

import java.util.ArrayList;

public class Raiting extends AppCompatActivity {

    ArrayList<mascotas> mascotas;
    private RecyclerView listamascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raiting);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.drawable.footprint);
        actionBar.setDisplayShowHomeEnabled(true);


        listamascotas = (RecyclerView) findViewById(R.id.rvMascotas2);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listamascotas.setLayoutManager(llm);
        InicioMascotas();
        inicializarAdaptador();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones, menu);
        MenuItem fav = menu.findItem(R.id.Fav);
        fav.setVisible(false);
        this.invalidateOptionsMenu();
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()){
            case R.id.mItem1:
                i = new Intent(this,Email.class);
                startActivity(i);
                break;
            case R.id.mItem2:
                i = new Intent(this,DeveloperBio.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listamascotas.setAdapter(adaptador);
    }

    public void InicioMascotas(){
        mascotas = new ArrayList<mascotas>();
        mascotas.add(new mascotas(R.drawable.puppy,"Puppy3",R.drawable.bone,R.drawable.bone2,"5"));
        mascotas.add(new mascotas(R.drawable.kitty,"Kitty2",R.drawable.bone,R.drawable.bone2,"4"));
        mascotas.add(new mascotas(R.drawable.puppy,"Puppy2",R.drawable.bone,R.drawable.bone2,"3"));
        mascotas.add(new mascotas(R.drawable.kitty,"Kitty",R.drawable.bone,R.drawable.bone2,"2"));
        mascotas.add(new mascotas(R.drawable.puppy,"Puppy",R.drawable.bone,R.drawable.bone2,"1"));


    }
    public void regresarMain(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
