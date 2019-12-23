package com.example.kdim.modelo;

public class Aco {

    private String nome;
    private double tensaoDeRuptura;
    private double tensaoDeEscoamento;

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

}
