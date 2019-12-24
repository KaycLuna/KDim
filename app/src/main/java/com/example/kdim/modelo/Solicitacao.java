package com.example.kdim.modelo;

public class Solicitacao {

    private double nsd;
    private double mdx;
    private double mdy;
    private String nomeAco;

    public String getNomeAco() {
        return nomeAco;
    }

    public void setNomeAco(String nomeAco) {
        this.nomeAco = nomeAco;
    }

    public double getNsd() {
        return nsd;
    }

    public void setNds(double nsd) {
        if (nsd <= 0)
            throw new IllegalArgumentException("nsd");
        this.nsd = nsd;
    }

    public double getMdx() {
        return mdx;
    }

    public void setMdx(double mdx) {
        if (mdx <= 0)
            throw new IllegalArgumentException("mdx");
        this.mdx = mdx;
    }

    public double getMdy() {
        return mdy;
    }

    public void setMdy(double mdy) {
        if (mdy <= 0)
            throw new IllegalArgumentException("mdy");
        this.mdy = mdy;
    }
}
