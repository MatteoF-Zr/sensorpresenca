package com.sensor.sensorpresenca.model;

public class Status {

    private int pessoas;
    private int limite;

    public Status(int pessoas, int limite) {
        this.pessoas = pessoas;
        this.limite = limite;
    }

    public int getPessoas() {
        return pessoas;
    }

    public int getLimite() {
        return limite;
    }

    public void setPessoas(int pessoas) {
        this.pessoas = pessoas;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }
}