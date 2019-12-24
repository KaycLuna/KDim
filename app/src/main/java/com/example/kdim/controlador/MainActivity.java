package com.example.kdim.controlador;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.kdim.Global;
import com.example.kdim.R;
import com.example.kdim.database.AcoHelper;
import com.example.kdim.modelo.Aco;


public class MainActivity extends AppCompatActivity {
    private EditText edtnsd;
    private  EditText edtmdx;
    private  EditText edtmdy;
    private  TextView testezx;
    private ProgressBar load;
    private TextView statusbarra ;
    private int progresso = 0;
    private Handler mHandler = new Handler();
    private Button continuar01;
    private  Toolbar toolbar;
    private double mcalc = 0;
    private MenuItem botsobre;
    public double zx=0;
    private SQLiteDatabase conexao;
    private  SQLiteDatabase gravar;
    private AcoHelper bdtipoaço;

    //conexao bd
   /* public void criarConexao(){
        try {

            bdtipoaço = new AcoHelper(getBaseContext());
            SQLiteDatabase conexao = bdtipoaço.getWritableDatabase();

            //conexao.execSQL("create table tb_teste(nome text primary key, valor integer);");
            conexao.execSQL("insert into tb_teste(nome, valor) values ('fisica', 10)");
            conexao.execSQL("insert into tb_teste(nome, valor) values ('matematica', 54)");
            conexao.execSQL("insert into tb_teste(nome, valor) values ('portugues', 3)");

            Cursor cursor = conexao.rawQuery("SELECT* FROM tb_teste;", null);
            while(cursor.moveToNext()) {
                Log.d("nome", cursor.getString(cursor.getColumnIndex("nome")));
                Log.d("nome", ""+cursor.getInt(cursor.getColumnIndex("valor")));
            }
            cursor.close();
        }catch (SQLException ex){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton("Ok",null);
            dlg.show();
        }
    }*/
    // fim banco de daods

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

       //criarConexao();
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
        switch (item.getItemId()){

        }
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent itconfug = new Intent(MainActivity.this, telaconfig.class);
            startActivity(itconfug);
        }else if (id==R.id.botsobre){
            Intent itsobre = new Intent(MainActivity.this, telasobre.class);
            startActivity(itsobre);
        }else if (id== R.id.botajuda){
            Intent itajuda = new Intent(MainActivity.this, telaajuda.class);
            startActivity(itajuda);

        }

        return super.onOptionsItemSelected(item);
    }
    //fim do menu

    // BOTÃO ANALISAR
    public void analisar(View view){

        if( edtmdx.getText().length() != 0 && edtmdy.getText().length()!=0 && edtnsd.getText().length()!=0 ){ //Verifico se todos os campos não estão vazios

        Global global = (Global) getApplicationContext();
        global.setMdx(Double.valueOf(edtmdx.getText().toString())); //jogo o valor de mdx pra global
        global.setMdy(Double.valueOf(edtmdy.getText().toString())); //jogo p valor de mdy pra global
        global.setNsd(Double.valueOf(edtnsd.getText().toString())); // passo o valor de nsd pra global

        /*if (global.getMdx()>=global.getMdy()) {
            zx = ((global.getMdx() * Math.pow(10, 6)) *global.ya1) / (global.fy * 1000);

            global.setZxcalc(zx);
            global.setEixomaior("Eixo X");


        }else if (global.getMdy()>global.getMdx()){

             zx = ((global.getMdy() * Math.pow(10, 6)) * global.ya1) / (global.fy * 1000);

            global.setZxcalc(zx);
            global.setEixomaior("Eixo Y");

        }*/
        Aco aco = new Aco();
        aco.CalcularZ();

        load.setVisibility(View.VISIBLE); //deixando a barra de progresso visivel
        statusbarra.setVisibility(View.VISIBLE); //deixandoo satatus da barra visivel

        // BARRA DE PROGRESSO
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progresso< 100){
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
        //FIM  BARRA DE PROGRESSO

    }else if( edtmdx.getText().length() == 0 || edtmdy.getText().length()==0 || edtnsd.getText().length()==0 ){ //verifico se algum dos campos está vazio
         if (edtmdx.getText().length() == 0) {
             Toast toast = Toast.makeText(getApplicationContext(),
                     "Se não houver alguma solicitção insira 0",
                     Toast.LENGTH_LONG);
             toast.setGravity(Gravity.CENTER, 0, 0);

             toast.show();
             edtmdx.setError("Campo Vazio");
         }

    if (edtmdy.getText().length() == 0) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Se não houver alguma solicitção insira 0",
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);

        toast.show();
        edtmdy.setError("Campo Vazio");
    }

    if (edtnsd.getText().length() == 0){
            Toast toast = Toast.makeText (getApplicationContext (),
                    "Se não houver alguma solicitção insira 0",
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0,0);

            toast.show ();
            edtnsd.setError("Campo Vazio");

    }
        }
    }
      //FIM BOTÃO ANALISAR

    //botão chamar tela zx
    public void chamarzx (View view){
        Intent it = new Intent(MainActivity.this, telazx.class);
        startActivity(it);
        load.setVisibility(View.INVISIBLE); //deixando a barra de progresso invisivel
        statusbarra.setVisibility(View.INVISIBLE); //deixandoo satatus da barra invisivel
        continuar01.setVisibility(View.INVISIBLE); //deixando o botao prosseguir invisivel
        progresso=0; //zerando o progresso da barra
        statusbarra.setText("Analisando...");


    }
    // fim chamada telazx
    }



