package br.senai.sp.informatica.projetofilmes.view;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.senai.sp.informatica.projetofilmes.model.Filmes;
import br.senai.sp.informatica.projetofilmes.model.FilmesDao;

/**
 * Created by 29740989837 on 06/12/2017.
 */



public class FilmeAdapter extends BaseAdapter {

    //DEFINICAO DE TAG CONSTANTE PARA LOG DO DEBUG
    private static final String TAG = "DEBUG_PEOJETOSFILMES";

    //delaracoes para utilizacao da classe
    private FilmesDao filmesDao = FilmesDao.manager;
    private Map<Integer, Long> adapterMap;


    //criacao do adapterMapa (MAP)
    private void criaMapa() {

        // Cria o mapa de associação de linha:id
        adapterMap = new HashMap<>();

        // pega a lista de Objetos do DAO
        List<Filmes> listaFilme =  filmesDao.getLista();

        // associa item com o id do filme
        for(int item = 0;item < listaFilme.size();item++) {
            Filmes filme = listaFilme.get(item);
            adapterMap.put(item, filme.getId());
        }
    }


    @Override
    public int getCount() {

        Log.d(TAG, "... CLASSE: FilmeAdapter getCount ...");

        //retorna o tamenho da lista de filmes (adiquirida pelo map)
        return adapterMap.size();

    }

    @Override
    public Object getItem(int id) {

        Log.d(TAG, "... CLASSE: FilmeAdapter getItem ...");

        return filmesDao.getFilme((long)id);
    }

    @Override
    public long getItemId(int i) {

        Log.d(TAG, "... CLASSE: FilmeAdapter getItemId ...");

        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Log.d(TAG, "... CLASSE: FilmeAdapter getView ...");

        return null;
    }
}
