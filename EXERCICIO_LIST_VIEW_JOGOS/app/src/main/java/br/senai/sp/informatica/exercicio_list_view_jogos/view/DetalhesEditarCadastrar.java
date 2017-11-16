package br.senai.sp.informatica.exercicio_list_view_jogos.view;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
//import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import br.senai.sp.informatica.exercicio_list_view_jogos.R;

//import android.support.v7.app.ActionBar;

/**
 * Created by WEB on 07/11/2017.
 */

public class DetalhesEditarCadastrar extends AppCompatActivity {

    @Override
    protected void onCreate(/*@Nullable*/ Bundle savedInstanceState){ // pode ser nullable
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detalhes_layout);

        //criacao da actionbar
        ActionBar actionBar = getActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);

            //necessário registrar a activity (actionbar) no androidmanifest.xml
            // exemplo: <activity android:name=".DetalhesEditarCadastrar"/> dentro das tags <application>

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflaterDoMenu = getMenuInflater();
        inflaterDoMenu.inflate(R.menu.menu_detalhes_layout, menu);
        //também pode utilizar ainstrucao abaixo:
        //getMenuInflater().inflate(R.menu.menu_fechar, menu);
        return true;
    }



    // para fazer com que a actionbar retorne, é necessário colocar o finish no onOptionsItemSelected
    // se não tivesse declarado onOptionsItemSelected, nao seria obrigado colocar o finish();
    //o finish fecha o a activitie
    @Override
    public boolean onOptionsItemSelected (MenuItem item){



        int id = item.getItemId();
        switch (id){

            case android.R.id.home:
                //este é a flecha da actionbar
                Toast.makeText(this, "home clicado", Toast.LENGTH_LONG).show();
                break;

            case R.id.itemSalvar:
                //botao de salvar do menu
                /*if()*/
                break;
        }

        finish();
        return true;
    }



}
