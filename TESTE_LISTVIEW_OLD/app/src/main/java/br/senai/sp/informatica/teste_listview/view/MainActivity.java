package br.senai.sp.informatica.teste_listview.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import br.senai.sp.informatica.teste_listview.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = (ListView) findViewById(R.id.listViewPrincipal);

        String[] valoresDoArray = new String[] {"Fulano", "Ciclano", "Beltrano",
                                                "Fulano", "Ciclano", "Beltrano",
                                                "Fulano", "Ciclano", "Beltrano"};

        ArrayAdapter<String> valoresNoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, valoresDoArray);

        lista.setAdapter(valoresNoAdapter);

        Toast.makeText(MainActivity.this, "SAIU DO ONCREATE", Toast.LENGTH_SHORT).show();

        // OBTEM CLIQUE DE CADA ITEM
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3)
            {
                String strDoItem = (String)adapter.getItemAtPosition(position);

                Toast.makeText(MainActivity.this, "INDICE: [" + (position) + "]  |  "  + "STR DO ITEM: [" + strDoItem + "]", Toast.LENGTH_SHORT).show();

                //cria o objeto para intent
                Intent intentTela = new Intent(getBaseContext(), DetalhesEditarCadastrar.class);


                startActivity(intentTela);
                //tela.putExtra(name:"id",id);
                // isto é para usar uma lista de baseadapter


            }
        });
    }


    ////IMPLEMENTACAO + ITEMSECTED DO MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflaterDoMenu = getMenuInflater();
        inflaterDoMenu.inflate(R.menu.menu_fechar, menu);

        //também pode utilizar ainstrucao abaixo:
        //getMenuInflater().inflate(R.menu.menu_fechar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        Toast.makeText(MainActivity.this, "SELECIONADO - MENU ITEM - FECHAR", Toast.LENGTH_SHORT).show();
        finish();
        return true;
    }

}
