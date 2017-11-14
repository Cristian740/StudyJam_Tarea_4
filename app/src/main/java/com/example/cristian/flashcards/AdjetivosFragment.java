package com.example.cristian.flashcards;


import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
//import android.support.v4.app.Fragment;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdjetivosFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public TextToSpeech tts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.item_verbos, null);
        tts=new TextToSpeech(container.getContext(), new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int status) {
                // TODO Auto-generated method stub
                if(status !=TextToSpeech.ERROR){
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });
        //esto se utiliza en Recycler View
        View recyclerViewAdjetivos = inflater.inflate(R.layout.recycler_view, container, false);
        recyclerView = (RecyclerView) recyclerViewAdjetivos.findViewById(R.id.my_recycler_view);
        recyclerView.setHasTransientState(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
        adapter = new AdjetivosFragment.ContentAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        return recyclerViewAdjetivos;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView adjetivo_picture;
        public TextView adjetivo1_name;
        public TextView adjetivo1_description;
        public TextView adjetivo2_name;
        public TextView adjetivo2_description;
        public ImageView adjetivo1_boton;
        public ImageView adjetivo2_boton;


        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_adjetivos, parent, false));
            adjetivo_picture = (ImageView) itemView.findViewById(R.id.adjetivo_card_image);
            adjetivo1_name = (TextView) itemView.findViewById(R.id.adjetivo_card_title1);
            adjetivo1_description = (TextView) itemView.findViewById(R.id.adjetivo1_card_text);
            adjetivo1_boton = (ImageView) itemView.findViewById(R.id.adjetivo1_boton_play);
            adjetivo2_name = (TextView) itemView.findViewById(R.id.adjetivo_card_title2);
            adjetivo2_description = (TextView) itemView.findViewById(R.id.adjetivo2_card_text);
            adjetivo2_boton = (ImageView) itemView.findViewById(R.id.adjetivo2_boton_play);

            /*
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetalleanimalActivity.class);
                    intent.putExtra(DetalleanimalActivity.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });

            */
        }
    }
    /**
     * Adapter to display recycler view.
     */
    public class ContentAdapter extends RecyclerView.Adapter<AdjetivosFragment.ViewHolder> {
        // Set numbers of List in RecyclerView.
        int LENGTH ;
        private final String[] cAdjetivos1;
        private final String[] cAdjetivos1Esp;
        private final String[] cAdjetivos2;
        private final String[] cAdjetivos2Esp;
        private final Drawable[] cAdjetivosImagenes;

        TypedArray a;
        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            cAdjetivos1 = resources.getStringArray(R.array.adjetivos_1);
            cAdjetivos1Esp = resources.getStringArray(R.array.adjetivos_1es);
            cAdjetivos2 = resources.getStringArray(R.array.adjetivos_2);
            cAdjetivos2Esp = resources.getStringArray(R.array.adjetivos_2es);
            a = resources.obtainTypedArray(R.array.adjetivos_dibujo);
            cAdjetivosImagenes = new Drawable[a.length()];
            LENGTH = a.length();
        }

        @Override
        public AdjetivosFragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new AdjetivosFragment.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(final AdjetivosFragment.ViewHolder holder, int position) {
            holder.adjetivo_picture.setImageDrawable(a.getDrawable(position));
            holder.adjetivo1_name.setText(cAdjetivos1[position % cAdjetivos1.length]);
            holder.adjetivo1_description.setText(cAdjetivos1Esp[position % cAdjetivos1Esp.length]);
            holder.adjetivo2_name.setText(cAdjetivos2[position % cAdjetivos2.length]);
            holder.adjetivo2_description.setText(cAdjetivos2Esp[position % cAdjetivos2Esp.length]);



            holder.adjetivo1_boton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    //String toSpeak = (String) holder.animal_name.getText();
                    String toSpeak = holder.adjetivo1_name.getText().toString();
                    //tts.setPitch(0);
                    //tts.setSpeechRate(2);
                    tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //hablar(toSpeak);
                    //Toast.makeText(holder.itemView.getContext(),""+holder.animal_name.getText(),Toast.LENGTH_SHORT).show();
                    Toast.makeText(holder.itemView.getContext(),toSpeak,Toast.LENGTH_SHORT).show();
                    //t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                }
            });

            holder.adjetivo2_boton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    //String toSpeak = (String) holder.animal_name.getText();
                    String toSpeak = holder.adjetivo2_name.getText().toString();
                    //tts.setPitch(0);
                    //tts.setSpeechRate(2);
                    tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //hablar(toSpeak);
                    //Toast.makeText(holder.itemView.getContext(),""+holder.animal_name.getText(),Toast.LENGTH_SHORT).show();
                    Toast.makeText(holder.itemView.getContext(),toSpeak,Toast.LENGTH_SHORT).show();
                    //t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                }
            });

        }


        @Override
        public int getItemCount() {
            return LENGTH;
        }


        //ANIMACIONES APLICANDO A LOS ELEMENTOS DE VIEWHOLDER
        @Override
        public void onViewAttachedToWindow(AdjetivosFragment.ViewHolder viewHolder){
            super.onViewAttachedToWindow(viewHolder);
            animateCircularReveal(viewHolder.itemView);
        }

        public void animateCircularReveal(View view){
            int centerX = 1;
            int centerY = 1;
            int startRadius = 0;
            int endRadius = Math.max(view.getWidth(),view.getHeight());
            Animator animation = ViewAnimationUtils.createCircularReveal(view,centerX,centerY,startRadius,endRadius);
            view.setVisibility(View.VISIBLE);
            animation.start();
        }
    }

}
