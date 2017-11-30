package br.senai.sp.informatica.projeto_filmes.model;

import android.support.annotation.NonNull;

import java.util.Date;

/**
 * Created by 29740989837 on 17/11/2017.
 */

public class Filme implements Comparable<Filme>{

    private Long idFilme;
    private String nomeFilme;
    private String generoFilme;
    private String distribuidoraFilme;
    private String anoLancamento;
    private Boolean assistidoFilme;

    //atibuto se marcado para exclusão
    private Boolean excluir;

    public Filme() {
    }

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getGeneroFilme() {
        return generoFilme;
    }

    public void setGeneroFilme(String generoFilme) {
        this.generoFilme = generoFilme;
    }

    public String getDistribuidoraFilme() {
        return distribuidoraFilme;
    }

    public void setDistribuidoraFilme(String distribuidoraFilme) {
        this.distribuidoraFilme = distribuidoraFilme;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Date dtLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Boolean getAssistidoFilme() {
        return assistidoFilme;
    }

    public void setAssistidoFilme(Boolean assistidoFilme) {
        this.assistidoFilme = assistidoFilme;
    }

    public Boolean getExcluir() {
        return excluir;
    }

    public void setExcluir(Boolean excluir) {
        this.excluir = excluir;
    }

    @Override
    public int compareTo(@NonNull Filme filme) {
        return 0;
    }
}

