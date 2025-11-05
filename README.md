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
        └── ☕ PizzariaApp.java
    └──📂Estrutura
        ├── ☕ Adicional.java
        ├── ☕ Bebidas.java
        ├── ☕ Cardapio.java
        ├── ☕ Cliente.java
        ├── ☕ Pedido.java
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

## 6. Classe: `Pedido` (Central de Transações)

A classe `Pedido` é o sistema de gerenciamento, responsável por registrar, calcular e finalizar a transação de compra. Ela agrega os itens do cardápio (`Pizza` e `Bebidas`) com as informações do `Cliente`.

### 📌 Atributos Principais

| Atributo (Privado) | Tipo | Descrição |
| :--- | :--- | :--- |
| `cliente` | `Cliente` | O objeto `Cliente` que realizou o pedido. |
| `pizzasPedidas` | `List<Pizza>` | Lista de todas as pizzas (já customizadas com adicionais) incluídas no pedido. |
| `bebidasPedidas` | `List<Bebidas>` | Lista de bebidas (incluindo volume e preço) adicionadas ao pedido. |
| `dataHoraDoPedido` | `LocalDateTime` | Registro exato de data e hora em que o pedido foi criado. |
| `valorTotal` | `double` | Valor total acumulado do pedido, calculado dinamicamente ao adicionar itens. |

### 🔨 Métodos Chave

| Método | Descrição |
| :--- | :--- |
| `Pedido(Cliente cliente)` | Construtor. Inicia um novo pedido, associando-o a um cliente e marcando a hora de criação. |
| `adicionarPizza(Pizza pizza)` | Adiciona um objeto `Pizza` à lista de pizzas e soma o preço da pizza ao `valorTotal`. |
| `adicionarBebida(Bebidas bebida)` | Adiciona um objeto `Bebidas` à lista de bebidas e soma o preço da bebida ao `valorTotal`. |
| `getValorTotal()` | Retorna o valor total atual do pedido. |
| `gerarNotaFiscal()` | Formata e retorna uma `String` completa (Nota Fiscal) com todos os dados do cliente, a lista detalhada de itens (incluindo adicionais nas pizzas) e o valor final. |

## 7.  `PizzariaApp`

**Localização:** Pacote `clientSide`

**Propósito:** Esta é a classe de inicialização do sistema e a interface de console. Ela contém o método `main()` e realiza interação entre o usuário e as classes do modelo contruido em : (`estrutura.*`), gerenciando o fluxo de pedidos, exibição do cardápio e histórico.

### 📌 Atributos e Estruturas Globais

| Atributo (Privado/Estático) | Tipo | Descrição |
| :--- | :--- | :--- |
| `clientesCadastrados` | `List<Cliente>` | Lista que simula um banco de dados, mantendo o registro de todos os clientes. |
| `todosOsPedidos` | `List<Pedido>` | Histórico de pedidos finalizados, permitindo a busca por transações antigas. |
| `scanner` | `Scanner` | Gerencia a entrada de dados do usuário via console. |

### 🔨 Métodos de Interação e Fluxo

| Método | Descrição |
| :--- | :--- |
| `main(String[] args)` | Inicia o programa, exibe a mensagem de boas-vindas e mantém o *loop* do `Menu Principal` ativo até o usuário escolher `[0] Sair`. |
| `exibirMenuPrincipal()` | Imprime as opções de interação (`Cardápio`, `Novo Pedido`, `Histórico`, `Sair`). |
| `lerOpcao()` | Lê a entrada numérica do usuário e inclui um bloco `try-catch` para lidar com entradas inválidas (não-numéricas), evitando que o programa quebre. |
| `verCardapioCompleto()` | Faz a chamada aos métodos estáticos de exibição da classe `Cardapio`, mostrando todas as opções ao usuário. |
| `buscarOuCadastrarCliente()` | Solicita o telefone do cliente. Se o `Cliente` já estiver na lista, o recupera. Caso contrário, solicita `Nome` e `Endereço` para criar e armazenar um novo `Cliente`. |
| `fazerPedido()` | **Método Central:** Implementa a lógica de criação e montagem do `Pedido`. Lida com o fluxo de seleção de Pizzas, Adicionais (em um loop aninhado) e Bebidas, utilizando os índices numéricos exibidos pelo `Cardapio`. Ao final, adiciona o pedido ao `todosOsPedidos` e imprime a nota fiscal. |
| `verHistoricoPedidos()` | Permite ao usuário buscar pedidos anteriores pelo telefone, iterando sobre a lista `todosOsPedidos` e exibindo as notas fiscais correspondentes. |  

## 💹 Melhorias futuras.
* **Deixar o método main "enxuto"** (transferir boa parte dos métodos para uma classe auxiliar e fazer com que a classe `Pizzaria.app` apenas chame métodos mas não os defina).  
* **Deixar a construção do `Cliente` mais robusta.** (Definindo uma quantidade fixa de algarismos por número).
* **Interface Gráfica.**

👥 Equipe de Desenvolvimento
* EDILMO KAIKY SANTOS TERTO 
* DAVI ALBUQUERQUE COUTINHO 
* LUIZ FERNANDO DE SOUZA FREITAS 
* PEDRO HENRIQUE FÉLIX DE LUCENA SILVA
