package br.senai.sp.informatica.projeto_filmes.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 * Created by 29740989837 on 17/11/2017.
 */

public class FilmeDao {

    public static FilmeDao manager = new FilmeDao();

    private List<Filme> listaFilme;

    private long idFilme = 0;

    private FilmeDao(){
        listaFilme = new ArrayList<>();
        listaFilme.add(new Filme(idFilme++, "Teste Filme 1", "Luta", "Columbia","2017",true));
        listaFilme.add(new Filme(idFilme++, "Teste Filme 2", "Guerra","Warner","2017",false));
    }

    public List<Filme> getLista() {
        // suportado no Java 8
        Collections.sort(listaFilme);
        return Collections.unmodifiableList(listaFilme);
        // suportado em todas as versões do Java
        // return Collections.synchronizedList(lista);
    }

    public Filme getFilme(final Long idFilme) {
        // Pesquisa tradicional
        Filme oFilme = null;
        for(Filme obj : listaFilme) {
            if(obj.getIdFilme() == idFilme) {
                oFilme = obj;
                break;
            }
        }

        // Pesquisa utilizando o recurso de Collections
        // necessita que a classe tenha construtor especializado
        // além da implementação dos métodos equals e hashcode
        Filme filmeLocalizado = listaFilme.get(listaFilme.indexOf(new Filme(idFilme)));

        // Utiliza a implementação funcional em Java 8
//        Jogo outroJogo = lista.stream()
//                .filter(obj -> obj.getId() == id)
//                .findAny().orElse(null);

        return oFilme;
    }

    public void salvar(Filme obj) {
        // Se o objeto não tem ID é reconhecido como
        // novo objeto a ser incluido na lista
        if(obj.getIdFilme() == null) {
            obj.setIdFilme(idFilme++);
            listaFilme.add(obj);
        } else {
            // caso contrário é efetuada pesquisa
            // para localizar o objeto antigo na lista
            // pelo id para que seja substituido
            int posicao = listaFilme.indexOf(new Filme(obj.getIdFilme()));
            listaFilme.set(posicao, obj);
        }
    }

    public void remover(Long id) {
        // Localiza o objeto pelo id informado
        // e em seguida remove da lista
        fil.remove(new Jogo(id));
    }


    /*
        médoto utilizado para remover todos os jogos selecionados para exclusão
     */
    public void apagarOsSelecionados() {
        // Constroi a lista dos Jogos a serem removidos
        List<Jogo> osJogos = new ArrayList<>();
        for(Jogo obj : lista) {
            if(obj.isDel()) {
                osJogos.add(obj);
            }
        }

        // Remove todos os Jogos da lista dos excluiveis
        for(Jogo jogo : osJogos) {
            remover(jogo.getId());
        }
    }


}
