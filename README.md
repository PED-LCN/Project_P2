# 🍕 Sistema de Gerenciamento de Pedidos para Pizzaria

[![Java](https://img.shields.io/badge/Linguagem-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=for-the-badge)](https://github.com/seu_usuario/seu_repositorio)

## 🌟 Visão Geral

Este projeto, desenvolvido como parte da disciplina de Programação 2 na Universidade Federal Rural de Pernambuco (UFRPE), implementa um sistema de gerenciamento de pedidos para uma pizzaria. O foco principal é a aplicação dos conceitos de **Programação Orientada a Objetos (POO)** para modelar entidades como Clientes, Produtos e Pedidos, gerenciando o fluxo completo de uma transação.

Inicialmente, o sistema concentra-se na modelagem e nas regras de negócio, operando via console, sem interface gráfica ou persistência de dados.

## 📂 Estrutura do Projeto

O projeto foi organizado em pacotes para separar as responsabilidades e melhorar a escalabilidade.

```text
.
└── 📂 src/
    ├── 📂 clientSide
    │   └── ☕ PizzariaApp.java
    └── 📂 estrutura
        ├── ☕ Produto.java
        ├── ☕ Pizza.java
        ├── ☕ Bebidas.java
        ├── ☕ Adicional.java
        ├── ☕ Pedido.java
        ├── ☕ Cliente.java
        └── ☕ Cardapio.java
```

- **`clientSide`**: Contém a classe `PizzariaApp`, responsável pela interação com o usuário (interface de console).
- **`estrutura`**: Contém as classes de modelo que representam as entidades do negócio.

## ⚙️ Arquitetura e Estrutura de Classes

O sistema é construído sobre um conjunto de classes que interagem para simular o processo de um pedido.

### 1. `Produto` (Superclasse)
- **Propósito:** Classe base abstrata para todos os itens vendáveis. Define atributos comuns como `nome` e `preco`.
- **Herança:** `Pizza` e `Bebidas` herdam de `Produto`, reutilizando sua estrutura básica.

### 2. `Pizza` (Herda de `Produto`)
- **Propósito:** Representa uma pizza.
- **Lógica de Preço:** O preço é calculado no construtor com base no `sabor` e `tamanho` ("pequena", "média", "grande").
- **Customização:** Permite adicionar ingredientes extras (`Adicional`), que somam seus valores ao preço final da pizza.

### 3. `Bebidas` (Herda de `Produto`)
- **Propósito:** Representa uma bebida.
- **Lógica de Preço:** O preço é ajustado com base no volume (`tamanhoMl`).
- **Exibição:** O método `getTamanho()` formata o volume para `ml` ou `L` (Litros).

### 4. `Adicional`
- **Propósito:** Representa itens extras que podem ser adicionados a uma pizza (ex: borda recheada).
- **Características:** Seus atributos são `final`, garantindo que nome e preço não sejam alterados após a criação.

### 5. `Cliente`
- **Propósito:** Modela o cliente que realiza o pedido.
- **Atributos:** Armazena nome, telefone e endereço.

### 6. `Pedido` (Central de Transações)
- **Propósito:** Gerencia a transação de compra, agregando `Cliente`, `Pizza` e `Bebidas`.
- **Funcionalidades:**
    - Registra os itens do pedido.
    - Calcula o `valorTotal` dinamicamente.
    - Gera uma `Nota Fiscal` detalhada ao final.

### 7. `Cardapio` (Repositório Estático)
- **Propósito:** Centraliza todos os produtos disponíveis (pizzas, bebidas, adicionais).
- **Funcionalidade:** Carrega e armazena os itens em listas estáticas (`static final`), fornecendo métodos para consulta.

### 8. `PizzariaApp` (Interface de Console)
- **Propósito:** Ponto de entrada do sistema (`main`). Gerencia a interação com o usuário.
- **Funcionalidades:**
    - Exibe o menu principal.
    - Processa a criação de novos pedidos.
    - Permite a consulta ao cardápio e ao histórico de pedidos.
    - Gerencia o cadastro e a busca de clientes.

## 🚀 Melhorias Futuras

- **Refatorar `PizzariaApp.java`**: Transferir a lógica de negócio para classes de serviço, mantendo o `main` apenas como ponto de entrada.
- **Interface Gráfica**: Desenvolver uma GUI para facilitar a interação do usuário.
- **Persistência de Dados**: Integrar um banco de dados ou sistema de arquivos para salvar o estado da aplicação (pedidos, clientes).

## 👥 Equipe de Desenvolvimento

- EDILMO KAIKY SANTOS TERTO
- DAVI ALBUQUERQUE COUTINHO
- LUIZ FERNANDO DE SOUZA FREITAS
- PEDRO HENRIQUE FÉLIX DE LUCENA SILVA
