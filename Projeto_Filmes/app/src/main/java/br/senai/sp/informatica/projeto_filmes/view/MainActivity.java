package br.senai.sp.informatica.projeto_filmes.view;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.TabHost;
import android.widget.Toast;

import br.senai.sp.informatica.projeto_filmes.R;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        // create the TabHost that will contain the Tabs
        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);

        TabHost.TabSpec tab1  = tabHost.newTabSpec("FILMES");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("SERIES");

        // Set the Tab name and Activity
        // that will be opened when particular Tab will be selected
        tab1.setIndicator("FILMES");
        tab1.setContent(new Intent(this, AbaFilmes.class));

        tab2.setIndicator("SERIES");
        tab2.setContent(new Intent(this,AbaSeries.class));


        // Add the tabs  to the TabHost to display. //
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);

*/




        Toast.makeText(getApplicationContext(), "TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE "+
                        "TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE ",
                Toast.LENGTH_LONG).show();


    }
}
