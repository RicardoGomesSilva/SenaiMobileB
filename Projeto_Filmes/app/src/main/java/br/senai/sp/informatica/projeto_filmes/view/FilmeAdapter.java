package br.senai.sp.informatica.projeto_filmes.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.senai.sp.informatica.projeto_filmes.R;
import br.senai.sp.informatica.projeto_filmes.model.Filme;
import br.senai.sp.informatica.projeto_filmes.model.FilmeDao;

/**
 * Created by 29740989837 on 21/11/2017.
 */

enum TipoDeDetalhe {
    EDICAO,
    EXCLUSAO;
}

public class FilmeAdapter extends BaseAdapter implements View.OnClickListener {
    private FilmeDao dao = FilmeDao.manager;
    private Map<Integer, Long> mapa;
    private boolean trocouLayout = false;
    private boolean apagar = false;

    public FilmeAdapter() {
        criaMapa();
    }

    @Override
    public void notifyDataSetChanged() {
        criaMapa();
        super.notifyDataSetChanged();
    }

    private void criaMapa() {
        // Cria o mapa de associação de linha:id
        mapa = new HashMap<>();
        // Obtem a lista de Objetos do DAO
        List<Jogo> lista =  dao.getLista();

        // Associa o nº da linha com o id do Jogo
        for(int linha = 0;linha < lista.size();linha++) {
            Jogo jogo = lista.get(linha);
            mapa.put(linha, jogo.getId());
        }
    }

    // Este método é responsável por trocar o
    // layout do detalhe da lista e
    // notificar o listView da mudança
    public void trocouOLayout(TipoDeDetalhe tipo) {
        if(tipo == TipoDeDetalhe.EDICAO) {
            trocouLayout = true;
            apagar = false;
        } else {
            trocouLayout = true;
            apagar = true;
        }
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return mapa.size();
    }

    @Override
    public Object getItem(int id) {
        return dao.getFilme((long)id);
    }

    @Override
    public long getItemId(int linha) {
        return mapa.get(linha);
    }

    @Override
    public View getView(int linha, View view, ViewGroup viewGroup) {

        ConstraintLayout layout;
        if(view == null || trocouLayout) {
            // Obtem o contexto de execução do ListView
            Context ctx = viewGroup.getContext();
            // localizar o serviço de construção do layout
            LayoutInflater inflater =
                    (LayoutInflater)ctx
                            .getSystemService(
                                    Context.LAYOUT_INFLATER_SERVICE);
            // Criar um objeto de Layout
            layout = new ConstraintLayout(ctx);
            // informar o layout xml a ser carregado
            if(!apagar) {
                inflater.inflate(R.layout.filmes_detalhes, layout);
            } else {
                inflater.inflate(R.layout.filmes_detalhes, layout);
            }
        } else {
            layout = (ConstraintLayout)view;
        }

        // o registro da posição solicitada e encontrar o objeto
        // atribuir o objeto ao layout
        TextView txtFilmeNome = (TextView)layout.findViewById(R.id.txtFilmeNome);
        TextView txtFilmeGenero = (TextView)layout.findViewById(R.id.txtFilmeGenero);
        TextView txtFilmeDistribuidora = (TextView)layout.findViewById(R.id.txtFilmeDistribuidora);
        TextView txtFilmeAno = (TextView)layout.findViewById(R.id.txtFilmeAno);
        TextView txtFilmeAssistido = (TextView)layout.findViewById(R.id.txtFilmeAssistido);

        Long id = mapa.get(linha);
        Filme filme = dao.getFilme(id);

        txtFilmeNome.setText(filme.getNomeFilme());
        txtFilmeGenero.setText(filme.getGeneroFilme());
        txtFilmeAno.setText(filme.getAnoLancamento());
        txtFilmeAssistido.setText(filme.getAssistidoFilme().compareTo(true));

        //TODO: Criar um checkBox e registrar o evento de click
        // este evento marcará o Jogo (pelo ID) para exclusão

        if(apagar) {
            CheckBox checkBox = (CheckBox)layout.findViewById(R.id.checkBox);
            checkBox.setTag(filme.getIdFilme());
            checkBox.setOnClickListener(this);
        }

        return layout;
    }

    @Override
    public void onClick(View view) {
        Long id = (Long)view.getTag();
        Filme filme = dao.getFilme(id);
        filme.setExcluir(true/*!filme.setExcluir()*/);

//        Log.d("JogoAdapter", "Jodo marcado para exclusão [" +
//                jogo.isDel() +
//                "] id: " + jogo.getId());

        dao.salvar(filme);
    }
}
