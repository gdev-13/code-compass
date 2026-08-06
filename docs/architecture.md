# 🏗️ Arquitetura do Sistema

## 1. Introdução

Este documento descreve a arquitetura conceitual do Code Compass, uma plataforma de orientação de aprendizado para desenvolvedores baseada em inteligência artificial.

O objetivo da arquitetura é definir como os diferentes componentes do sistema trabalham juntos para analisar dúvidas técnicas, identificar conceitos relacionados, recomendar fontes de estudo e construir um modelo evolutivo de conhecimento do usuário.

O Code Compass não tem como objetivo substituir o desenvolvimento de soluções ou fornecer apenas respostas prontas. Sua proposta é orientar o usuário sobre quais conceitos compreender, onde estudá-los e como evoluir seu conhecimento de acordo com seu contexto e experiência.

---

## 2. Visão Geral da Arquitetura

O funcionamento do sistema é baseado em quatro pilares principais:

* **Análise de solicitações:** interpretação dos problemas apresentados pelo usuário;
* **Orientação baseada em conceitos:** identificação dos conhecimentos necessários para resolver um problema;
* **Contextualização personalizada:** adaptação das respostas considerando histórico, projetos e conhecimento do usuário;
* **Evolução do conhecimento:** construção contínua do perfil de conhecimento através das interações.

Fluxo geral:

1. Usuário registra uma solicitação;
2. Sistema analisa o contexto disponível;
3. Informações relevantes do usuário são recuperadas;
4. A IA processa a solicitação considerando o contexto;
5. Conceitos relacionados são identificados;
6. Referências e materiais de estudo são associados;
7. Uma resposta personalizada é apresentada;
8. O conhecimento do usuário é atualizado com base na interação.

---

## 3. Componentes Principais

### 3.1 Gerenciamento de Usuários

Responsável pelo cadastro, autenticação e gerenciamento das informações pessoais do usuário.

Responsabilidades:

* cadastro de usuários;
* autenticação;
* gerenciamento de preferências;
* controle de acesso às informações personalizadas.

---

### 3.2 Perfil de Conhecimento

O perfil de conhecimento representa o estado evolutivo do conhecimento técnico do usuário.

Ele não funciona como uma lista fixa de habilidades, mas como um modelo baseado em evidências coletadas através das interações.

O perfil pode conter:

* tecnologias utilizadas;
* conceitos demonstrados;
* nível estimado de domínio;
* dificuldades recorrentes;
* histórico de evolução.

Exemplo:

```
Java

Nível estimado:
Intermediário

Evidências:
- Criação de APIs REST
- Uso de Spring Boot
- Implementação de persistência com JPA

Pontos recorrentes:
- Segurança
- Testes automatizados
```

O nível de conhecimento não representa uma avaliação absoluta, mas uma estimativa baseada no comportamento observado.

---

### 3.3 Contexto de Projetos

Projetos são utilizados como contexto adicional para melhorar a compreensão das solicitações.

O objetivo não é gerenciar projetos, mas permitir que a IA compreenda o ambiente em que determinado problema está ocorrendo.

Um contexto de projeto pode possuir:

* tecnologias utilizadas;
* conceitos relacionados;
* conversas associadas;
* contexto técnico.

Exemplo:

```
Projeto:
API de gerenciamento

Tecnologias:
- Spring Boot
- PostgreSQL
- React

Conceitos relacionados:
- JWT
- CORS
- REST API
```

---

## 4. Sistema de Memória da IA

O Code Compass utiliza dois níveis de memória para equilibrar contexto e eficiência.

---

### 4.1 Memória de Curto Prazo

Responsável pelo contexto detalhado da interação atual.

Armazena informações como:

* mensagens recentes;
* detalhes da implementação discutida;
* decisões tomadas durante a conversa;
* erros encontrados;
* contexto específico do projeto.

Exemplo:

```
Conversa atual:

Projeto:
Sistema financeiro

Contexto:
Implementação de autenticação JWT

Discussões:
- SecurityConfig
- Filtros
- Controle de acesso
```

Essa memória permite respostas coerentes dentro da conversa atual.

---

### 4.2 Memória de Longo Prazo

Responsável por armazenar informações relevantes sobre a evolução do usuário.

Não armazena todas as conversas integralmente, mas extrai informações importantes.

Inclui:

* perfil de conhecimento;
* conceitos identificados;
* dificuldades recorrentes;
* histórico resumido;
* projetos associados.

Exemplo:

```
Conceito:
JWT

Evidências:
- Estudou autenticação baseada em tokens
- Implementou fluxo utilizando Spring Security

Última interação:
08/2026
```

---

## 5. Fluxo de Processamento da IA

Quando uma solicitação é realizada, o sistema segue o fluxo:

1. Usuário envia uma dúvida;
2. Sistema identifica o contexto disponível;
3. Informações relevantes são recuperadas:

   * Perfil de conhecimento;
   * Projeto relacionado;
   * Histórico de interações;
4. IA analisa a solicitação;
5. Conceitos envolvidos são identificados;
6. Conceitos são relacionados com tecnologias e documentações;
7. Uma resposta personalizada é gerada;
8. O perfil de conhecimento do usuário é atualizado.

---

## 6. Identificação de Conceitos

A identificação de conceitos utiliza uma abordagem híbrida.

A inteligência artificial é responsável por interpretar a intenção do usuário e sugerir conceitos relacionados.

O sistema é responsável por validar, padronizar, manter e relacionar conceitos com:

* tecnologias;
* documentações oficiais;
* conhecimentos relacionados.

Exemplo:

Entrada:

```
"Quero remover o primeiro item de uma lista JavaScript"
```

Conceitos identificados:

```
JavaScript Arrays

Relacionado:
Array.prototype.shift()

Documentação:
MDN Web Docs
```

Essa abordagem evita inconsistências e permite uma evolução mais confiável do perfil de conhecimento.

---

## 7. Orientação Baseada em Documentação

A documentação oficial é uma parte central da orientação.

O sistema não deve apenas indicar uma documentação, mas informar:

* qual tecnologia consultar;
* qual conceito pesquisar;
* por que aquele conceito está relacionado ao problema.

Exemplo:

```
Tecnologia:
Spring Security

Pesquisar:
- Authentication
- Authorization
- Security Filters

Motivo:
Esses conceitos explicam como requisições autenticadas são processadas pelo framework.
```

---

## 8. Respostas Adaptativas

As respostas devem considerar dois fatores principais:

### Conhecimento do usuário

Usuários com maior domínio recebem explicações mais focadas em conceitos avançados.

Usuários iniciantes recebem explicações mais detalhadas dos fundamentos.

---

### Complexidade da solicitação

Solicitações simples devem receber respostas objetivas.

Solicitações arquiteturais ou de maior complexidade devem apresentar uma análise mais completa.

Exemplo:

```
Pergunta:
"Como centralizar uma div?"

Resposta:
- Flexbox
- justify-content
- align-items
```

```
Pergunta:
"Como implementar autenticação?"

Resposta:
- Fluxo de autenticação
- Conceitos envolvidos
- Segurança
- Documentação recomendada
```

---

## 9. Histórico de Conversas

As conversas realizadas pelo usuário são armazenadas para permitir:

* retomada de assuntos anteriores;
* continuidade de aprendizado;
* recuperação de contexto;
* geração de evidências para o perfil.

O histórico completo serve como fonte para atualização da memória de longo prazo.

---

## 10. Princípios Arquiteturais

A arquitetura do Code Compass segue os seguintes princípios:

### Personalização

As respostas devem considerar o contexto individual de cada usuário.

---

### Aprendizado contínuo

O sistema deve evoluir seu entendimento sobre o usuário através das interações.

---

### Orientação ao invés de substituição

O sistema deve ensinar o usuário a encontrar e compreender soluções, não apenas entregar respostas prontas.

---

### Uso de fontes confiáveis

As recomendações devem priorizar documentações oficiais das tecnologias utilizadas.

---

### Separação entre contexto e conhecimento

Informações temporárias da conversa devem ser separadas das informações permanentes sobre o usuário.
