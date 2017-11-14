package com.example.cristian.flashcards;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;


public class DetalleanimalActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";
    public TextToSpeech tts;
    String palabra="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getSupportActionBar().hide();   //para ocultar la cabecera superior
        //imagen_detalle = (ImageView) findViewById(R.id.animal_detail_image);
        tts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int status) {
                // TODO Auto-generated method stub
                if(status !=TextToSpeech.ERROR){
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });

        setContentView(R.layout.activity_detalleanimal);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        // collapsingToolbar.setTitle(getString(R.string.item_title));

        int position = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Resources resources = getResources();
        String[] titulo_detalle = resources.getStringArray(R.array.animales);
        collapsingToolbar.setTitle(titulo_detalle[position % titulo_detalle.length]);

        String[] words = resources.getStringArray(R.array.animales);
        TextView word_detail = (TextView) findViewById(R.id.animal_detail_word);
        word_detail.setText(words[position % words.length]);
        palabra=word_detail.getText().toString();

        //animal_detail_image
        String[] meanings = resources.getStringArray(R.array.animales_esp);
        TextView meaning_detail =  (TextView) findViewById(R.id.animal_detail_wordesp);
        meaning_detail.setText(meanings[position % meanings.length]);

        TypedArray pictures = resources.obtainTypedArray(R.array.animales_dibujo);
        ImageView picture_detail = (ImageView) findViewById(R.id.animal_detail_image);
        picture_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tts.speak(palabra, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        picture_detail.setImageDrawable(pictures.getDrawable(position % pictures.length()));
        pictures.recycle();
    }
}
