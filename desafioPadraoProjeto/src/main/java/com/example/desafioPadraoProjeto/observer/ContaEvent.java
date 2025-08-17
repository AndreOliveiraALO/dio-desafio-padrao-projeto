package com.example.desafioPadraoProjeto.observer;

import com.example.desafioPadraoProjeto.model.Conta;

public class ContaEvent {

    public enum TipoEvento{
        CRIACAO,
        SAQUE,
        DEPOSITO
    }

    public final Conta conta;

    public final TipoEvento tipoEvento;

    public ContaEvent(Conta conta, TipoEvento tipoEvento){
        this.conta = conta;
        this.tipoEvento = tipoEvento;
    }

    public Conta getConta(){
        return this.conta;
    }

    public TipoEvento getTipoEvento(){
        return this.tipoEvento;
    }

}
