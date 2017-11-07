package br.senai.sp.informatica.exerciciojurossimples;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class JurosSimples extends AppCompatActivity {

    private EditText    txtCapitalInicial;
    private EditText    txtTaxa;
    private EditText    txtResultante;
    private EditText    txtMeses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Registro do Layout
        setContentView(R.layout.activity_juros_simples);

        //Registro dos Componentes
        txtCapitalInicial   = (EditText)findViewById(R.id.txtCapitalInicial);
        txtTaxa             = (EditText)findViewById(R.id.txtTaxa);
        txtResultante       = (EditText)findViewById(R.id.txtResultante);
        txtMeses            = (EditText)findViewById(R.id.txtMeses);

        //Manda o foco
        txtCapitalInicial.requestFocus();
    }

public void onClicked(View view){
//    if(view instanceof  Button) {
//        Button bt = (Button) view;
//    }
//    if(view.getId() == R.id.btnCalcular) {
//    }
   // Button calcular = R.id.btnCalcular;
  //  Button limpar = R.id.btnLimpar;

    //Identifica o botão que foi clicado
    if(view.getId() == R.id.btnCalcular) {
        try{
            //String msgAlertaNulo = getResources().getString(R.string.
            if(txtCapitalInicial.getText().toString().equals("") ) {
                txtCapitalInicial.requestFocus();
                Toast.makeText(this,"Insira o valor do CAPITAL",Toast.LENGTH_SHORT).show() ;

            }else if(txtTaxa.getText().toString().equals("")){
                txtTaxa.requestFocus();
                Toast.makeText(this,"Insira a TAXA MENSAL",Toast.LENGTH_SHORT).show();

            }else if (txtMeses.getText().toString().equals("")){
                txtMeses.requestFocus();
                Toast.makeText(this,"Insira a quantidade de MESES",Toast.LENGTH_SHORT).show();

            } else {
                //exemplo de formatador de numeros
                //NumberFormat fmt = NumberFormat.getNumberInstance();
                //fmt.setMaximmFraction(2)


            double capitalInicial = Double.parseDouble(txtCapitalInicial.getText().toString());

            double taxa = Double.parseDouble(txtTaxa.getText().toString());
            int meses = Integer.parseInt(txtMeses.getText().toString());
            double resultado = (capitalInicial * taxa / 100 * meses) + capitalInicial;


            //txtResultante.setText(String.format("%,.2f",resultado + ""));
            txtResultante.setText(resultado + "");
        }
        }catch (Exception ex){
            Toast.makeText(this,"NÚMERO INVALIDO",Toast.LENGTH_SHORT).show();
        }
    }

    if(view.getId() == R.id.btnLimpar) {

        String limpar = "";

        txtCapitalInicial.setText(limpar);
        txtTaxa.setText(limpar);
        txtResultante.setText(limpar);
        txtMeses.setText(limpar);
        txtCapitalInicial.requestFocus();
    }

}

}
