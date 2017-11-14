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
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
public class SentencesFragment extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.item_verbos, null);

        //esto se utiliza en Recycler View
        View recyclerViewSentences = inflater.inflate(R.layout.recycler_view, container, false);
        recyclerView = (RecyclerView) recyclerViewSentences.findViewById(R.id.my_recycler_view);
        recyclerView.setHasTransientState(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
        adapter = new SentencesFragment.ContentAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        return recyclerViewSentences;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView tense_picture;
        public TextView tense_name;
        public ImageView tense_boton;


        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_tenses, parent, false));
            tense_picture = (ImageView) itemView.findViewById(R.id.tense_card_image);
            tense_name = (TextView) itemView.findViewById(R.id.tense_card_title);
            tense_boton = (ImageView) itemView.findViewById(R.id.tense_boton_detalle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetallesentenceActivity.class);
                    intent.putExtra(DetalleanimalActivity.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }
    /**
     * Adapter to display recycler view.
     */
    public class ContentAdapter extends RecyclerView.Adapter<SentencesFragment.ViewHolder> {
        // Set numbers of List in RecyclerView.
        int LENGTH ;
        private final String[] cTense;
        private final Drawable[] cTenseImagenes;
        //variable textTospeech


        TypedArray a;
        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            cTense = resources.getStringArray(R.array.tenses_name);
            a = resources.obtainTypedArray(R.array.tense_dibujo);
            cTenseImagenes = new Drawable[a.length()];
            LENGTH = a.length();
        }

        @Override
        public SentencesFragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SentencesFragment.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(final SentencesFragment.ViewHolder holder, int position) {
            holder.tense_picture.setImageDrawable(a.getDrawable(position));
            holder.tense_name.setText(cTense[position % cTense.length]);
            holder.tense_boton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String titulo = holder.tense_name.getText().toString();
                  //  Toast.makeText(holder.itemView.getContext(),"Presiona el item "+titulo+ "para mas informacion",Toast.LENGTH_LONG).show();
                    Snackbar.make(view, "Presiona el item "+ titulo + " para mas informacion",
                            Snackbar.LENGTH_LONG).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }


        //ANIMACIONES APLICANDO A LOS ELEMENTOS DE VIEWHOLDER
        @Override
        public void onViewAttachedToWindow(SentencesFragment.ViewHolder viewHolder){
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
