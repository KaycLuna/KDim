package com.example.kdim.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.kdim.Global;
import com.example.kdim.R;

import java.util.List;

public class telaconfig extends AppCompatActivity {

    private TextView valorya1;
    private  TextView valorya2;
    private  TextView valordee;
    private TextView valordeg;
    private Button botaookconfig;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telaconfig);
        valorya1 = (TextView) findViewById(R.id.valorya1);
        valorya2 = (TextView) findViewById(R.id.valorya2) ;
        valordee = (TextView) findViewById(R.id.valordee);
        valordeg = (TextView) findViewById(R.id.valordeg);
        botaookconfig = (Button) findViewById(R.id.botaookconfig);


        Global global = (Global) getApplicationContext();
            valorya1.setText(String.valueOf(global.ya1));
            valorya2.setText(String.valueOf(global.ya2));
            valordeg.setText(String.valueOf(global.modulodeelasticidadetransversal + "MPa"));
            valordee.setText(String.valueOf(global.modulodeelasticidade + "MPa"));


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

        if (id == R.id.action_settings) {
            Intent itconfug = new Intent(telaconfig.this, telaconfig.class);
            startActivity(itconfug);
        }else if (id==R.id.botsobre){
            Intent itsobre = new Intent(telaconfig.this, telasobre.class);
            startActivity(itsobre);
        }else if (id== R.id.botajuda){
            Intent itajuda = new Intent(telaconfig.this, telaajuda.class);
            startActivity(itajuda);

        }

        return super.onOptionsItemSelected(item);
    }

       //fim do menu

    public void SalvareFechar(View view){

        finish();

    }

}
