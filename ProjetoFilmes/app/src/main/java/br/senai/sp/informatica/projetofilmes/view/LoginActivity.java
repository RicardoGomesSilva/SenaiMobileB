package br.senai.sp.informatica.projetofilmes.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.senai.sp.informatica.projetofilmes.R;

public class LoginActivity extends AppCompatActivity {

    //DEFINICAO DE TAG CONSTANTE PARA LOG DO DEBUG
    private static final String TAG = "QuickNotesMainActivity";

    //DEFINICAO DE COMPONENTES DA VIEW
    private Button   btnEntrar;
    private EditText txtLogin;
    private EditText txtSenha;
    private TextView txtLembrete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //ATRIBUICAO DOS COMPONENTES DA VIEW
        txtLogin    = (EditText) findViewById(R.id.txtLogin);
        txtSenha    = (EditText) findViewById(R.id.txtSenha);
        txtLembrete = (TextView) findViewById(R.id.txtLembrete);

    }

    public void onClickEntrar(View view) {

        Log.d(TAG, "... CLICOU NO BOTAO ...");

        String login = "aaa";
        String senha = "111";

        try {
            if(txtLogin.getText().toString().isEmpty()) {

                Toast.makeText(this, "INSIRA O LOGIN !", Toast.LENGTH_LONG).show();

            }else if(txtSenha.getText().toString().isEmpty()){

                Toast.makeText(this, "INSIRA A SENHA !", Toast.LENGTH_LONG).show();

            } else {

                if (txtLogin.getText().toString().equals(login) || txtSenha.getText().toString().equals(senha)) {
                    Log.d(TAG, "... OK ...");

                    Intent intent = new Intent(this, PrincipalActivity.class);
                    startActivity(intent);

                } else {

                    Toast.makeText(this, "LOGIN / SENHA INCORRETOS !", Toast.LENGTH_LONG).show();
                    Log.d(TAG, "... LOGIN / SENHA INCORRETOS ! ...");

                }
            }
        }
        catch (Exception ex){
            Toast.makeText(this, "VALORES(S) INVÁLIDO(S)!", Toast.LENGTH_LONG).show();
            Log.d(TAG, "... EXCEPTION: " + ex + " ...");

        } finally {

            Log.d(TAG, "... FINALLY ...");
        }
    }
}
