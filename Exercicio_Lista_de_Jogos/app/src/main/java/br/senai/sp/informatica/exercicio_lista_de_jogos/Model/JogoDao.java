package br.senai.sp.informatica.exercicio_lista_de_jogos.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by WEB on 31/10/2017.
 */

public class JogoDao {
    public static JogoDao manager = new JogoDao();
    private List<Jogo> lista;
    private long id = 0;

    //construtor - criada do tipo private para só ela mesmo chamar
    // é utilizada desmo modo por ser do tipo statefull (como é uma lista ela é stateless)
    private JogoDao(){
        lista = new ArrayList<>();

        ////isto abaixo foi criado apenas para chumbar dois registros

        lista.add(new Jogo(id++,nome:"MortalKombat"))

    }


    public List<Jogo> getLista(){
        return Collections.unmodifiableList(lista);

        //este comentário é pelo motivo de ser suportyado em todas versoes do Java
        //return Collections.

    }

    public Jogo getJogo(final Long id){

        Jogo oJogo = null;
        for(Jogo obj : lista){
            if(obj.getId() == id){
                oJogo = obj;
                break;
            }
        }

        // exmeplo em lambda::::::
        //Jogo outroJogo = lista.stream().filter(obj -> obj.getId() == id).findAny().orElse(other: null);

        return null;
    }

    public void salvar(Jogo obj){
        if(obj.getId() != null){
            obj.setId(id++);
            lista.add(obj);
        }else{

            Jogo jogoLocalizado = getJogo(obj.getId());



            /////  precisa atualizar este campo
            ////// int posicao = lista.indexOf(new Jogo(obj.getId()));
            ////// lista.set(posicao,obj);


        }
    };

    public void remover(Long id){};
  ///// precisa atualizar este campo
  ///  lista.remove(new Jogo(id));

}
