package br.senai.sp.informatica.projetofilmes.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 29740989837 on 06/12/2017.
 */

public class FilmesDao {

    //DEFINICAO DE TAG CONSTANTE PARA LOG DO DEBUG
    private static final String TAG = "DEBUG_PEOJETOSFILMES";

    //INSTANCIA UNICA (SESSION) DO OBJETO
    public static FilmesDao manager = new FilmesDao();

    //CRIA LISTA
    private List<Filmes> listaFilmes = new ArrayList<>();

    //INCIALIZA GERADOR DO ID
    private long id = 0;

    //CONTRUTOR INICIALIZAR LISTA TEMPORARIA
    private FilmesDao() {

        Log.d(TAG, "... CLASSE: FilmesDao CONTRUTOR DA LISTA ...");

        listaFilmes.add(new Filmes(id++, "TESTE", "TESTE", "TESTE", true, "1990", 5));
        listaFilmes.add(new Filmes(id++, "DEAD POOL", "AÇÃO", "MARVEL", true, "2017", 8));
        listaFilmes.add(new Filmes(id++, "AVENGERS", "AÇÃO", "MARVEL", true, "2013", 7));
        listaFilmes.add(new Filmes(id++, "TWD", "TERROR", "AMC", true, "2010", 8));
        listaFilmes.add(new Filmes(id++, "FTWD", "AÇÃO", "AMC", true, "2015", 8));

    }

    //metodo para obter retorno da lista
    public List<Filmes> getLista() {

        Log.d(TAG, "... CLASSE: FilmesDao getLista ...");



        //return com lista ordenada
        //Collections.sort(listaFilmes);
        //return Collections.unmodifiableList(listaFilmes);

        //para obter em qualque order
        return listaFilmes;
    }


    //médoto para a obter o ID de um obj Filme (do construtor)
    public Filmes getFilme(final Long id) {

        Filmes idFilme = null;

        for (Filmes obj : listaFilmes) {
            if (obj.getId() == id) {
                idFilme = obj;
                break;
            }
        }

        return idFilme;
    }

}
