package br.senai.sp.informatica.teste_listview;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
//import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

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
            // exemplo: <activity android:name=".DetalhesEditarCadastrar"/> dentro das tyags <application>

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

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        return true;
    }



}
