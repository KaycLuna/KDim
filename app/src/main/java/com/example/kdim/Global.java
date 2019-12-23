package com.example.kdim;

import android.app.Application;

public class Global extends Application {
  public double ya1=1.1; // ya1 global já setado
    public double ya2=1.35; // ya2 global já setado
    public double fy = 345; // fy global já setado

    private double zxcalc ; // zx que vai ser calculado e setada pelas outras classes

    public double getZxcalc() {
        return zxcalc;
    } // metodo para pegar o valor de zx nas outras classes

    public void setZxcalc(double zxcalc) {
        this.zxcalc = zxcalc;
    } // metodo para setar o valor de zx nas outras classes
}


