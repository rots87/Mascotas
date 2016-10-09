package com.rots87.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.rots87.mascotas.adapter.MascotaAdaptador;

import java.util.ArrayList;

public class Raiting extends AppCompatActivity {

    ArrayList<mascotas> mascotas;
    private RecyclerView listamascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raiting);
        Toolbar AppBar = (Toolbar) findViewById(R.id.AppBar);
        setSupportActionBar(AppBar);
        AppBar.setNavigationIcon(R.drawable.abc_ic_ab_back_material);
        AppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                regresarMain(v);
            }
        });

        ImageView Fav = (ImageView) findViewById(R.id.abFav);
        Fav.setVisibility(View.INVISIBLE);

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
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast mensaje;
        String cadena = "";
        switch (item.getItemId()){
            case R.id.mItem1:
                cadena = "Has precionado el Item 1";
                break;
            case R.id.mItem2:
                cadena = "Has precionado el Item 2";
                break;
        }
        mensaje = Toast.makeText(getApplicationContext(),cadena,Toast.LENGTH_SHORT);
        mensaje.show();
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
