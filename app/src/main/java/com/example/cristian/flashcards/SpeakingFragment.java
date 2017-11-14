package com.example.cristian.flashcards;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
//import android.support.v4.app.Fragment;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;
import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpeakingFragment extends Fragment {

    TextToSpeech tts;
    EditText texto;
    Button botonguardado;
    TextView textoguardado;
    ImageButton boton;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_speaking, container, false);

        ImageButton boton = (ImageButton) view.findViewById(R.id.boton_parlante);
        texto = (EditText) view.findViewById(R.id.texto_hablante);
        textoguardado = (TextView) view.findViewById(R.id.guardado);
        botonguardado = (Button) view.findViewById(R.id.botonguardado);


        tts = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int status) {
                // TODO Auto-generated method stub
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = texto.getText().toString();
                Toast.makeText(getActivity(), toSpeak, Toast.LENGTH_SHORT).show();
//                tts.speak("how are you", TextToSpeech.QUEUE_FLUSH, null);
                tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                preferences = getActivity().getSharedPreferences("Mis preferencias",MODE_PRIVATE);
                editor = preferences.edit();
                editor.putString("palabra", texto.getText().toString());
                editor.commit();
            }
        });

        botonguardado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //preferences = this.getActivity()  //getSharedPreferences("Mis preferencias", MODE_PRIVATE);
                preferences = getActivity().getSharedPreferences("Mis preferencias",MODE_PRIVATE);
                String valor = preferences.getString("palabra","");
                textoguardado.setText(valor);
            }
        });

        return view;
    }

}
