package com.sensor.sensorpresenca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sensor.sensorpresenca.model.Status;
import com.sensor.sensorpresenca.service.ControleService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class ControleController {

    @Autowired
    private ControleService service;

    @PostMapping("/entrada")
    public Status entrada() {
        return service.entrada();
    }

    @PostMapping("/saida")
    public Status saida() {
        return service.saida();
    }

    @GetMapping("/status")
    public Status status() {
        return service.getStatus();
    }

    @PostMapping("/config/limite")
    public void setLimite(@RequestParam int limite) {
        service.setLimite(limite);
    }

    @PostMapping("/reset")
    public void reset() {
        service.reset();
    }
}