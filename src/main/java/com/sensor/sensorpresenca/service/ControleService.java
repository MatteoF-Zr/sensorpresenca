package com.sensor.sensorpresenca.service;

import org.springframework.stereotype.Service;

import com.sensor.sensorpresenca.model.Status;

@Service
public class ControleService {

    private int pessoas = 0;
    private int limite = 10;

    public Status entrada() {
        if (pessoas < limite) {
            pessoas++;
        }
        return new Status(pessoas, limite);
    }

    public Status saida() {
        if (pessoas > 0) {
            pessoas--;
        }
        return new Status(pessoas, limite);
    }

    public Status getStatus() {
        return new Status(pessoas, limite);
    }

    public void setLimite(int novoLimite) {
        this.limite = novoLimite;
    }

    public void reset() {
        this.pessoas = 0;
    }
}