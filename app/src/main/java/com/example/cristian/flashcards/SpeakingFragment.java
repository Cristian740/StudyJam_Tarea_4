package com.example.cristian.flashcards;


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

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpeakingFragment extends Fragment {

    TextToSpeech tts;
    EditText texto;
    ImageButton boton;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_speaking, container, false);

        ImageButton boton = (ImageButton) view.findViewById(R.id.boton_parlante);
        texto = (EditText) view.findViewById(R.id.texto_hablante);

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
            }
        });
        return view;
    }

}
