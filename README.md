# 💡 Desafio Padrões de Projeto – API de Conta Bancária

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/AndreOliveiraALO/dslist/blob/main/LICENSE)

Este projeto foi desenvolvido como parte de um **desafio de Design Patterns**, com foco principal na aplicação dos padrões **Observer** e **Factory Method**. O objetivo é demonstrar, na prática, como aplicar padrões de projeto em um cenário realista de uma API bancária.

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

## 📑 Documentação e Acesso

A aplicação foi documentada com **OpenAPI/Swagger**, permitindo explorar e testar os endpoints de forma interativa:

🔗 **Swagger UI:** [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

### ⚙️ Configuração do Banco de Dados H2

O projeto utiliza banco de dados **em memória (H2)** para facilitar os testes.
As credenciais estão configuradas no `application.properties`:

* **URL JDBC:** `jdbc:h2:mem:testdb`
* **Usuário:** `sa`
* **Senha:** *(em branco)*
* **Console Web:** [http://localhost:8081/h2-console](http://localhost:8081/h2-console)

No console H2, ao acessar a URL, lembre-se de selecionar o **Driver Class**:

```
org.h2.Driver
```

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

1. Clone o repositório.
2. Configure o `application.properties` conforme necessário.
3. Execute a aplicação com `mvn spring-boot:run`.
4. Acesse o Swagger em [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html).
5. Teste os endpoints e acompanhe as notificações no console.

---

## 📌 Conclusão
Este projeto mostrou como aplicar de forma prática os padrões **Observer** e **Factory**, integrados ao **Spring Boot**, além de utilizar **Strategy**, **Repository**, **Domain Model** e **Dependency Injection**.  

A arquitetura ficou **flexível, desacoplada e extensível**, pronta para evoluir com novos recursos. 🚀
