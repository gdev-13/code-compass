# 🗄️ Modelo de Banco de Dados

## 1. Introdução

Este documento descreve a estrutura inicial de persistência de dados do Code Compass.

Seu objetivo é servir como referência para a implementação das entidades e relacionamentos definidos no modelo do sistema.

Esta versão representa uma visão inicial e poderá evoluir conforme novas necessidades forem identificadas durante o desenvolvimento.

---

## 2. Entidades Principais

### User

Armazena informações dos usuários autenticados.

**Principais atributos:**

* id
* name
* email
* password
* createdAt
* updatedAt

---

### KnowledgeProfile

Representa o perfil de conhecimento de um usuário.

**Principais atributos:**

* id
* createdAt
* updatedAt

**Relacionamentos:**

* User (1:1)

---

### Technology

Representa uma tecnologia conhecida pelo sistema.

**Principais atributos:**

* id
* name
* description

---

### Concept

Representa um conceito técnico padronizado.

**Principais atributos:**

* id
* name
* description

**Relacionamentos:**

* Technology (N:1)

---

### UserConcept

Representa a relação entre um usuário e um conceito.

**Principais atributos:**

* id
* estimatedLevel
* evidenceCount
* lastInteractionAt
* recurringDifficulty

**Relacionamentos:**

* KnowledgeProfile (N:1)
* Concept (N:1)

---

### Evidence

Representa evidências utilizadas para construir o perfil de conhecimento.

**Principais atributos:**

* id
* type
* description
* createdAt

**Relacionamentos:**

* UserConcept (N:1)
* Message (N:1)

---

### Conversation

Representa uma conversa realizada pelo usuário.

**Principais atributos:**

* id
* title
* createdAt
* updatedAt

**Relacionamentos:**

* User (N:1)

---

### Message

Representa uma mensagem individual dentro de uma conversa.

**Principais atributos:**

* id
* content
* role
* createdAt

**Relacionamentos:**

* Conversation (N:1)

---

### Project

Representa um contexto de projeto utilizado pelo usuário.

**Principais atributos:**

* id
* name
* description
* technicalContext
* createdAt
* updatedAt

**Relacionamentos:**

* User (N:1)

---

## 3. Relacionamentos

```text
User 1 ───── 1 KnowledgeProfile

User 1 ───── N Conversation

Conversation 1 ───── N Message

KnowledgeProfile 1 ───── N UserConcept

Concept 1 ───── N UserConcept

UserConcept 1 ───── N Evidence

Message 1 ───── N Evidence

Technology 1 ───── N Concept

User 1 ───── N Project
```

---

## 4. Relacionamentos Muitos-para-Muitos

### Project e Technology

Um projeto pode utilizar várias tecnologias.

Uma tecnologia pode estar presente em vários projetos.

```text
Project N ───── N Technology
```

Implementação sugerida:

```text
project_technologies
- project_id
- technology_id
```

---

## 5. Enums Sugeridos

### EstimatedLevel

```text
BEGINNER
BASIC
INTERMEDIATE
ADVANCED
```

---

### RecurringDifficulty

```text
LOW
MEDIUM
HIGH
```

---

### EvidenceType

```text
QUESTION
CONCEPT_EXPLANATION
PRACTICAL_USAGE
RECURRING_DIFFICULTY
```

---

### MessageRole

```text
USER
ASSISTANT
```

---

## 6. Considerações

A estrutura foi projetada para:

* suportar evolução contínua do perfil de conhecimento;
* registrar evidências de aprendizado;
* preservar histórico de conversas;
* permitir personalização baseada em contexto;
* facilitar futuras expansões da plataforma.
