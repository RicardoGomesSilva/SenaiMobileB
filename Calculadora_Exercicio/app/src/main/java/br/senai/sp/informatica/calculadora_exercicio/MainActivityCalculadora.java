package br.senai.sp.informatica.calculadora_exercicio;

import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivityCalculadora extends AppCompatActivity {

    private EditText    txtResult;
    private Button      btnMais;
    private Button      btnMenos;
    private Button      btnMultiplica;
    private Button      btnDivide;
    private Button      btnPercent;
    private Button      btnMaisMenos;
    private Button      btnIgual;

    String  numero          = "";
    String  numero2         = "";
    String  result          = "";
    String  operacao        = "";
    String  auxiliarStr     = "";
    Integer recebeNmeros    = 0;
    Double  auxDouble       = 0d;
    Integer auxInt          = 0;
    Double  resultado       = 0d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculadora);

        txtResult       = (EditText)findViewById(R.id.txtResult);
        btnMais         = (Button)findViewById(R.id.btnMais);
        btnMenos        = (Button)findViewById(R.id.btnMenos);
        btnMultiplica   = (Button)findViewById(R.id.btnMult);
        btnDivide       = (Button)findViewById(R.id.btnDivide);
        btnPercent      = (Button)findViewById(R.id.btnPercent);
        btnMaisMenos    = (Button)findViewById(R.id.btnMaisMenos);
        btnIgual        = (Button)findViewById(R.id.btnIgual);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    /////// PARA COLOCAR OS ITENS COMO BOTOES NA PARTE SUPERIR É NECESSÁRIO MARCAR NA PROPERTIES: SHOWASACTION: ALWAIS E WITH TEXT >> PARA APARECER A FIGURA É NECESSÁRIO IMPORTA UMA NO DRAWBLE - NEW - IMAGE ACT
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        int corDoFundo;

        switch(id){
            case R.id.menu_teste:
                corDoFundo = getResources().getColor(R.color.colorPrimaryDark);
                break;
            case R.id.menu_app_bar_search:
                corDoFundo = getResources().getColor(R.color.colorPrimaryDark);
                break;
            case R.id.menu_app_bar_switch:
                corDoFundo = getResources().getColor(R.color.colorPrimaryDark);
                finish();
                break;
        }
        return true;
    }

    public void onClickedNumber(View view) {

        btnMultiplica.setEnabled(true);
        btnMais.setEnabled(true);
        btnDivide.setEnabled(true);
        btnMenos.setEnabled(true);
        btnPercent.setEnabled(true);
        btnMaisMenos.setEnabled(true);
        btnIgual.setEnabled(true);

        Toast.makeText(this,"entrou no clicknumero", Toast.LENGTH_SHORT).show() ;

        if (view.getId() == R.id.btn0) {
            recebeNmeros = 0;
        }
        if (view.getId() == R.id.btn1) {
            recebeNmeros = 1;
        }
        if (view.getId() == R.id.btn2) {
            recebeNmeros = 2;
        }
        if (view.getId() == R.id.btn3) {
            recebeNmeros = 3;
        }
        if (view.getId() == R.id.btn4) {
            recebeNmeros = 4;
        }
        if (view.getId() == R.id.btn5) {
            recebeNmeros = 5;
        }
        if (view.getId() == R.id.btn6) {
            recebeNmeros = 6;
        }
        if (view.getId() == R.id.btn7) {
            recebeNmeros = 7;
        }
        if (view.getId() == R.id.btn8) {
            recebeNmeros = 8;
        }
        if (view.getId() == R.id.btn9) {
            recebeNmeros = 9;
        }

        if (operacao.equals("")) {

            Toast.makeText(this,"validou operacao", Toast.LENGTH_SHORT).show() ;

            if (view.getId() == R.id.btnDecimal) {
                Toast.makeText(this,"entrou no btnDecimal", Toast.LENGTH_SHORT).show() ;
                if (!numero.contains(".")) {
                    numero = numero + ".";
                }
            } else {

                numero = numero + recebeNmeros.toString();
            }

            txtResult.setText(numero);

        }else{
            if (view.getId() == R.id.btnDecimal) {
                if (!numero2.contains(".")) {
                    numero2 = numero2 + ".";
                }
            } else {
                numero2 = numero2 + recebeNmeros.toString();
            }

            txtResult.setText(numero2);
        }

//        Toast.makeText(this,"numero:  " + numero, Toast.LENGTH_SHORT).show() ;
//        Toast.makeText(this,"numero2: " + numero2,Toast.LENGTH_SHORT).show() ;

    }

    public void onClickedLimpar(View view) {

        Toast.makeText(this,"entrou no limpar", Toast.LENGTH_SHORT).show() ;

        if (view.getId() == R.id.btnC) {
            numero      = "";
            numero2     = "";
            operacao    = "";
            txtResult.setText("");
            btnMais.setEnabled(true);
            btnMenos.setEnabled(true);
            btnMultiplica.setEnabled(true);
            btnDivide.setEnabled(true);
            btnPercent.setEnabled(true);
            btnMaisMenos.setEnabled(true);
        }
    }

    public void onClickedMaisMenos(View view){

        Toast.makeText(this,"entrou no +/-", Toast.LENGTH_SHORT).show() ;

        if (view.getId() == R.id.btnMaisMenos) {

            if(numero.isEmpty()){
                Toast.makeText(this,"entrou no if", Toast.LENGTH_SHORT).show() ;
                numero = "-";
                txtResult.setText(numero);
            }else if (!numero.isEmpty() && numero2.isEmpty() && operacao.isEmpty()) {
                if (numero.contains(".")) {
                    auxDouble = Double.parseDouble(numero) * -1;
                    numero = auxDouble.toString();
                    txtResult.setText(numero);
                    auxDouble = 0d;
                } else {
                    auxDouble = Double.parseDouble(numero) * -1;
                    auxInt = auxDouble.intValue();
                    numero = auxInt.toString();
                    txtResult.setText(numero);
                    auxInt = 0;
                    auxDouble = 0d;
                }
            }else if (!numero.isEmpty() && numero2.isEmpty() && !operacao.isEmpty()) {
                numero2 = "-";
                txtResult.setText(numero2);
            }else if (!numero.isEmpty() && !numero2.isEmpty() && !operacao.isEmpty()){
                if (numero2.contains(".")) {
                    auxDouble = Double.parseDouble(numero2) * -1;
                    numero2 = auxDouble.toString();
                    txtResult.setText(numero2);
                    auxDouble = 0d;
                } else {
                    auxDouble = Double.parseDouble(numero2) * -1;
                    auxInt = auxDouble.intValue();
                    numero2 = auxInt.toString();
                    txtResult.setText(numero2);
                    auxDouble = 0d;
                    auxInt = 0;
                }
            }

        }

    }

    public void onClickedAcao(View view) {

        Toast.makeText(this,"entrou na acao", Toast.LENGTH_SHORT).show();

            if (view.getId() == R.id.btnMais) {
                operacao = "+";
                btnMais.setEnabled(false);
                btnMenos.setEnabled(false);
                btnMultiplica.setEnabled(false);
                btnDivide.setEnabled(false);
                btnPercent.setEnabled(true);

                txtResult.setText("+");

                Toast.makeText(this, "ACAO + ", Toast.LENGTH_SHORT).show();


            }

            if (view.getId() == R.id.btnMenos) {
                operacao = "-";
                btnMais.setEnabled(false);
                btnMenos.setEnabled(false);
                btnMultiplica.setEnabled(false);
                btnDivide.setEnabled(false);
                btnPercent.setEnabled(true);

                txtResult.setText("-");

                Toast.makeText(this, "ACAO - ", Toast.LENGTH_SHORT).show();
            }

            if (view.getId() == R.id.btnMult) {
                operacao = "*";
                btnMais.setEnabled(false);
                btnMenos.setEnabled(false);
                btnMultiplica.setEnabled(false);
                btnDivide.setEnabled(false);
                btnPercent.setEnabled(true);

                txtResult.setText("*");

                Toast.makeText(this, "ACAO * ", Toast.LENGTH_SHORT).show();
            }

            if (view.getId() == R.id.btnDivide) {
                operacao = "/";
                btnMais.setEnabled(false);
                btnMenos.setEnabled(false);
                btnMultiplica.setEnabled(false);
                btnDivide.setEnabled(false);
                btnPercent.setEnabled(true);

                txtResult.setText("/");

                Toast.makeText(this, "ACAO / ", Toast.LENGTH_SHORT).show();
            }

        }

    public void onClickedResult (View view) {

        Toast.makeText(this,"RESULTADO  numero:  " + numero, Toast.LENGTH_SHORT).show() ;
        Toast.makeText(this,"RESULTADO numero2: " + numero2,Toast.LENGTH_SHORT).show() ;

        if (view.getId() == R.id.btnIgual){

            Toast.makeText(this,"entrou no igual", Toast.LENGTH_SHORT).show() ;

            if (operacao.equals("+")){
                resultado = Double.parseDouble(numero) + Double.parseDouble(numero2);
                Toast.makeText(this,"ACAO + ",Toast.LENGTH_SHORT).show() ;
            }

            if (operacao.equals("-")){
                resultado = Double.parseDouble(numero) - Double.parseDouble(numero2);
                Toast.makeText(this,"ACAO - ",Toast.LENGTH_SHORT).show() ;
            }

            if (operacao.equals("*")){
                resultado = Double.parseDouble(numero) * Double.parseDouble(numero2);
                Toast.makeText(this,"ACAO * ",Toast.LENGTH_SHORT).show() ;
            }

            if (operacao.equals("/")){
                resultado = Double.parseDouble(numero) / Double.parseDouble(numero2);
                Toast.makeText(this,"ACAO / ",Toast.LENGTH_SHORT).show() ;
            }

            Toast.makeText(this,"resultado: " + resultado.toString(),Toast.LENGTH_SHORT).show() ;

            auxiliarStr = resultado.toString();

            if(auxiliarStr.contains(".0")){
                auxInt = resultado.intValue();
                txtResult.setText(resultado.toString());
            }else{
                txtResult.setText(resultado.toString());
            }

        }

            if (view.getId() == R.id.btnPercent) {

                Toast.makeText(this,"entrou no percent", Toast.LENGTH_SHORT).show() ;

/*
               if(operacao.contains("+") || operacao.contains("-") || operacao.contains("*") || operacao.contains("/")) {

                    Toast.makeText(this,"entrou no contains*-/+", Toast.LENGTH_SHORT).show() ;

                    resultado = (Double.parseDouble(numero) * Double.parseDouble(numero2) / 100);

                    auxiliarStr = resultado.toString();

                    if(auxiliarStr.contains(".0")){
                        auxInt = resultado.intValue();
                        txtResult.setText(resultado.toString());
                    }else{
                        txtResult.setText(resultado.toString());
                    }

                }
*/
                if(operacao.contains("*")) {

                    Toast.makeText(this,"entrou no contains+-*/", Toast.LENGTH_SHORT).show() ;

                    resultado = (Double.parseDouble(numero) * (Double.parseDouble(numero2) / 100));

                    auxiliarStr = resultado.toString();

                    if(auxiliarStr.contains(".0")){
                        auxInt = resultado.intValue();
                        txtResult.setText(resultado.toString());
                    }else{
                        txtResult.setText(resultado.toString());
                    }

                }

                if(operacao.contains("+")) {

                    Toast.makeText(this,"entrou no contains+-*/", Toast.LENGTH_SHORT).show() ;

                    resultado = (Double.parseDouble(numero)) * (1.0d + (Double.parseDouble(numero2) / 100));

                    auxiliarStr = resultado.toString();

                    if(auxiliarStr.contains(".0")){
                        auxInt = resultado.intValue();
                        txtResult.setText(resultado.toString());
                    }else{
                        txtResult.setText(resultado.toString());
                    }

                }

                if(operacao.contains("-")) {

                    Toast.makeText(this,"entrou no contains+-*/", Toast.LENGTH_SHORT).show() ;

                    resultado = (Double.parseDouble(numero)) * (1.0d - (Double.parseDouble(numero2) / 100));

                    auxiliarStr = resultado.toString();

                    if(auxiliarStr.contains(".0")){
                        auxInt = resultado.intValue();
                        txtResult.setText(resultado.toString());
                    }else{
                        txtResult.setText(resultado.toString());
                    }

                }

                if(operacao.contains("/")) {

                    Toast.makeText(this,"entrou no contains+-*/", Toast.LENGTH_SHORT).show() ;

                    resultado = (Double.parseDouble(numero) / (Double.parseDouble(numero2) / 100));

                    auxiliarStr = resultado.toString();

                    if(auxiliarStr.contains(".0")){
                        auxInt = resultado.intValue();
                        txtResult.setText(resultado.toString());
                    }else{
                        txtResult.setText(resultado.toString());
                    }
////// 50 /
                }
            }

        numero      = "";
        numero2     = "";
        operacao    = "";
        resultado   = 0d;
        btnMultiplica.setEnabled(false);
        btnMais.setEnabled(false);
        btnDivide.setEnabled(false);
        btnMenos.setEnabled(false);
        btnPercent.setEnabled(false);
        btnMaisMenos.setEnabled(false);
        btnIgual.setEnabled(false);

    }

    @SuppressWarnings("serial")
    class CalculadoraException extends Exception{
        
    }

}
