package com.jorgeloayza.tareas5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.jorgeloayza.tareas5.R;
import com.jorgeloayza.tareas5.adapter.PageAdapter;
import com.jorgeloayza.tareas5.fragment.InicioFragment;
import com.jorgeloayza.tareas5.fragment.PerfilFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Toolbar toolBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //definimos nuestro toobar
        toolBar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager= findViewById(R.id.viewPager);
        setUpViewPager();

        if (toolBar != null){
            setSupportActionBar(toolBar);
        }
        setSupportActionBar(toolBar);
    }

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new InicioFragment());
        fragments.add(new PerfilFragment());
        return  fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_inicio);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_pata);
    }
    //creamos nuestro menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            Intent intent;
            switch (item.getItemId()){
                case R.id.mFavoritos:
                    //intent para ir a la activity de favoritos
                    intent = new Intent(MainActivity.this, FavoritosActivity.class);
                    startActivity(intent);
                break;
                case R.id.mContacto:
                    intent = new Intent(MainActivity.this, ContacoActivity.class);
                    startActivity(intent);
                    break;
                case R.id.mAbout:
                    intent = new Intent(MainActivity.this, AboutActivity.class);
                    startActivity(intent);
                    break;
            }
        return super.onOptionsItemSelected(item);
    }
}