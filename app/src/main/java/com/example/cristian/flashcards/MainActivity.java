package com.example.cristian.flashcards;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import static com.example.cristian.flashcards.R.styleable.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //utilizando las variables para realizar fragmentos
    FragmentManager fragmentManager;    //el que maneja
    FragmentTransaction fragmentTransaction;    //el que comunica

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //corregir esta linea comentada
        setSupportActionBar(toolbar);
        //getSupportActionBar().hide();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu_adjetives) {
            getSupportActionBar().setTitle("Adjetives");   //titulo
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            AdjetivosFragment adjetivosFragment = new AdjetivosFragment(); //el constructor
            fragmentTransaction.replace(R.id.contenedor,adjetivosFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.menu_animals) {
            getSupportActionBar().setTitle("Animals");   //titulo action bar
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            AnimalFragment animalFragment = new AnimalFragment(); //el constructor
            fragmentTransaction.replace(R.id.contenedor,animalFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.list_tenses) {
            getSupportActionBar().setTitle("Grammatical tenses");   //titulo action bar
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            SentencesFragment sentencesFragment = new SentencesFragment(); //el constructor
            fragmentTransaction.replace(R.id.contenedor,sentencesFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.menu_clothes) {
            getSupportActionBar().setTitle("Clothes");   //titulo action bar
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            RopaFragment ropaFragment = new RopaFragment(); //el constructor
            fragmentTransaction.replace(R.id.contenedor,ropaFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.menu_drinks) {
            getSupportActionBar().setTitle("Drinks");   //titulo action bar
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            BebidasFragment bebidasFragment = new BebidasFragment(); //el constructor
            fragmentTransaction.replace(R.id.contenedor,bebidasFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.menu_feelings) {
            getSupportActionBar().setTitle("Feelings");   //titulo action bar
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            SentimientosFragment sentimientosFragment = new SentimientosFragment(); //el constructor
            fragmentTransaction.replace(R.id.contenedor,sentimientosFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.menu_food) {
            getSupportActionBar().setTitle("Foods");   //titulo action bar
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            ComidaFragment comidaFragment = new ComidaFragment(); //el constructor
            fragmentTransaction.replace(R.id.contenedor,comidaFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.menu_fruits) {
            getSupportActionBar().setTitle("Fruits");   //titulo action bar
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            FrutasFragment frutasFragment = new FrutasFragment(); //el constructor
            fragmentTransaction.replace(R.id.contenedor,frutasFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.menu_vegetables) {
            getSupportActionBar().setTitle("Vegetables");   //titulo action bar
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            VegetalesFragment vegetalesFragment = new VegetalesFragment(); //el constructor
            fragmentTransaction.replace(R.id.contenedor,vegetalesFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.menu_verbs) {
            getSupportActionBar().setTitle("Verbs");   //titulo action bar
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            VerbosFragment verbosFragment = new VerbosFragment(); //el constructor
            fragmentTransaction.replace(R.id.contenedor,verbosFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.menu_weather) {
            getSupportActionBar().setTitle("Weather");   //titulo action bar
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            ClimaFragment climaFragment = new ClimaFragment(); //el constructor
            fragmentTransaction.replace(R.id.contenedor,climaFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.list_adjetives) {
            getSupportActionBar().setTitle("List Adjetives");   //titulo action bar
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            AdjetivesFragment adjetivesFragment = new AdjetivesFragment(); //el constructor
            fragmentTransaction.replace(R.id.contenedor,adjetivesFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.list_irregular_verbs) {
            getSupportActionBar().setTitle("Irregular Verbs");   //titulo action bar
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            IrregularverbsFragment irregularverbsFragment = new IrregularverbsFragment(); //el constructor
            fragmentTransaction.replace(R.id.contenedor,irregularverbsFragment);
            fragmentTransaction.commit();
        }   else if (id==R.id.inf_support){
            getSupportActionBar().setTitle("Support");   //titulo action bar
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            SoporteFragment soporteFragment = new SoporteFragment(); //el constructor
            fragmentTransaction.replace(R.id.contenedor,soporteFragment);
            fragmentTransaction.commit();
        }   else if (id==R.id.menu_songs){
            getSupportActionBar().setTitle("Songs");   //titulo action bar
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            SongsFragment songsFragment = new SongsFragment(); //el constructor
            fragmentTransaction.replace(R.id.contenedor,songsFragment);
            fragmentTransaction.commit();
        }   else if (id==R.id.menu_speaking){
            getSupportActionBar().setTitle("Speaking");   //titulo action bar
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            SpeakingFragment speakingFragment = new SpeakingFragment(); //el constructor
            fragmentTransaction.replace(R.id.contenedor,speakingFragment);
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
