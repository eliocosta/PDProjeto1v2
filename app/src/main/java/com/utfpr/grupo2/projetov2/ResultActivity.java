package com.utfpr.grupo2.projetov2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    EditText nomeDisplina;
    EditText percentFaltas;
    TextView txtDisciplina;
    TextView txtNumeroDeAulasSemestre;
    TextView txtFaltasQuePossui;
    TextView txtFaltasQuePodeTer;
    Cursor cursor;
    BancoController crud;
    String codigo;
    Integer numFaltas;
    private SQLiteDatabase db;
    private CriaBanco banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("Resumo");

        codigo = this.getIntent().getStringExtra("codigo");
        crud = new BancoController(getBaseContext());
        txtDisciplina = (TextView) findViewById(R.id.nome_disciplina);
        nomeDisplina = (EditText) findViewById(R.id.edtAlterarNomeDisciplina);
        percentFaltas = (EditText) findViewById(R.id.edtAlterarPercent_Faltas);
        txtNumeroDeAulasSemestre = (TextView) findViewById(R.id.numero_aulas);
        txtFaltasQuePossui = (TextView) findViewById(R.id.faltas_que_possui);
        txtFaltasQuePodeTer = (TextView) findViewById(R.id.total_faltas_possiveis);

        cursor = crud.carregaDadosById(Integer.parseInt(codigo));
        txtDisciplina.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.NOME_DISCIPLINA)));

        numFaltas = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.NUM_FALTAS)));
        Float percentFaltas = Float.parseFloat(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.PERCENT_FALTAS)));
        Integer numAulas = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.NUM_AULAS)));

        txtFaltasQuePossui.setText(numFaltas.toString());

        // Calculo de faltas restantes
        float totalFaltasPossiveis = (numAulas * (percentFaltas/100));
        float resultCalculo = totalFaltasPossiveis - numFaltas;

        txtNumeroDeAulasSemestre.setText(Float.toString(numAulas));
        txtFaltasQuePodeTer.setText(Float.toString(resultCalculo));
    }

    public void editar(View view){
        crud.alterarRegistro(Integer.parseInt(codigo), nomeDisplina.getText().toString(), percentFaltas.getText().toString());
        finish();
    }

    public void excluir(View view){
        crud.deletaRegistro(Integer.parseInt(codigo));
        finish();
    }

    public void maisFalta(View view){
        crud.addFalta(Integer.parseInt(codigo),numFaltas+1);
        finish();
    }

//    public void calculoDeAulas(String periodo){
//
//        Toast.makeText(this,periodo,Toast.LENGTH_LONG).show();
//        String periodo_1 = ""+numAulas20181;
//        if(periodo.equals("2018/1")){
//            txtNumeroDeAulasSemestre.setText(periodo_1);
//        }
//    }
}
