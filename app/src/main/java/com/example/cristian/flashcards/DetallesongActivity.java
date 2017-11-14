package com.example.cristian.flashcards;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetallesongActivity extends AppCompatActivity {
    public static final String EXTRA_POSITION = "position";
    public int position;
    private MediaPlayer mp;
    int posicion;

    String palabra = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // getSupportActionBar().hide();   //para ocultar la cabecera superior
        //imagen_detalle = (ImageView) findViewById(R.id.animal_detail_image);


        setContentView(R.layout.activity_detallesong);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        // collapsingToolbar.setTitle(getString(R.string.item_title));

        position = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Resources resources = getResources();
        String[] titulo_detalle = resources.getStringArray(R.array.cancion_titulo);
        collapsingToolbar.setTitle(titulo_detalle[position % titulo_detalle.length]);

        palabra = titulo_detalle[position % titulo_detalle.length].toString();

        String[] uses = resources.getStringArray(R.array.cancion_letra);
        TextView uses_detail = (TextView) findViewById(R.id.song_detail_song);
        uses_detail.setText(uses[position % uses.length]);


        TypedArray pictures = resources.obtainTypedArray(R.array.cancion_imagen);
        ImageView picture_detail = (ImageView) findViewById(R.id.song_detail_image);
        picture_detail.setImageDrawable(pictures.getDrawable(position % pictures.length()));
        pictures.recycle();
    }

    public void play_song(View view) {
        Resources resources = getResources();
        TypedArray canciones = resources.obtainTypedArray(R.array.cancion_song);
        int[] songs = new int[]{
                R.raw.love_her,
                R.raw.yesterday
        };

        if (mp == null) {   //si esta en stop

            mp = MediaPlayer.create(this, songs[position]);

            mp.start();
            Toast.makeText(this, "Play" + position, Toast.LENGTH_SHORT).show();
        } else {
            if (!mp.isPlaying()) {  //que no se este reproduciendo la cancion
                mp.seekTo(posicion);
                mp.start();
                Toast.makeText(this, "Reanudando", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void pausar_song(View view) {
        if (mp != null) {       //verificando si esta en stop
            mp.pause();
            posicion = mp.getCurrentPosition();//saca la posicion donde se pausara la cancion
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        }
    }


    public void stop_song(View view) {
        if (mp != null) {
            mp.stop();
            mp.release();   //para liberar memoria
            mp = null;
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
        pausar_song(null);
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
        stop_song(null);
        finish();
    }

}
