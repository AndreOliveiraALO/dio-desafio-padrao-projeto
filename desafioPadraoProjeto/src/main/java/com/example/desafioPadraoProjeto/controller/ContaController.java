package com.example.desafioPadraoProjeto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafioPadraoProjeto.model.Conta;
import com.example.desafioPadraoProjeto.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService){
        this.contaService = contaService;
    }

    @PostMapping
    public Conta criarConta(@RequestBody Conta conta){
        return contaService.criarConta(conta);
    }

    @GetMapping
    public List<Conta> listarContas() {
        return contaService.listarContas();
    }

}
