package br.senai.sp.informatica.exercicio_lista_de_jogos.Model;

/**
 * Created by WEB on 31/10/2017.
 */

public class Jogo {
    private Long id;
    private String nome;
    private String genero;

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
}
