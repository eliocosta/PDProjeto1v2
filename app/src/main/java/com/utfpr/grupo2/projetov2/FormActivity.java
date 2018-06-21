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
        RadioGroup radioSemestre = (RadioGroup)findViewById(R.id.radioSemestre);
        EditText txtpercentFaltasPossiveis = (EditText)findViewById(R.id.percentFaltasPossiveis);

        String nomeDisciplina = txtnomeDisciplina.getText().toString();
        int percentFaltasPossiveis = Integer.parseInt(txtpercentFaltasPossiveis.getText().toString());

        String periodo = "20181";

//        if(nomeDisciplina.equals("") || percentFaltasPossiveis.equals("")){
//            showMessage("Preecha todos os campos para continuar!");
//            return false;
//        }

//        Intent intent = new Intent(this, ResultActivity.class);
//        Bundle params = new Bundle();
//
//        params.putString("nome_disciplina", nomeDisciplina);
//        params.putString("percent_faltas", percentFaltasPossiveis);
//
//        intent.putExtras(params);
//        startActivity(intent);

        BancoController crud = new BancoController(getBaseContext());
        String resultado = crud.insereDados(nomeDisciplina,periodo,percentFaltasPossiveis);
        Toast.makeText(getApplicationContext(),resultado,Toast.LENGTH_SHORT).show();
        finish();



        return true;
    }
}
