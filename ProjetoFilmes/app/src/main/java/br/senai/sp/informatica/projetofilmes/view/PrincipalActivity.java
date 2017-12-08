package br.senai.sp.informatica.projetofilmes.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.senai.sp.informatica.projetofilmes.R;
import br.senai.sp.informatica.projetofilmes.model.Filmes;
import br.senai.sp.informatica.projetofilmes.model.FilmesDao;

/**
 * Created by 29740989837 on 06/12/2017.
 */

public class PrincipalActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener, DialogInterface.OnClickListener {

    //DEFINICAO DE TAG CONSTANTE PARA LOG DO DEBUG
    private static final String TAG = "DEBUG_PEOJETOSFILMES";

    //
    private FilmesDao dao = FilmesDao.manager;

    //declaracoes da classe
    private ListView listViewFilmes;
    private FilmeAdapter itemDaListaFilmeAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Log.d(TAG, "... CLASSE: PrincipalActivity: ENTROU NO ON CREATE ...");

        // referencia a lista
        listViewFilmes = (ListView) findViewById(R.id.listViewFilmes);


        // Cria o Adapter para que ele forneça os dados para o ListView
        itemDaListaFilmeAdapter = new FilmeAdapter();


        // Registra o adapter no ListView
        listViewFilmes.setAdapter(itemDaListaFilmeAdapter);


        // Direciona o 'click' para o metodo onitemclick
        listViewFilmes.setOnItemClickListener(this);

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

    }

    //click sob o item da lista
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        // é criado um Intent para definir ao Android qual Activity será chamada
        Intent intentDetalhesFilmeActivity = new Intent(getBaseContext(), DetalhesFilmeActivity.class);

        /*
        // é passado o ID do objeto para a nova Activity a fim de informar
        // qual Jogo deverá ser editado
        intentDetalhesFilmeActivity.putExtra("id", id);
        // é solicitado ao Android que seja iniciada a execução de uma nova Activity
        // porém também é solicitado informar quando esta activity retornar
        startActivityForResult(tela, EDITA_JOGO);
        */
    }
}
