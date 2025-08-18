package com.example.desafioPadraoProjeto.observer;

import org.springframework.context.ApplicationEvent;

import com.example.desafioPadraoProjeto.model.Conta;
import com.example.desafioPadraoProjeto.utils.ContaEventType;

public class ContaEvent extends ApplicationEvent {

    public final Conta conta;

    public final ContaEventType tipoEvento;

    public ContaEvent(Object source, Conta conta, ContaEventType tipoEvento){
        super(source);
        this.conta = conta;
        this.tipoEvento = tipoEvento;
    }

    public Conta getConta(){
        return this.conta;
    }

    public ContaEventType getTipoEvento(){
        return this.tipoEvento;
    }

}
