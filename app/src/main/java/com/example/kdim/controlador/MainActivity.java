package com.example.kdim.controlador;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.kdim.R;
import com.example.kdim.Util;
import com.example.kdim.database.AcoDao;
import com.example.kdim.database.AcoHelper;
import com.example.kdim.modelo.Aco;


public class MainActivity extends AppCompatActivity {

    private EditText edtnsd;
    private EditText edtmdx;
    private EditText edtmdy;
    private TextView testezx;
    private ProgressBar load;
    private TextView statusbarra;
    private int progresso = 0;
    private Handler mHandler = new Handler();
    private Button continuar01;
    private Toolbar toolbar;
    private double mcalc = 0;
    private MenuItem botsobre;
    public double zx = 0;
    private SQLiteDatabase conexao;
    private SQLiteDatabase gravar;
    private AcoHelper bdtipoaço;

    /*
     * Este método é responsável por configurar
     * os objetos necessários para que a classe
     * Util possa fornecer os DAOs. Os DAOs
     * possibilitaram acesso a base de dados.  */

    private void initUtil() {

        Util.initRecursosUtil(getBaseContext());

        /*Estou adicionando esse código só para teste*/
       AcoDao acoDao =  Util.getInstanciaAcoDao();
       Aco aco = new Aco();
       aco.setNome("Aço 01");
       aco.setTensaoDeEscoamento(5.6);
       aco.setTensaoDeRuptura(3.7);

       /* Estou configurando o nome do aço
       * só para teste, pois quem vai definir
       * o nome é o usuário.*/
       Util.solicitacao.setNomeAco("Aço 01");

       try {
           acoDao.inserir(aco);
       } catch(Exception e) {
           /*Quando o Aço 01 já estiver no banco
           * ocorrerá um erro, mas tudo bem, estamos
           * inserindo para teste. O erro será capturado
           * aqui e não vamos fazer nada, só seguir com
           * a execução normalmente.
           *
           * Atenção: Ocorrerá um erro porque tentaremos inserir
           * um aço que tem a chave primária repetida.*/
       }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtnsd = (EditText) findViewById(R.id.edtnsd);
        edtmdx = (EditText) findViewById(R.id.edtmdx);
        edtmdy = (EditText) findViewById(R.id.edtmdy);

        load = (ProgressBar) findViewById(R.id.load);
        statusbarra = (TextView) findViewById(R.id.statusbarra);
        continuar01 = (Button) findViewById(R.id.continuar01);
        botsobre = (MenuItem) findViewById(R.id.botsobre);


        //Tirando o nome da barra
        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //fim

        initUtil();
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
            Intent itconfug = new Intent(MainActivity.this, Configuracao.class);
            startActivity(itconfug);
        } else if (id == R.id.botsobre) {
            Intent itsobre = new Intent(MainActivity.this, Sobre.class);
            startActivity(itsobre);
        } else if (id == R.id.botajuda) {
            Intent itajuda = new Intent(MainActivity.this, Ajuda.class);
            startActivity(itajuda);

        }

        return super.onOptionsItemSelected(item);
    }
    //fim do menu

    // BOTÃO ANALISAR
    public void analisar(View view) {
        try {
            Util.solicitacao.setNds(Double.valueOf(edtnsd.getText().toString()));
            Util.solicitacao.setMdx(Double.valueOf(edtmdx.getText().toString()));
            Util.solicitacao.setMdy(Double.valueOf(edtmdy.getText().toString()));
            executarBarraDeProgresso();
        } catch (IllegalArgumentException illegalArgumentException) {
            String mensagem = "O valor deve ser maior ou igual a zero.";
            if (edtnsd.getText().toString().length() == 0)
                edtnsd.setError(mensagem);
            if (edtmdx.getText().toString().length() == 0)
                edtmdx.setError(mensagem);
            if (edtmdy.getText().toString().length() == 0)
                edtmdy.setError(mensagem);
        }
    }
    //FIM BOTÃO ANALISAR

    private void executarBarraDeProgresso() {
        load.setVisibility(View.VISIBLE); //deixando a barra de progresso visivel
        statusbarra.setVisibility(View.VISIBLE); //deixandoo satatus da barra visivel

        // BARRA DE PROGRESSO
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progresso < 100) {
                    progresso++;
                    android.os.SystemClock.sleep(10);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            load.setProgress(progresso);
                        }
                    });
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        statusbarra.setText("Concluido.");
                        continuar01.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).start();
    }

    //botão chamar tela zx
    public void chamarzx(View view) {
        Intent it = new Intent(MainActivity.this, Zx.class);
        startActivity(it);
        load.setVisibility(View.INVISIBLE); //deixando a barra de progresso invisivel
        statusbarra.setVisibility(View.INVISIBLE); //deixandoo satatus da barra invisivel
        continuar01.setVisibility(View.INVISIBLE); //deixando o botao prosseguir invisivel
        progresso = 0; //zerando o progresso da barra
        statusbarra.setText("Analisando...");
    }
    // fim chamada Zx
}



