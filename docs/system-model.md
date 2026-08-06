# 🧩 Modelo do Sistema

## 1. Introdução

Este documento descreve o modelo conceitual do Code Compass.

Seu objetivo é definir as principais entidades do sistema, suas responsabilidades e os relacionamentos necessários para suportar o funcionamento da plataforma.

O modelo foi construído com base nos requisitos, regras de negócio, arquitetura e fluxo de inteligência definidos nos documentos anteriores.

---

## 2. Visão Geral do Modelo

O Code Compass é estruturado em torno de três áreas principais:

* gerenciamento de usuários;
* construção do perfil de conhecimento;
* histórico e contexto das interações.

As entidades do sistema trabalham em conjunto para registrar interações, identificar conceitos, armazenar evidências e acompanhar a evolução do conhecimento do usuário.

---

## 3. Entidades Principais

### User

Representa um usuário da plataforma.

**Responsabilidades:**

* autenticação;
* preferências;
* gerenciamento da conta;
* acesso ao histórico;
* acesso ao perfil de conhecimento.

**Relacionamentos:**

* possui um perfil de conhecimento;
* possui conversas;
* pode possuir projetos.

---

### KnowledgeProfile

Representa a visão consolidada do conhecimento de um usuário.

**Responsabilidades:**

* armazenar conceitos explorados;
* acompanhar evolução;
* registrar níveis estimados de domínio;
* identificar dificuldades recorrentes.

**Relacionamentos:**

* pertence a um usuário;
* possui relações com conceitos através de UserConcept.

---

### Concept

Representa um conceito técnico padronizado do sistema.

**Exemplos:**

* JWT;
* REST API;
* Arrays;
* React Hooks;
* Spring Security.

**Responsabilidades:**

* manter conceitos consistentes;
* relacionar conhecimentos;
* servir como base para recomendações e análise.

**Relacionamentos:**

* pertence a uma tecnologia;
* pode estar relacionado a outros conceitos;
* pode estar associado a diversos usuários através de UserConcept.

---

### Technology

Representa uma tecnologia conhecida pelo sistema.

**Exemplos:**

* Java;
* JavaScript;
* React;
* Spring Boot;
* PostgreSQL.

**Responsabilidades:**

* agrupar conceitos relacionados;
* servir como contexto para projetos;
* auxiliar recomendações e navegação do conhecimento.

**Relacionamentos:**

* possui conceitos;
* pode estar associada a projetos.

---

### UserConcept

Representa a relação entre um usuário e um conceito.

**Responsabilidades:**

* registrar contato com conceitos;
* armazenar informações de evolução;
* consolidar evidências relacionadas.

**Pode conter:**

* nível estimado de domínio;
* última interação;
* quantidade de evidências;
* classificação de dificuldade recorrente.

**Relacionamentos:**

* pertence a um perfil de conhecimento;
* referencia um conceito;
* possui evidências associadas.

---

### Evidence

Representa uma evidência utilizada para compor o perfil de conhecimento.

**Exemplos:**

* pergunta realizada;
* demonstração de conhecimento;
* aplicação prática;
* dificuldade identificada.

**Responsabilidades:**

* registrar eventos relevantes;
* apoiar estimativas de domínio;
* alimentar a evolução do perfil.

**Relacionamentos:**

* pertence a um UserConcept;
* é originada a partir de uma mensagem.

---

### Conversation

Representa uma conversa realizada na plataforma.

**Responsabilidades:**

* armazenar histórico de interação;
* fornecer contexto para a IA;
* permitir continuidade das discussões.

**Relacionamentos:**

* pertence a um usuário;
* possui mensagens.

---

### Message

Representa uma mensagem individual dentro de uma conversa.

**Responsabilidades:**

* registrar interações;
* servir como fonte de contexto;
* gerar evidências para o perfil de conhecimento.

**Relacionamentos:**

* pertence a uma conversa;
* pode originar evidências.

---

### Project

Representa um contexto de projeto utilizado pelo usuário.

O objetivo da entidade não é gerenciar projetos, mas fornecer contexto para as interações.

**Responsabilidades:**

* registrar tecnologias utilizadas;
* armazenar contexto técnico;
* auxiliar a personalização das respostas.

**Relacionamentos:**

* pertence a um usuário;
* pode estar associado a tecnologias.

---

## 4. Relacionamentos

### Usuário e Perfil de Conhecimento

```text
User 1 ───── 1 KnowledgeProfile
```

Todo usuário possui exatamente um perfil de conhecimento.

---

### Perfil e Conceitos

```text
KnowledgeProfile 1 ───── N UserConcept

UserConcept N ───── 1 Concept
```

Os conceitos são compartilhados pelo sistema.

O perfil registra a relação específica do usuário com cada conceito.

---

### Conceitos e Tecnologias

```text
Technology 1 ───── N Concept
```

Uma tecnologia pode possuir diversos conceitos relacionados.

---

### Perfil e Evidências

```text
UserConcept 1 ───── N Evidence
```

As evidências são utilizadas para construir a visão evolutiva do conhecimento.

---

### Conversas e Mensagens

```text
Conversation 1 ───── N Message
```

Uma conversa é composta por múltiplas mensagens.

---

### Mensagens e Evidências

```text
Message 1 ───── N Evidence
```

Uma mensagem pode gerar uma ou mais evidências.

---

### Usuários e Projetos

```text
User 1 ───── N Project
```

Projetos são opcionais e servem apenas como contexto.

---

## 5. Perfil de Conhecimento

O perfil de conhecimento não representa uma avaliação absoluta das capacidades do usuário.

Seu objetivo é manter uma estimativa evolutiva baseada em evidências observadas ao longo do uso da plataforma.

O perfil considera:

* conceitos explorados;
* frequência de interação;
* dificuldades recorrentes;
* histórico de utilização;
* evolução observada.

---

## 6. Dificuldades Recorrentes

Dificuldades recorrentes não são armazenadas como entidades independentes.

Elas são calculadas a partir das evidências registradas para cada conceito.

Exemplo:

```text
Conceito:
reduce()

Perguntas registradas:
5

Aplicações práticas:
1

Classificação:
Alta dificuldade recorrente
```

---

## 7. Histórico de Visitantes

Usuários não autenticados podem utilizar a plataforma normalmente.

Nesse caso, o histórico é armazenado temporariamente no dispositivo utilizado.

Ao criar uma conta, o histórico poderá ser associado ao novo usuário.

---

## 8. Considerações do Modelo

O modelo do sistema foi projetado para:

* permitir evolução contínua do perfil de conhecimento;
* manter conceitos padronizados;
* preservar contexto de conversas;
* suportar personalização baseada em histórico;
* facilitar futuras expansões da plataforma.