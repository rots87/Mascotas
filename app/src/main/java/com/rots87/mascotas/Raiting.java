package com.rots87.mascotas;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.rots87.mascotas.adapter.PageAdapter;

import com.rots87.mascotas.fragment.ReciclerViewFragment;

import java.util.ArrayList;

public class Raiting extends AppCompatActivity {

    ArrayList<com.rots87.mascotas.Pojo.mascotas> mascotas;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.drawable.footprint);
        actionBar.setDisplayShowHomeEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.viewpager);



        setUpViewPager();



    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ReciclerViewFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));


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
}
