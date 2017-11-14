package com.example.cristian.flashcards;


import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
//import android.app.FragmentManager;
import android.app.Fragment;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class VerbosFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public TextToSpeech tts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

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
        View recyclerViewVerbos = inflater.inflate(R.layout.recycler_view, container, false);
        recyclerView = (RecyclerView) recyclerViewVerbos.findViewById(R.id.my_recycler_view);
        recyclerView.setHasTransientState(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
        adapter = new VerbosFragment.ContentAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        return recyclerViewVerbos;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView verbo_picture;
        public TextView verbo_name;
        public TextView verbo_description;
        public ImageView verbo_boton;


        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_verbos, parent, false));
            verbo_picture = (ImageView) itemView.findViewById(R.id.verbo_card_image);
            verbo_name = (TextView) itemView.findViewById(R.id.verbo_card_title);
            verbo_description = (TextView) itemView.findViewById(R.id.verbo_card_text);
            verbo_boton = (ImageView) itemView.findViewById(R.id.verbo_boton_play);
            /*
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetalleanimalActivity.class);
                    intent.putExtra(DetalleverboActivity.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });

            */
        }
    }
    /**
     * Adapter to display recycler view.
     */
    public class ContentAdapter extends RecyclerView.Adapter<VerbosFragment.ViewHolder> {
        // Set numbers of List in RecyclerView.
        int LENGTH ;
        private final String[] cVerbo;
        private final String[] cVerboEsp;
        private final Drawable[] cVerboImagenes;
        //variable textTospeech


        TypedArray a;
        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            cVerbo = resources.getStringArray(R.array.verbos);
            cVerboEsp = resources.getStringArray(R.array.verbos_esp);
            a = resources.obtainTypedArray(R.array.verbos_dibujo);
            cVerboImagenes = new Drawable[a.length()];
            LENGTH = a.length();
        }

        @Override
        public VerbosFragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new VerbosFragment.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(final VerbosFragment.ViewHolder holder, int position) {
            holder.verbo_picture.setImageDrawable(a.getDrawable(position));
            holder.verbo_name.setText(cVerbo[position % cVerbo.length]);
            holder.verbo_description.setText(cVerboEsp[position % cVerboEsp.length]);



            holder.verbo_boton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String toSpeak = holder.verbo_name.getText().toString();
                    //tts.setPitch(0);
                    //tts.setSpeechRate(2);
                    tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    Toast.makeText(holder.itemView.getContext(),toSpeak,Toast.LENGTH_SHORT).show();

                }
            });

        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }


        //ANIMACIONES APLICANDO A LOS ELEMENTOS DE VIEWHOLDER
        @Override
        public void onViewAttachedToWindow(VerbosFragment.ViewHolder viewHolder){
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
