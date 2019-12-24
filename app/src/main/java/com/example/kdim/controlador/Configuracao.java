package com.example.kdim.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kdim.R;
import com.example.kdim.Util;

public class Configuracao extends AppCompatActivity {

    private TextView valorya1;
    private TextView valorya2;
    private TextView valordee;
    private TextView valordeg;
    private Button botaookconfig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telaconfig);
        valorya1 = (TextView) findViewById(R.id.valorya1);
        valorya2 = (TextView) findViewById(R.id.valorya2);
        valordee = (TextView) findViewById(R.id.valordee);
        valordeg = (TextView) findViewById(R.id.valordeg);
        botaookconfig = (Button) findViewById(R.id.botaookconfig);

        valorya1.setText(String.valueOf(Util.Y_A_1));
        valorya2.setText(String.valueOf(Util.Y_A_2));
        valordeg.setText(String.valueOf(Util.MODULO_DE_ELASTICIDADE_TRANSVERSAL + "MPa"));
        valordee.setText(String.valueOf(Util.MODULO_DE_ELASTICIDADE + "MPa"));

    }

    //inicio do menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

        }
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent itconfug = new Intent(Configuracao.this, Configuracao.class);
            startActivity(itconfug);
        } else if (id == R.id.botsobre) {
            Intent itsobre = new Intent(Configuracao.this, Sobre.class);
            startActivity(itsobre);
        } else if (id == R.id.botajuda) {
            Intent itajuda = new Intent(Configuracao.this, Ajuda.class);
            startActivity(itajuda);

        }

        return super.onOptionsItemSelected(item);
    }

    //fim do menu

    public void SalvareFechar(View view) {

        finish();

    }

}
