package com.example.desafioPadraoProjeto.service;

import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.desafioPadraoProjeto.model.Conta;
import com.example.desafioPadraoProjeto.observer.ContaEvent;
import com.example.desafioPadraoProjeto.repository.ContaRepository;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    private final ApplicationEventPublisher eventPublisher;

    public ContaService(ContaRepository contaRepository, ApplicationEventPublisher eventPublisher){
        this.contaRepository = contaRepository;
        this.eventPublisher = eventPublisher;
    }

    public Conta criarConta(Conta conta){
        Conta novaConta = contaRepository.save(conta);
        eventPublisher.publishEvent(new ContaEvent(novaConta, ContaEvent.TipoEvento.CRIACAO));
        return novaConta;    
    }

    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }

}
