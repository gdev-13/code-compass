# 🔄 Fluxo do Usuário

## Introdução

Este documento descreve os principais fluxos de interação dos usuários com o Code Compass.

---

# Fluxo Principal

## Identificação de Conceitos

### Objetivo

Auxiliar o usuário a identificar os conhecimentos necessários para resolver um problema ou implementar uma funcionalidade.

### Pré-condições

* O usuário possui acesso à plataforma.
* O usuário pode estar autenticado ou utilizando a plataforma como visitante.

### Fluxo

1. O usuário descreve um problema, dúvida ou funcionalidade que deseja implementar.
2. O sistema analisa a solicitação utilizando inteligência artificial.
3. O sistema identifica os conceitos, tecnologias e conhecimentos relacionados ao contexto informado.
4. O sistema apresenta uma explicação sobre cada conceito identificado.
5. O sistema recomenda documentações, referências e materiais de estudo relevantes.
6. O sistema apresenta perguntas ou sugestões para estimular a reflexão e o aprendizado.
7. Caso o usuário esteja autenticado, a interação é registrada em seu histórico.
8. Caso o usuário esteja autenticado, o perfil de conhecimento é atualizado com os conceitos identificados.

### Resultado Esperado

O usuário compreende quais conhecimentos precisa estudar para alcançar seu objetivo.

---

# Fluxo Alternativo

## Informações Insuficientes

### Objetivo

Obter contexto adicional quando a solicitação não for suficiente para identificar os conceitos necessários.

### Fluxo

1. O usuário descreve um problema ou objetivo.
2. O sistema identifica baixa confiança na análise.
3. O sistema solicita informações complementares.
4. O usuário fornece mais contexto.
5. O sistema realiza uma nova análise.
6. O fluxo principal é retomado.

### Resultado Esperado

O sistema obtém informações suficientes para fornecer orientações relevantes.

---

# Fluxo Alternativo

## Conceito Já Conhecido

### Objetivo

Personalizar recomendações com base no histórico do usuário.

### Pré-condições

* Usuário autenticado.
* Perfil de conhecimento disponível.

### Fluxo

1. O sistema identifica os conceitos relacionados ao problema.
2. O sistema consulta o perfil de conhecimento do usuário.
3. O sistema identifica que um ou mais conceitos já foram estudados anteriormente.
4. O sistema recomenda aprofundamento, revisão ou aplicação prática dos conceitos.

### Resultado Esperado

O usuário recebe orientações compatíveis com seu nível de conhecimento.

---

# Fluxo Alternativo

## Novo Conceito

### Objetivo

Registrar novos conhecimentos identificados durante as interações.

### Pré-condições

* Usuário autenticado.

### Fluxo

1. O sistema identifica conceitos relacionados ao problema.
2. O sistema verifica o perfil de conhecimento.
3. O sistema identifica conceitos ainda não registrados.
4. Os novos conceitos são adicionados ao perfil do usuário.
5. O sistema recomenda materiais introdutórios para estudo.

### Resultado Esperado

O perfil de conhecimento permanece atualizado.

---

# Fluxo Alternativo

## Usuário Não Autenticado

### Objetivo

Permitir a utilização da plataforma sem necessidade de cadastro.

### Fluxo

1. O usuário acessa a plataforma sem realizar login.
2. O usuário descreve um problema, dúvida ou funcionalidade.
3. O sistema realiza a análise normalmente.
4. O sistema apresenta conceitos, explicações e materiais recomendados.
5. O sistema informa que o histórico e o perfil de conhecimento não serão armazenados sem autenticação.

### Resultado Esperado

O usuário consegue utilizar as funcionalidades principais da plataforma sem criar uma conta, compreendendo as limitações relacionadas à personalização e persistência de dados.
