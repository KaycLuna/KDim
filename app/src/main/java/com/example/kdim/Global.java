package com.example.kdim;

import android.app.Application;

public class Global extends Application {
    public double ya1=1.10; // ya1 global já setado
    public double ya2=1.35; // ya2 global já setado
    public double fy = 345; // fy global já setado
    public double modulodeelasticidade = 200000; // modulo de elasticidade
    public double modulodeelasticidadetransversal = 77000; // modulo de elasticidade transversal


    private double zxcalc ; // zx que vai ser calculado e setada pelas outras classes

    public double getZxcalc() {
        return zxcalc;
    } // metodo para pegar o valor de zx nas outras classes

    public void setZxcalc(double zxcalc) {
        this.zxcalc = zxcalc;
    } // metodo para setar o valor de zx nas outras classes


  //vou pegar o eixo que está tendo o maior momento
  private String eixomaior;

    public String getEixomaior(){
      return eixomaior;
    }

    public void setEixomaior(String eixomaior){
      this.eixomaior = eixomaior;

    }
    //fim do eixo de maior momento

  //vou pegar o valor do mdx
    private double mdx;

    public double getMdx(){
      return mdx;
    }
    public void setMdx(double mdx){
      this.mdx = mdx;
    }
    //peguei o mdx

  //vou pegar o mdy
    private double mdy;

    public double getMdy(){
      return mdy;
    }
    public void setMdy(double mdy){
      this.mdy = mdy;
    }
    //peguei o mdy

  //vou pegar o nsd
    private double nsd;

    public double getNsd(){
      return nsd;
    }
    public void setNsd(Double aDouble){
      this.nsd = nsd;
    }

}


