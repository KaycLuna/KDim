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
import com.example.kdim.modelo.Aco;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Zx extends AppCompatActivity {

    private TextView testemaior;
    private TextView msdformulaz;
    private TextView ya1formulaz;
    private TextView fyformulaz;
    private TextView ztelaz;
    private Button botaovoltartelaz;
    private Button botaoprosseguirtelaz;
    private double maiormomento = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telazx);
        testemaior = (TextView) findViewById(R.id.testarmaior);
        msdformulaz = (TextView) findViewById(R.id.msdformulaz);
        ya1formulaz = (TextView) findViewById(R.id.ya1formulaz);
        fyformulaz = (TextView) findViewById(R.id.fyformulaz);
        ztelaz = (TextView) findViewById(R.id.ztelaz);
        botaoprosseguirtelaz = (Button) findViewById(R.id.botaoprosseguirtelaz);
        botaovoltartelaz = (Button) findViewById(R.id.botaovoltartelaz);

        if (Util.solicitacao.getMdx() > Util.solicitacao.getMdy()) {
            maiormomento = Util.solicitacao.getMdx();
        } else if (Util.solicitacao.getMdy() > Util.solicitacao.getMdx()) {
            maiormomento = Util.solicitacao.getMdy();
        } else if (Util.solicitacao.getMdx() == Util.solicitacao.getMdy()) {
            maiormomento = Util.solicitacao.getMdy();
        }

        Aco aco = Util.getInstanciaAcoDao().getAco(Util.solicitacao.getNomeAco());

        BigDecimal bd = new BigDecimal(aco.calcularZ(Util.solicitacao)).setScale(2, RoundingMode.HALF_EVEN);

        ya1formulaz.setText(String.valueOf(" x " + Util.Y_A_1));
        fyformulaz.setText(String.valueOf(aco.getTensaoDeEscoamento()) + "Mpa");
        msdformulaz.setText(String.valueOf(maiormomento + "x10^6 N.mm"));
        ztelaz.setText(String.valueOf(bd.doubleValue() + "cm³"));

        String eixo = aco.isEixoX() ? "Eixo X" : "Eixo Y";

        testemaior.setText("O maior momento está aplicado no " + String.valueOf(eixo) + "\n" + " Msd = " + maiormomento + " kN.m");
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent itconfug = new Intent(Zx.this, Configuracao.class);
            startActivity(itconfug);
        } else if (id == R.id.botsobre) {
            Intent itsobre = new Intent(Zx.this, Sobre.class);
            startActivity(itsobre);
        } else if (id == R.id.botajuda) {
            Intent itajuda = new Intent(Zx.this, Ajuda.class);
            startActivity(itajuda);

        }

        return super.onOptionsItemSelected(item);
    }
    //fim do menu

    public void voltartelaz(View view) {
        //Intent it = new Intent(Zx.this, MainActivity.class);
        //startActivity(it);
        finish();

    }

}
