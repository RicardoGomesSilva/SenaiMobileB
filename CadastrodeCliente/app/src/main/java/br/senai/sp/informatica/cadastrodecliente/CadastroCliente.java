package br.senai.sp.informatica.cadastrodecliente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadastroCliente extends AppCompatActivity
  implements View.OnClickListener{
    private Button btVai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        btVai = (Button)findViewById(R.id.btVai);
        btVai.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, TelaSecundaria.class);
    }
}
