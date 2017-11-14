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
public class IrregularverbsFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //esto se utiliza en Recycler View
        View view = inflater.inflate(R.layout.item_irregularverbs,container,false);
        TableLayout tabla_contenedora = (TableLayout) view.findViewById(R.id.tabla);
        Tabla tabla = new Tabla(getActivity(),tabla_contenedora);
        tabla.agregarCabecera(R.array.cabecera_tabla_verbs);

        List<String> verb_inf = Arrays.asList(getResources().getStringArray(R.array.verb_base));
        List<String> verb_simple = Arrays.asList(getResources().getStringArray(R.array.verb_simple));
        List<String> verb_participle = Arrays.asList(getResources().getStringArray(R.array.verb_participle));
        List<String> verb_meaning = Arrays.asList(getResources().getStringArray(R.array.verb_meaning));
        int cantidad_elementos = verb_inf.size();
        for(int i = 0; i < cantidad_elementos; i++)
        {
            ArrayList<String> elementos = new ArrayList<String>();
            elementos.add(verb_inf.get(i));
            elementos.add(verb_simple.get(i));
            elementos.add(verb_participle.get(i));
            elementos.add(verb_meaning.get(i));
            tabla.agregarFilaTabla(elementos);
        }
        return view;

    }
}
