package com.example.kdim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class telaconfig extends AppCompatActivity {
    private TextView testeglobal;
    private ListView listaaços;
    private List<ScrollView> tipoaçosguerdau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telaconfig);
        testeglobal = (TextView) findViewById(R.id.testeglobal);
        Global global = (Global) getApplicationContext();
        testeglobal.setText(String.valueOf(global.getZxcalc()));
        listaaços = (ListView) findViewById(R.id.listaaços);

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
}
