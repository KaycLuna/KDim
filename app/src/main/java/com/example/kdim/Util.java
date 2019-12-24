package com.example.kdim;

import android.content.Context;

import com.example.kdim.controlador.MainActivity;
import com.example.kdim.database.AcoDao;
import com.example.kdim.database.AcoHelper;
import com.example.kdim.modelo.Solicitacao;

import java.util.HashMap;
import java.util.Map;

public final class Util {

    private static AcoDao acoDao;
    private static AcoHelper acoHelper;

    public static final double Y_A_1 = 1.10;
    public static final double Y_A_2 = 1.35;

    public static final double MODULO_DE_ELASTICIDADE = 200000;
    public static final double MODULO_DE_ELASTICIDADE_TRANSVERSAL = 77000;

    public static Solicitacao solicitacao = new Solicitacao();

    private Util() {
    }

    public static void initRecursosUtil(Context contexto) {
        if (acoHelper == null) {
            acoHelper = new AcoHelper(contexto);
            acoDao = new AcoDao(acoHelper);
        }
    }

    public static AcoDao getInstanciaAcoDao() {
        return acoDao;
    }



}
