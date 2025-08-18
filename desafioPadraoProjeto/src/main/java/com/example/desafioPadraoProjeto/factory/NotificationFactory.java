package com.example.desafioPadraoProjeto.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component 
public class NotificationFactory {
    @Value("${app.notification.sms.enabled:false}")
    public String notificationSMS;

    @Value("${app.notification.email.enabled:false}")
    public String notificationEmail;

    public List<Notificacao> criarNotificacoes(){
        List<Notificacao> notificacoes = new ArrayList<>();
        
        if(Boolean.parseBoolean(notificationSMS))
            notificacoes.add(new NotificacaoSMS());
        
        if(Boolean.parseBoolean(notificationEmail))
            notificacoes.add(new NotificacaoEmail());
        
        if (notificacoes.isEmpty()){
            throw new IllegalStateException("Nenhum tipo de notificação configurado. Verifique as propriedades de configuração.");
        }

        return notificacoes;        
    }




}
