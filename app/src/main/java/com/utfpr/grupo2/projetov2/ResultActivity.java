package com.utfpr.grupo2.projetov2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    EditText nomeDisplina;
    EditText percentFaltas;
    TextView txtDisciplina;
    TextView txtNumeroDeAulas;
    TextView txtFaltasQuePossui;
    TextView txtFaltasQuePodeTer;
    Cursor cursor;
    BancoController crud;
    String codigo;
    private int numAulas20181 = 100;
    private int numAulas20182 = 120;
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
        txtNumeroDeAulas = (TextView) findViewById(R.id.numero_aulas);

        cursor = crud.carregaDadosById(Integer.parseInt(codigo));
        txtDisciplina.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.NOME_DISCIPLINA)));
    }

    public void editar(View view){
        crud.alterarRegistro(Integer.parseInt(codigo), nomeDisplina.getText().toString(), percentFaltas.getText().toString());
        finish();
    }

    public void excluir(View view){
        crud.deletaRegistro(Integer.parseInt(codigo));
        finish();
    }

    public void calculoDeAulas(){
        String campos[] = {CriaBanco.ID ,CriaBanco.PERIODO};
        db = banco.getReadableDatabase();
        String where = " = " + CriaBanco.ID;

        cursor = db.query(CriaBanco.TABELA, campos, where, null, null, null, null, null);

        String periodo_1 = ""+numAulas20181;
        if(cursor.toString().equals("20181")){
            txtNumeroDeAulas.setText(periodo_1);
        }
    }
}
