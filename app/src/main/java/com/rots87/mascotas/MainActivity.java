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

        tablayout.getTabAt(0).setIcon(R.drawable.home);
        tablayout.getTabAt(1).setIcon(R.drawable.cat);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones, menu);
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




    @Override
    public void onClick(View view) {
        Intent i = new Intent(this,Raiting.class);
        startActivity(i);
    }
}
