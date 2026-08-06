# 🧠 Fluxo de Inteligência

## 1. Introdução

Este documento descreve como o Code Compass processa solicitações dos usuários e as transforma em orientações personalizadas.

Diferentemente de assistentes focados apenas em fornecer respostas prontas, o Code Compass busca identificar os conhecimentos envolvidos em um problema, relacioná-los ao contexto do usuário e contribuir para a evolução contínua do seu conhecimento técnico.

O fluxo de inteligência define como as solicitações são analisadas, como o contexto é recuperado, como os conceitos são identificados e como o mapa de conhecimento do usuário evolui ao longo do tempo.

---

## 2. Visão Geral do Fluxo

Quando um usuário realiza uma solicitação, o Code Compass executa uma sequência de etapas para produzir uma orientação contextualizada.

Fluxo geral:

1. Usuário envia uma solicitação;
2. O sistema recupera informações relevantes de contexto;
3. A IA analisa a solicitação;
4. Conceitos relacionados são identificados;
5. Os conceitos são associados ao mapa de conhecimento do usuário;
6. Uma resposta personalizada é gerada;
7. Evidências são extraídas da interação;
8. O mapa de conhecimento é atualizado.

O objetivo desse processo não é apenas responder à solicitação atual, mas também aprimorar continuamente a compreensão do sistema sobre o usuário.

---

## 3. Recuperação de Contexto

Antes de analisar uma solicitação, o sistema recupera informações que possam contribuir para uma resposta mais relevante.

As informações são priorizadas de acordo com sua importância para a situação atual.

Ordem de prioridade:

1. Conversa atual;
2. Contexto do projeto relacionado;
3. Conversas semelhantes anteriores;
4. Mapa de conhecimento do usuário.

Essa abordagem permite que a IA considere primeiro as informações mais relevantes para o problema em questão, evitando o uso excessivo de contexto desnecessário.

---

## 4. Análise da Solicitação

Após a recuperação de contexto, a IA analisa a solicitação considerando:

* objetivo do usuário;
* tecnologias mencionadas;
* contexto do projeto;
* interações anteriores relacionadas;
* dificuldades recorrentes;
* conceitos previamente explorados.

O foco dessa etapa é compreender o problema apresentado antes de gerar uma orientação.

Exemplo:

Solicitação:

```text
"Preciso implementar autenticação com JWT."
```

Possível interpretação:

```text
Objetivo:
Implementar autenticação.

Tecnologia:
Java / Spring Boot.

Conceitos envolvidos:
- Authentication
- Authorization
- JWT
- Spring Security
```

---

## 5. Identificação de Conceitos

A identificação de conceitos utiliza uma abordagem híbrida.

A IA é responsável por interpretar a solicitação e identificar os conceitos relacionados ao problema.

Em seguida, o sistema organiza esses conceitos dentro da estrutura de conhecimento utilizada pelo Code Compass.

Exemplo:

Entrada:

```text
"Quero remover o primeiro elemento de uma lista JavaScript."
```

Conceitos identificados:

```text
- Arrays
- Manipulação de arrays
- Array.prototype.shift()
```

Essa abordagem permite flexibilidade para lidar com diferentes tecnologias sem depender de um catálogo totalmente definido manualmente.

---

## 6. Perfil de Conhecimento

Cada usuário possui um mapa de conhecimento próprio.

Esse mapa não representa uma avaliação definitiva das habilidades do usuário, mas um modelo evolutivo baseado em evidências coletadas durante as interações.

O mapa pode conter:

* conceitos explorados;
* nível estimado de domínio;
* evidências registradas;
* dificuldades recorrentes;
* histórico de evolução.

Exemplo:

```text
JavaScript

Arrays
├── map()
├── filter()
└── reduce()

Status:
Explorado

Dificuldades recorrentes:
- Métodos de array
```

O objetivo do mapa é permitir que o sistema compreenda quais conceitos já foram abordados, quais apresentam recorrência de dúvidas e quais podem exigir explicações mais detalhadas.

---

## 7. Geração de Respostas

Após identificar os conceitos envolvidos, o sistema gera uma resposta considerando:

* contexto da solicitação;
* tecnologias utilizadas;
* projeto relacionado;
* conceitos identificados;
* mapa de conhecimento do usuário.

As respostas devem priorizar orientação em vez de apenas apresentar soluções prontas.

Sempre que possível, a resposta deve:

* explicar por que determinado conceito está relacionado ao problema;
* indicar documentações oficiais relevantes;
* sugerir tópicos para aprofundamento;
* adaptar o nível de detalhamento ao contexto do usuário.

---

## 8. Extração de Evidências

Após a geração da resposta, o sistema pode extrair evidências relevantes da interação.

As evidências servem para registrar o relacionamento do usuário com determinados conceitos.

Exemplos de evidências:

* solicitação de explicação sobre um conceito;
* aplicação prática de um conceito;
* dúvidas recorrentes;
* utilização de determinada tecnologia.

As evidências são utilizadas para atualizar o mapa de conhecimento e auxiliar na personalização de futuras respostas.

---

## 9. Atualização do Mapa de Conhecimento

O mapa de conhecimento é atualizado continuamente ao longo das interações.

A atualização não significa que o usuário domina um conceito, mas que existe uma nova evidência relacionada a ele.

Exemplo:

```text
Conceito:
reduce()

Evidências:
- Solicitou explicação sobre o conceito
- Utilizou em um exemplo simples

Nível estimado:
Inicial
```

Com novas evidências, a estimativa pode evoluir ao longo do tempo.

---

## 10. Princípios do Fluxo de Inteligência

O fluxo de inteligência do Code Compass segue os seguintes princípios:

### Contexto em primeiro lugar

As respostas devem considerar o contexto atual antes de recorrer a informações históricas.

---

### Evolução contínua

O sistema deve aprimorar seu entendimento sobre o usuário através das interações.

---

### Conhecimento baseado em evidências

O mapa de conhecimento deve ser construído a partir de evidências observadas, e não de suposições.

---

### Personalização

As respostas devem ser adaptadas ao contexto, experiência e dificuldades recorrentes do usuário.

---

### Orientação ao invés de substituição

O objetivo principal é auxiliar o usuário a compreender conceitos e encontrar informações relevantes, não apenas fornecer respostas prontas.