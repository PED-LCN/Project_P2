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
        ├── ☕ Cardapio.java
        ├── ☕ TelefoneInvalidoException.java
        └── ☕ ProdutoForaDeEstoqueException.java
```

- **`clientSide`**: Contém a classe `PizzariaApp`, responsável pela interação com o usuário (interface de console).
- **`estrutura`**: Contém as classes de modelo que representam as entidades do negócio e as exceções personalizadas.

## ⚙️ Arquitetura e Estrutura de Classes

O sistema é construído sobre um conjunto de classes que interagem para simular o processo de um pedido.

### 1. `Produto` (Superclasse)
- **Propósito:** Classe base para todos os itens vendáveis. Define atributos comuns como `nome` e `preco`.
- **Herança:** `Pizza` e `Bebidas` herdam de `Produto`.

### 2. `Pizza` (Herda de `Produto`)
- **Propósito:** Representa uma pizza.
- **Lógica de Preço:** O preço é calculado com base no `sabor` e `tamanho`.
- **Customização:** Permite adicionar `Adicional`, que somam seus valores ao preço final.

### 3. `Bebidas` (Herda de `Produto`)
- **Propósito:** Representa uma bebida.
- **Lógica de Preço:** O preço é ajustado com base no volume (`tamanhoMl`).

### 4. `Adicional`
- **Propósito:** Representa itens extras para uma pizza.
- **Características:** Atributos `final` para garantir imutabilidade.

### 5. `Cliente`
- **Propósito:** Modela o cliente.
- **Atributos:** Armazena nome, telefone e endereço.
- **Validação:** Lança `TelefoneInvalidoException` se o formato do telefone for inválido.

### 6. `Pedido`
- **Propósito:** Gerencia a transação, agregando `Cliente`, `Pizza` e `Bebidas`.
- **Funcionalidades:** Registra itens, calcula o `valorTotal` e gera `Nota Fiscal`.

### 7. `Cardapio`
- **Propósito:** Repositório estático para todos os produtos.
- **Funcionalidade:** Carrega e fornece acesso aos itens do menu.

### 8. `PizzariaApp`
- **Propósito:** Ponto de entrada do sistema (`main`) e interface de console.
- **Funcionalidades:** Gerencia o fluxo de pedidos, exibe o cardápio e o histórico.

## 🛡️ Tratamento de Exceções

Para tornar o sistema mais robusto, foram implementadas exceções personalizadas:

- **`TelefoneInvalidoException`**: Lançada quando o número de telefone fornecido durante o cadastro de um cliente não segue o formato esperado.
- **`ProdutoForaDeEstoqueException`**: Lançada ao tentar adicionar um item a um pedido que não está disponível no `Cardapio`.

## 🚀 Melhorias Futuras

- **Refatorar `PizzariaApp.java`**: Mover a lógica de negócio para classes de serviço.
- **Interface Gráfica**: Desenvolver uma GUI para uma melhor experiência do usuário.
- **Persistência de Dados**: Integrar um banco de dados para salvar o estado da aplicação.

## 👥 Equipe de Desenvolvimento

- EDILMO KAIKY SANTOS TERTO
- DAVI ALBUQUERQUE COUTINHO
- LUIZ FERNANDO DE SOUZA FREITAS
- PEDRO HENRIQUE FÉLIX DE LUCENA SILVA
