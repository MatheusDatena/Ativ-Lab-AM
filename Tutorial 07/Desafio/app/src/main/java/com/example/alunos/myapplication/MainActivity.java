package com.example.alunos.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alunos.myapplication.model.Pessoa;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<Pessoa> lista = new ArrayList<>();

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureNavigationDrawer();
        configureToolbar();
        Fragment f = new ViewItensFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, f);
        transaction.addToBackStack(null);
        transaction.commit();


    }

    private void configureToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setHomeAsUpIndicator(R.mipmap.ic_launcher_round);
            actionbar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void configureNavigationDrawer() {
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.navigation);
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        Fragment f = null;
                        int itemId = menuItem.getItemId();

                        if (itemId == R.id.action_new_item) {
                            f = new AddItemsFragment();
                        }else if (itemId == R.id.action_view_items) {
                            f = new ViewItensFragment();
                        }
                        if (f != null) {
                            FragmentTransaction transaction =
                                    getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frame, f);
                            transaction.commit();
                            drawerLayout.closeDrawers();
                            return true;
                        }
                        return false;
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.empty_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int itemId = item.getItemId();

        switch (itemId){
            //Android home
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            //manage other entries if you have it...
        }
        return true;
    }

    public void salvar(View v){
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        EditText editNome = (EditText)findViewById(R.id.editName);
        String name = editNome.getText().toString();
        Log.d("editName",name);
        if(name.matches("")  ){
            Toast toast = Toast.makeText(this, "Digite algo...", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        SharedPreferences.Editor editor = arquivo.edit();
        editor.putString("nome", name);
        editor.commit();
        editNome.setText("");

        lista.add(new Pessoa(name));
    }

    public ArrayList<Pessoa> getLista(){
        return lista;
    }
}

