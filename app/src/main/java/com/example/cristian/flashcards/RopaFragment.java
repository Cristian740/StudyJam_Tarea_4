package com.example.cristian.flashcards;


import android.animation.Animator;
import android.content.Context;
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
public class RopaFragment extends Fragment {


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
        View recyclerViewRopa = inflater.inflate(R.layout.recycler_view, container, false);
        recyclerView = (RecyclerView) recyclerViewRopa.findViewById(R.id.my_recycler_view);
        recyclerView.setHasTransientState(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
        adapter = new RopaFragment.ContentAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        return recyclerViewRopa;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ropa_picture;
        public TextView ropa_name;
        public TextView ropa_description;
        public ImageView ropa_boton;


        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_ropa, parent, false));
            ropa_picture = (ImageView) itemView.findViewById(R.id.ropa_card_image);
            ropa_name = (TextView) itemView.findViewById(R.id.ropa_card_title);
            ropa_description = (TextView) itemView.findViewById(R.id.ropa_card_text);
            ropa_boton = (ImageView) itemView.findViewById(R.id.ropa_boton_play);
            /*
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetalleanimalActivity.class);
                    intent.putExtra(DetalleclimaActivity.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });

            */
        }
    }
    /**
     * Adapter to display recycler view.
     */
    public class ContentAdapter extends RecyclerView.Adapter<RopaFragment.ViewHolder> {
        // Set numbers of List in RecyclerView.
        int LENGTH ;
        private final String[] cRopa;
        private final String[] cRopaEsp;
        private final Drawable[] cRopaImagenes;
        //variable textTospeech


        TypedArray a;
        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            cRopa = resources.getStringArray(R.array.ropa);
            cRopaEsp = resources.getStringArray(R.array.ropa_esp);
            a = resources.obtainTypedArray(R.array.ropa_dibujo);
            cRopaImagenes = new Drawable[a.length()];
            LENGTH = a.length();
        }

        @Override
        public RopaFragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RopaFragment.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(final RopaFragment.ViewHolder holder, int position) {
            holder.ropa_picture.setImageDrawable(a.getDrawable(position));
            holder.ropa_name.setText(cRopa[position % cRopa.length]);
            holder.ropa_description.setText(cRopaEsp[position % cRopaEsp.length]);



            holder.ropa_boton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String toSpeak = holder.ropa_name.getText().toString();
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
        public void onViewAttachedToWindow(RopaFragment.ViewHolder viewHolder){
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
