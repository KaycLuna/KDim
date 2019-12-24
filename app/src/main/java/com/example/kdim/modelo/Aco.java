package com.example.kdim.modelo;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kdim.Global;

import javax.xml.transform.Result;

public class Aco {

    private String nome;
    private double tensaoDeRuptura;
    private double tensaoDeEscoamento;
    private double calculoZ;

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

    //calcular o Z do perfil

    public double CalcularZ(){

       Global global =new Global();


        if (global.getMdx()>=global.getMdy()) {
            global.setZxcalc((global.getMdx()* Math.pow(10,6)*global.ya1)/global.fy*1000);
            global.setEixomaior("Eixo X");


        }else if (global.getMdy()>global.getMdx()){

            global.setZxcalc((global.getMdy()* Math.pow(10,6)*global.ya1)/global.fy*1000);
            global.setEixomaior("Eixo Y");
        }

    return calculoZ;
    }

}
