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
        EditText txtaulasSemestre = (EditText)findViewById(R.id.aulasSemestre);
        EditText txtpercentFaltasPossiveis = (EditText)findViewById(R.id.percentFaltasPossiveis);
        EditText txtfaltasJaExistentes = (EditText)findViewById(R.id.faltasJaExistentes);

        String nomeDisciplina = txtnomeDisciplina.getText().toString();
        String aulasSemestre = txtaulasSemestre.getText().toString();
        String percentFaltasPossiveis = txtpercentFaltasPossiveis.getText().toString();
        String faltasJaExistentes = txtfaltasJaExistentes.getText().toString();

        if(nomeDisciplina.equals("") || aulasSemestre.equals("") || percentFaltasPossiveis.equals("") || faltasJaExistentes.equals("")){
            showMessage("Preecha todos os campos para continuar!");
            return false;
        }

        Intent intent = new Intent(this, ResultActivity.class);
        Bundle params = new Bundle();

        params.putString("nome_disciplina", nomeDisciplina);
        params.putString("aulas_semestre", aulasSemestre);
        params.putString("percent_faltas", percentFaltasPossiveis);
        params.putString("faltas_existentes", faltasJaExistentes);

        intent.putExtras(params);
        startActivity(intent);
        return true;
    }
}
