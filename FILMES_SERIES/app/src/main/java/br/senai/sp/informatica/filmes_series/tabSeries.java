package br.senai.sp.informatica.filmes_series;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 29740989837 on 30/11/2017.
 */

public class tabSeries extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_series, container, false);

        return rootView;
    }

}
