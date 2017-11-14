package com.example.cristian.flashcards;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class DetallesentenceActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";
    public TextToSpeech tts;
    String palabra="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // getSupportActionBar().hide();   //para ocultar la cabecera superior
        //imagen_detalle = (ImageView) findViewById(R.id.animal_detail_image);


        setContentView(R.layout.activity_detallesentence);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        // collapsingToolbar.setTitle(getString(R.string.item_title));

        int position = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Resources resources = getResources();
        String[] titulo_detalle = resources.getStringArray(R.array.tenses_name);
        collapsingToolbar.setTitle(titulo_detalle[position % titulo_detalle.length]);

        palabra=titulo_detalle[position % titulo_detalle.length].toString();

        String[] uses = resources.getStringArray(R.array.tense_uso);
        TextView uses_detail = (TextView) findViewById(R.id.sentences_detail_uses);
        uses_detail.setText(uses[position % uses.length]);


        String[] examples = resources.getStringArray(R.array.tense_ejemplo);
        TextView examples_detail =  (TextView) findViewById(R.id.sentences_detail_examples);
        examples_detail.setText(examples[position % examples.length]);

        String[] times = resources.getStringArray(R.array.tense_time);
        TextView times_detail =  (TextView) findViewById(R.id.sentences_detail_time);
        times_detail.setText(times[position % times.length]);

        TypedArray pictures = resources.obtainTypedArray(R.array.tense_dibujo);
        ImageView picture_detail = (ImageView) findViewById(R.id.sentences_detail_image);
        picture_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Forms of "+palabra,
                        Snackbar.LENGTH_LONG).show();
            }
        });
        picture_detail.setImageDrawable(pictures.getDrawable(position % pictures.length()));
        pictures.recycle();
    }
}
