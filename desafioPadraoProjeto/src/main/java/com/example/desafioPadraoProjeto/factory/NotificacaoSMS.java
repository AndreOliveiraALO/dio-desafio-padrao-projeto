package com.example.desafioPadraoProjeto.factory;

import com.example.desafioPadraoProjeto.observer.ContaEvent;

public class NotificacaoSMS implements Notificacao{
    @Override
    public void enviar(ContaEvent event) {
        System.out.println("Enviando SMS para " + event.getConta().getTitular() +
                ": Evento " + event.getTipoEvento());
    }
}
