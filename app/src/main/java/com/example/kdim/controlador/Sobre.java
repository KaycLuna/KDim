package com.example.kdim.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.kdim.R;

public class Sobre extends AppCompatActivity {
    private ImageButton botfecharsobre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telasobre);
        botfecharsobre = (ImageButton) findViewById(R.id.botfecharsobre);
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

        }
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent itconfug = new Intent(Sobre.this, Configuracao.class);
            startActivity(itconfug);
        } else if (id == R.id.botsobre) {
            Intent itsobre = new Intent(Sobre.this, Sobre.class);
            startActivity(itsobre);
        } else if (id == R.id.botajuda) {
            Intent itajuda = new Intent(Sobre.this, Ajuda.class);
            startActivity(itajuda);

        }

        return super.onOptionsItemSelected(item);
    }
    //fim do menu


    public void fecharsobre(View view) {
        finish();
    }

}
