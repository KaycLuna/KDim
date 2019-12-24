package com.example.kdim.modelo;

import com.example.kdim.Util;

public class Aco {

    private String nome;
    private double tensaoDeRuptura;
    private double tensaoDeEscoamento;
    private boolean eixo;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setTensaoDeRuptura(double tensaoDeRuptura) {
        this.tensaoDeRuptura = tensaoDeRuptura;
    }

    public double getTensaoDeRuptura() {
        return tensaoDeRuptura;
    }

    public void setTensaoDeEscoamento(double tensaoDeEscoamento) {
        this.tensaoDeEscoamento = tensaoDeEscoamento;
    }

    public double getTensaoDeEscoamento() {
        return this.tensaoDeEscoamento;
    }

    public double calcularZ(Solicitacao solicitacao) {
        eixo = solicitacao.getMdx() >= solicitacao.getMdy();
        if (eixo)
            return (solicitacao.getMdx() * Math.pow(10, 6) * Util.Y_A_1) / getTensaoDeEscoamento() * 100;
        else
            return (solicitacao.getMdy() * Math.pow(10, 6) * Util.Y_A_1) / getTensaoDeEscoamento() * 1000;
    }

    public boolean isEixoX() {
        return eixo;
    }

}
