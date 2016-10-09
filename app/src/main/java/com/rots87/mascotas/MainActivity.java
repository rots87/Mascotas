package com.rots87.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.rots87.mascotas.adapter.MascotaAdaptador;
import com.rots87.mascotas.adapter.PageAdapter;
import com.rots87.mascotas.fragment.Perfil;
import com.rots87.mascotas.fragment.ReciclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<mascotas> mascotas;
    private RecyclerView listamascotas;
    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tablayout = (TabLayout) findViewById(R.id.tabLayourt);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        Toolbar AppBar = (Toolbar) findViewById(R.id.AppBar);
        setSupportActionBar(AppBar);
        setUpViewPager();
        /*
        listamascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listamascotas.setLayoutManager(llm);
        InicioMascotas();
        inicializarAdaptador();

        */

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }

        ImageView Fav = (ImageView) findViewById(R.id.abFav);
        Fav.setOnClickListener(this);

    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ReciclerViewFragment());
        fragments.add(new Perfil());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tablayout.setupWithViewPager(viewPager);

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

        mascotas.add(new mascotas(R.drawable.puppy,"Puppy",R.drawable.bone,R.drawable.bone2,"1"));
        mascotas.add(new mascotas(R.drawable.kitty,"Kitty",R.drawable.bone,R.drawable.bone2,"2"));
        mascotas.add(new mascotas(R.drawable.puppy,"Puppy2",R.drawable.bone,R.drawable.bone2,"3"));
        mascotas.add(new mascotas(R.drawable.kitty,"Kitty2",R.drawable.bone,R.drawable.bone2,"4"));
        mascotas.add(new mascotas(R.drawable.puppy,"Puppy3",R.drawable.bone,R.drawable.bone2,"5"));

    }


    @Override
    public void onClick(View view) {
        Intent i = new Intent(this,Raiting.class);
        startActivity(i);
    }
}
