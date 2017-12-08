package br.senai.sp.informatica.projetofilmes.model;

import android.util.Log;

/**
 * Created by 29740989837 on 06/12/2017.
 */

public class Filmes {

    //DEFINICAO DE TAG CONSTANTE PARA LOG DO DEBUG
    private static final String TAG = "DEBUG_PEOJETOSFILMES";


    private Long    id;
    private String  nome;
    private String  genero;
    private String  produtora;
    private Boolean assistido;
    private String  assistidoData;
    private Integer rankingFilme;

    //CONTRUTOR
    public Filmes(Long id, String nome, String genero, String produtora, Boolean assistido, String assistidoData, Integer rankingFilme) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.produtora = produtora;
        this.assistido = assistido;
        this.assistidoData = assistidoData;
        this.rankingFilme = rankingFilme;

        Log.d(TAG, "... CLASSE: Filmes: ENTROU NO CONTRUTOR ...");

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public Boolean getAssistido() {
        return assistido;
    }

    public void setAssistido(Boolean assistido) {
        this.assistido = assistido;
    }

    public String getAssistidoData() {
        return assistidoData;
    }

    public void setAssistidoData(String assistidoData) {
        this.assistidoData = assistidoData;
    }

    public Integer getRankingFilme() {
        return rankingFilme;
    }

    public void setRankingFilme(Integer rankingFilme) {
        this.rankingFilme = rankingFilme;
    }

}

