package com.example.cristian.flashcards;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdjetivesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.item_adjetives,container,false);
        TableLayout tabla_contenedora = (TableLayout) view.findViewById(R.id.tabla_adjetives);
        Tabla tabla_adjetivos = new Tabla(getActivity(),tabla_contenedora);
        tabla_adjetivos.agregarCabecera(R.array.cabecera_tabla_adjetivos);

        List<String> adjetive_base = Arrays.asList(getResources().getStringArray(R.array.adjetive_base));
        List<String> adjetive_comparative = Arrays.asList(getResources().getStringArray(R.array.adjetive_comparative));
        List<String> adjetive_superlative = Arrays.asList(getResources().getStringArray(R.array.adjetive_superlative));
        List<String> adjetive_meaning = Arrays.asList(getResources().getStringArray(R.array.adjetive_meaning));
        int cantidad_elementos = adjetive_base.size();
        for(int i = 0; i < cantidad_elementos; i++)
        {
            ArrayList<String> elementos = new ArrayList<String>();
            elementos.add(adjetive_base.get(i));
            elementos.add(adjetive_comparative.get(i));
            elementos.add(adjetive_superlative.get(i));
            elementos.add(adjetive_meaning.get(i));
            tabla_adjetivos.agregarFilaTabla(elementos);
        }
        return view;

    }

}
