package br.senai.sp.informatica.projetofilmes.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import br.senai.sp.informatica.projetofilmes.model.Filmes;
import br.senai.sp.informatica.projetofilmes.model.FilmesDao;

/**
 * Created by 29740989837 on 06/12/2017.
 */



public class FilmeAdapter extends BaseAdapter {

    private FilmesDao dao = FilmesDao.manager;


    @Override
    public int getCount() {
        return 0;

    }

    @Override
    public Object getItem(int i) {
        return dao.getLista();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
