package com.utfpr.grupo2.projetov2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Ainda posso faltar?");

        carregaDados();
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaDados();
    }

    public void carregaDados(){
        BancoController crud = new BancoController(getBaseContext());
        cursor = crud.carregaDados();

        String[] nomeCampos = new String[] {CriaBanco.NOME_DISCIPLINA};
        int[] idView = new int[] {R.id.txtDisciplina};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_item,cursor,nomeCampos,idView,0);

        lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);

                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.ID));
                Intent intent = new Intent(MainActivity.this,FormActivity.class);
                intent.putExtra("codigo",codigo);
                startActivity(intent);
            }
        });
    }

    public void acessarForm (View v){

        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }
}
