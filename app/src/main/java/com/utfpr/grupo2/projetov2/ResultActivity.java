package com.utfpr.grupo2.projetov2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle params = getIntent().getExtras();

        TextView nome_materia = (TextView)findViewById(R.id.nome_materia);
        TextView numero_aulas = (TextView)findViewById(R.id.numero_aulas);
        TextView faltas_que_possui = (TextView)findViewById(R.id.faltas_que_possui);
        TextView total_faltas_possiveis = (TextView)findViewById(R.id.total_faltas_possiveis);

        nome_materia.setText(params.getString("nome_disciplina"));
        numero_aulas.setText(params.getString("aulas_semestre"));
        faltas_que_possui.setText(params.getString("faltas_existentes"));

        total_faltas_possiveis.setText("20");
    }
}
