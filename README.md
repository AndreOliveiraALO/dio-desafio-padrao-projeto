# 💡 Desafio Padrões de Projeto – Conta Bancária

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/AndreOliveiraALO/dslist/blob/main/LICENSE)

Este projeto foi desenvolvido como prática de **padrões de projeto em Java com Spring Boot**, simulando uma aplicação simples de **conta bancária** com persistência em banco e envio de notificações.  

O foco principal está nos padrões **Observer** e **Factory**, mas também foram aplicados outros padrões clássicos que enriquecem a arquitetura.

---

## 🚀 Padrões Implementados

### 🔔 1. Observer
- **Implementação no Spring**:
  - `ContaService` publica eventos usando `ApplicationEventPublisher`.
  - `ContaEvent` encapsula os dados do evento (ex.: abertura de conta).
  - `ContaEventListener` escuta os eventos com `@EventListener` e dispara a notificação.
- **Benefício**:
  - Desacoplamento entre quem dispara o evento e quem reage.
  - Permite adicionar facilmente novos listeners (log, auditoria, notificações diversas).

---

### 🏭 2. Factory
- **Implementação**:
  - `NotificacaoFactory` decide qual implementação de `NotificacaoService` será usada.
  - Implementações concretas:
    - `EmailNotificacaoService`
    - `SmsNotificacaoService`
- **Configuração**:
  - Controlado pelo `application.properties` com variáveis booleanas:
    ```properties
    app.notification.email=true
    app.notification.sms=false
    ```
- **Benefício**:
  - Encapsula a lógica de criação dos objetos.
  - Facilita a extensão para novos canais de notificação (Push, WhatsApp, etc.).

---

### ⚙️ Outros Padrões Aplicados
- **Strategy** → `NotificacaoService` (interface) + implementações (e-mail, SMS).  
- **Domain Model** → `Conta` encapsula regras de negócio (`depositar`, `sacar`).  
- **Repository** → `ContaRepository` abstrai a persistência com Spring Data JPA.  
- **Dependency Injection (IoC)** → Injeção de dependências com Spring.  

---

## 📂 Estrutura do Projeto
```
src/main/java/com/exemplo/desafioPadraoProjeto
│
├── conta
│   ├── Conta.java                 # Entidade de domínio
│   ├── ContaRepository.java       # Repositório (Spring Data JPA)
│   ├── ContaService.java          # Regras de negócio e publicação de eventos
│
├── event
│   ├── ContaEvent.java            # Evento disparado
│   ├── ContaEventListener.java    # Ouvinte do evento (Observer)
│
├── notificacao
│   ├── NotificacaoService.java    # Interface (Strategy)
│   ├── EmailNotificacaoService.java
│   ├── SmsNotificacaoService.java
│   ├── NotificacaoFactory.java    # Criação controlada (Factory)
│
└── DesafioPadraoProjetoApplication.java # Classe principal
```

---

## 📈 Diagrama UML – Observer + Factory

![Diagrama UML Observer + Factory](https://github.com/AndreOliveiraALO/Projetos/blob/main/Imagens/dio-desafio-padrao-projeto/uml_observer_factory.png)

---

## ▶️ Passo a Passo de Funcionamento

1. **Criação de Conta**
   - O método `ContaService.criarConta()` salva a conta no banco e dispara um `ContaEvent`.

2. **Disparo do Evento (Observer)**
   - O `ApplicationEventPublisher` notifica todos os listeners que estão ouvindo `ContaEvent`.

3. **Tratamento do Evento**
   - `ContaEventListener` recebe o evento e consulta a `NotificacaoFactory` para decidir o canal de notificação.

4. **Envio da Notificação (Factory + Strategy)**
   - A `NotificacaoFactory` entrega a implementação correta (`EmailNotificacaoService` ou `SmsNotificacaoService`).
   - O serviço concreto envia a mensagem no console (simulação).

---

## ✅ Exemplo de Execução
Ao criar uma conta, se `app.notification.email=true`, no console será exibido:
```
[EMAIL] Conta criada com sucesso para o cliente: João da Silva
```

Se `app.notification.sms=true`, será exibido:
```
[SMS] Conta criada com sucesso para o cliente: João da Silva
```

---

## 📌 Conclusão
Este projeto mostrou como aplicar de forma prática os padrões **Observer** e **Factory**, integrados ao **Spring Boot**, além de utilizar **Strategy**, **Repository**, **Domain Model** e **Dependency Injection**.  

A arquitetura ficou **flexível, desacoplada e extensível**, pronta para evoluir com novos recursos. 🚀
