package br.senai.sp.informatica.projetofilmes.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 29740989837 on 06/12/2017.
 */

public class FilmesDao {

    //INSTANCIA UNICA (SESSION) DO OBJETO
    public static FilmesDao manager = new FilmesDao();

    //CRIA LISTA
    private List<Filmes> lista = new ArrayList<>();

    //INCIALIZA GERADOR DO ID
    private long id = 0;

    //CONTRUTOR INICIALIZAR LISTA TEMPORARIA
    private FilmesDao() {

        lista.add(new Filmes(id++, "TESTE", "TESTE", "TESTE", true, "1990", 5));
        lista.add(new Filmes(id++, "DEAD POOL", "AÇÃO", "MARVEL", true, "2017", 8));
        lista.add(new Filmes(id++, "AVENGERS", "AÇÃO", "MARVEL", true, "2013", 7));
        lista.add(new Filmes(id++, "TWD", "TERROR", "AMC", true, "2010", 8));
        lista.add(new Filmes(id++, "FTWD", "AÇÃO", "AMC", true, "2015", 8));

    }

    //metodo para obter retorno da lista
    public List<Filmes> getLista() {

        return lista;

        //para retorno de lista ordenada
        //Collections.sort(lista);
        //return Collections.unmodifiableList(lista);
    }



}
