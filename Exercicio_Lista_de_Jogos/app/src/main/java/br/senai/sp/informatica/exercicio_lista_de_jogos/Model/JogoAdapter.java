package br.senai.sp.informatica.exercicio_lista_de_jogos.Model;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by WEB on 31/10/2017.
 */

class JogoAdapter extends BaseAdapter {
    private JogoDao dao = JogoDao.manager;


    @Override
    public int getCount() {
        return dao.getLista().size();
    }

    @Override
    public Object getItem(int position) {
        return dao.getJogo(id);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
