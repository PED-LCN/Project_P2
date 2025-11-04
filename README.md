# 🍕 Sistema de Gerenciamento de Pedidos para Pizzaria

[![Java](https://img.shields.io/badge/Linguagem-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=for-the-badge)](https://github.com/seu_usuario/seu_repositorio)

## 🌟 Visão Geral

Este projeto, desenvolvido como parte da disciplina de Programação 2 na Universidade Federal Rural de Pernambuco (UFRPE), tem como objetivo criar um sistema de gerenciamento de pedidos para uma pizzaria.

O foco principal é aplicar os conceitos de **Programação Orientada a Objetos (POO)** para modelar entidades do mundo real como Clientes, Pizzas, Bebidas e Pedidos, gerenciando o fluxo de um pedido desde sua criação até o cálculo do valor total.

Nesta fase inicial, o sistema foca exclusivamente na modelagem e nas regras de negócio, sem interface gráfica ou persistência de dados.

## 🔄 Mudanças da proposta original

O primeiro Molde deste projeto contava com 3 Classes inicialmente:
* `Cliente`
* `Pizzas`
* `pedidos`

Entretanto ao deccorrer do projeto foi verificado que para uma melhor completude, seria necessário uma nova organização do projeto, Visando uma melhor escalabilidade, sendo esta divididada em 
### 📂 Estrutura do Projeto

```text
.
└── 📂 Src/
    ├──📂 clientSide
        └── ☕ Pedido.java
    └──📂Estrutura
        ├── ☕ Adicional.java
        ├── ☕ Bebidas.java
        ├── ☕ Cardapio.java
        ├── ☕ Cliente.java
        └── ☕ Pizza.java
```
Até o momento adotamos o `Pedido.java` como sendo o `Main`. Pontanto essa será o ambiente de contado com o usuário.  
Já a Parte `estrutura` é a área de configuração base para que o programa funcione.  

⚠ Devido a mudanças na estutura base do projeto, muitos dos métodos foram removidos, remodelados e adicianados do que originalmente foi entregue na Documentação inicial(Primeira entrega).

## ⚙️ Arquitetura e Estrutura de Classes

O sistema é construído sobre cinco classes principais que interagem para simular o processo de pedido.

### 1. `Cardapio` (Estrutura Estática)
* **Propósito:** Funciona como o repositório central de dados da pizzaria. Todos os itens disponíveis (Pizzas, Bebidas, Adicionais) são carregados e armazenados em listas estáticas (`static final`).
* **Funcionalidade:** Fornece métodos de busca e exibição para que outras classes possam acessar os preços e opções de menu de forma centralizada.

### 2. `Pizza`
* **Propósito:** Representa uma pizza específica em um pedido.
* **Lógica de Preço:** O preço é calculado automaticamente no construtor através de **multiplicadores** aplicados a um preço base (definido por sabor) de acordo com o `tamanho` ("pequena", "média", "grande").
* **Customização:** Permite a adição dinâmica de ingredientes extras (`Adicional`), que somam seu valor ao preço final.

### 3. `Bebidas`
* **Propósito:** Representa uma bebida disponível, com lógica de preço baseada em volume.
* **Lógica de Preço:** O preço é calculado por multiplicadores que ajustam o preço base de acordo com o volume (`tamanhoMl`).
* **Exibição:** O método `getTamanho()` formata o volume automaticamente para `ml` ou `L` (Litros), se for `>= 1000` ml.

### 4. `Adicional`
* **Propósito:** Representa itens extras que podem ser anexados a uma pizza (ex: borda recheada, bacon extra).
* **Imutabilidade:** Possui atributos `final`, garantindo que o preço de um adicional não seja alterado após sua definição.

### 5. `Cliente`
* **Propósito:** Representa o cliente que está fazendo o pedido.
* **Atributos:** Contém informações básicas como nome, telefone e endereço.
* **Funcionalidade:** Permite atualizar o endereço.

👥 Equipe de Desenvolvimento
* EDILMO KAIKY SANTOS TERTO 
* DAVI ALBUQUERQUE COUTINHO 
* LUIZ FERNANDO DE SOUZA FREITAS 
* PEDRO HENRIQUE FÉLIX DE LUCENA SILVA
