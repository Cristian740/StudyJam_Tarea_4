package com.example.cristian.flashcards;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import junit.framework.Test;

/**
 * A simple {@link Fragment} subclass.
 */
public class SoporteFragment extends Fragment {


    public SoporteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.soporte,container,false);
       Button boton_mensaje_gmail=(Button)view.findViewById(R.id.mensaje_gmail_boton);
        Button boton_mensaje_facebook=(Button)view.findViewById(R.id.mensaje_facebook_boton);
        Button boton_mensaje_telegram=(Button)view.findViewById(R.id.mensaje_telegram_boton);
        Button boton_llamada=(Button)view.findViewById(R.id.llamada_celular_boton);

        boton_mensaje_gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                Uri uri = Uri.parse("mailto:cristianrojas.ing@gmail.com");
                intent.setData(uri);
                intent.putExtra("subject", "Consulta FlashCards");
                intent.putExtra("body", "my message");
                startActivity(intent);
            }
        });
        boton_llamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:73590644"));
                startActivity(intent);
            }
        });

        boton_mensaje_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                String facebookUrl = getFacebookPageURL(getActivity());
                facebookIntent.setData(Uri.parse(facebookUrl));
                startActivity(facebookIntent);
            }
        });

        boton_mensaje_telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telegram = new Intent(android.content.Intent.ACTION_SEND);
                telegram.setData(Uri.parse("http://telegram.me/androiddeveloper_gdgcanal"));
                telegram.setPackage("org.telegram.messenger");
                startActivity(Intent.createChooser(telegram, "Speak with"));
            }
        });
        return view;
    }

    public static String FACEBOOK_URL = "https://www.facebook.com/cristianjosue.rojaslopez?ref=hl/";
    public static String FACEBOOK_PAGE_ID = "100002179428952";

    //método que obtiene la verdadera URL
    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //versiones nuevas de facebook
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //versiones antiguas de fb
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }
}
