package br.senai.sp.informatica.projetofilmes.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.senai.sp.informatica.projetofilmes.R;
import br.senai.sp.informatica.projetofilmes.model.Filmes;

/**
 * Created by 29740989837 on 06/12/2017.
 */

public class PrincipalActivity extends AppCompatActivity {

    ListView listViewFilmes = (ListView) findViewById(R.id.listViewFilmes);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);



    }

}
