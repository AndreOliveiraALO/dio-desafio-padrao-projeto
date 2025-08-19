package com.example.desafioPadraoProjeto.observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.desafioPadraoProjeto.factory.NotificationFactory;

@Component
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
