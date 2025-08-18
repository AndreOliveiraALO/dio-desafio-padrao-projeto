package com.example.desafioPadraoProjeto.observer;

import org.springframework.context.event.EventListener;

import com.example.desafioPadraoProjeto.factory.NotificationFactory;

public class ContaEventListener {
    private final NotificationFactory notificationFactory;
    
    public ContaEventListener(NotificationFactory notificationFactory){
        this.notificationFactory = notificationFactory;
    }

    @EventListener
    public void handleContaEvent(ContaEvent event){
        notificationFactory.criarNotificacoes()
            .forEach(notificacao -> notificacao.enviar(event));
    }
    

}
