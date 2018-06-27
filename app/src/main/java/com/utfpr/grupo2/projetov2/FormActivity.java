package com.utfpr.grupo2.projetov2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        setTitle("Cadastro");
    }

    public void showMessage(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    public boolean enviarForm(View v){

        EditText txtnomeDisciplina = (EditText)findViewById(R.id.nomeDisciplina);
        EditText txtTotalAulas = (EditText)findViewById(R.id.totalAulas);
        EditText txtpercentFaltasPossiveis = (EditText)findViewById(R.id.percentFaltasPossiveis);
        EditText txtFaltasInicial = (EditText)findViewById(R.id.faltasIncial);

        String nomeDisciplina = txtnomeDisciplina.getText().toString();
        int faltasInicial = Integer.parseInt(txtFaltasInicial.getText().toString());
        int percentFaltasPossiveis = Integer.parseInt(txtpercentFaltasPossiveis.getText().toString());
        int totalAulas = Integer.parseInt(txtTotalAulas.getText().toString());

//        if(nomeDisciplina.equals("") || percentFaltasPossiveis.equals("")){
//            showMessage("Preecha todos os campos para continuar!");
//            return false;
//        }

        BancoController crud = new BancoController(getBaseContext());
        String resultado = crud.insereDados(nomeDisciplina,totalAulas,faltasInicial,percentFaltasPossiveis);
        Toast.makeText(getApplicationContext(),resultado,Toast.LENGTH_SHORT).show();
        finish();

        return true;
    }
}
