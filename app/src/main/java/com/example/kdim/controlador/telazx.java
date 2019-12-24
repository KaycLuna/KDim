package com.example.kdim.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.example.kdim.Global;
import com.example.kdim.R;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class telazx extends AppCompatActivity {

    private TextView testemaior;
    private TextView msdformulaz;
    private TextView ya1formulaz;
    private TextView fyformulaz;
    private  TextView ztelaz;
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

        Global global = (Global) getApplicationContext();


        if (global.getMdx()>global.getMdy() ){
            maiormomento=global.getMdx();
        }else if (global.getMdy()>global.getMdx()){
            maiormomento= global.getMdy();
        }else if (global.getMdx()==global.getMdy()){
            maiormomento= global.getMdy();
        }

        double zxarredondado = global.getZxcalc();
        BigDecimal bd = new BigDecimal(zxarredondado).setScale(2, RoundingMode.HALF_EVEN);

       ya1formulaz.setText(String.valueOf(" x " + global.ya1));
        fyformulaz.setText(String.valueOf(global.fy)+"Mpa");
        msdformulaz.setText(String.valueOf(maiormomento+"x10^6 N.mm"));
        ztelaz.setText(String.valueOf(bd.doubleValue()+"cm³"));

        testemaior.setText("O maior momento está aplicado no "+String.valueOf(global.getEixomaior())+"\n"+" Msd = "+ maiormomento +" kN.m");
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

        switch (item.getItemId()){

        }
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent itconfug = new Intent(telazx.this, telaconfig.class);
            startActivity(itconfug);
        }else if (id==R.id.botsobre){
            Intent itsobre = new Intent(telazx.this, telasobre.class);
            startActivity(itsobre);
        }else if (id== R.id.botajuda){
            Intent itajuda = new Intent(telazx.this, telaajuda.class);
            startActivity(itajuda);

        }

        return super.onOptionsItemSelected(item);
    }
    //fim do menu

    public void voltartelaz(View view){
        //Intent it = new Intent(telazx.this, MainActivity.class);
        //startActivity(it);
        finish();

    }

}
