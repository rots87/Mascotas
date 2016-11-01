package com.rots87.mascotas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.rots87.mascotas.adapter.PageAdapter;
import com.rots87.mascotas.fragment.PerfilViewFragment;
import com.rots87.mascotas.fragment.ReciclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.drawable.footprint);
        actionBar.setDisplayShowHomeEnabled(true);


        tablayout = (TabLayout) findViewById(R.id.tabLayourt);
        viewPager = (ViewPager) findViewById(R.id.viewpager);



        setUpViewPager();



    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ReciclerViewFragment());
        fragments.add(new PerfilViewFragment());
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
            case R.id.Fav:
                i = new Intent(this,Raiting.class);
                startActivity(i);
                break;
            case R.id.mItem1:
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, "ncanas87@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Prueba");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                break;
            case R.id.mItem2:
                i = new Intent(this,DeveloperBio.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
