package com.rots87.mascotas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class usuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
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

            case R.id.mItem3:
                i = new Intent(this,usuario.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
