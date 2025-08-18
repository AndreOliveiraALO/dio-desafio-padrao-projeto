package com.example.desafioPadraoProjeto.factory;

import com.example.desafioPadraoProjeto.observer.ContaEvent;

public class NotificacaoEmail implements Notificacao {
    @Override
    public void enviar(ContaEvent event) {
        System.out.println("Enviando e-mail para " + event.getConta().getTitular() +
                ": Evento " + event.getTipoEvento());
    }
}
