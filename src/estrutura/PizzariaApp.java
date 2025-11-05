package estrutura;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzariaApp {

    private static List<Cliente> clientesCadastrados = new ArrayList<>();
    private static List<Pedido> todosOsPedidos = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Bem-vindo à Pizzaria!");

        while (true) {
            exibirMenuPrincipal();
            int escolha = lerOpcao();

            switch (escolha) {
                case 1:
                    verCardapioCompleto();
                    break;
                case 2:
                    fazerPedido();
                    break;
                case 3:
                    verHistoricoPedidos();
                    break;
                case 0:
                    System.out.println("Obrigado por usar nosso sistema. Volte sempre!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("[1] Ver Cardápio");
        System.out.println("[2] Fazer Pedido");
        System.out.println("[3] Ver Meus Pedidos Antigos");
        System.out.println("[0] Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.nextLine();
            return -1;
        }
    }

    private static void verCardapioCompleto() {
        Cardapio.exibirPizzasDisponiveis();
        Cardapio.exibirBebidasDisponiveis();
        Cardapio.exibirAdicionaisDisponiveis();
    }

    private static void fazerPedido() {
        System.out.println("\n--- FAZER PEDIDO ---");
        Cliente cliente = buscarOuCadastrarCliente();

        Pedido novoPedido = new Pedido(cliente);

        while (true) {
            System.out.println("\n--- Adicionar Pizzas ---");
            Cardapio.exibirPizzasDisponiveis();
            System.out.print("Escolha uma pizza pelo NÚMERO (ou 0 para parar de adicionar pizzas): ");
            int escolhaPizza = lerOpcao();

            if (escolhaPizza == 0) break;

            try {
                Pizza pizzaTemplate = Cardapio.getPizzasDisponiveis().get(escolhaPizza - 1);
                Pizza pizzaDoCliente = new Pizza(pizzaTemplate.getSabor(), pizzaTemplate.getTamanho());

                while (true) {
                    System.out.println("\n--- Adicionais para a Pizza: " + pizzaDoCliente.getSabor() + " ---");
                    Cardapio.exibirAdicionaisDisponiveis();
                    System.out.print("Escolha um ADICIONAL pelo NÚMERO (ou 0 para parar de adicionar extras): ");
                    int escolhaAdicional = lerOpcao();

                    if (escolhaAdicional == 0) break;

                    try {
                        Adicional adicional = Cardapio.getAdicionaisDisponiveis().get(escolhaAdicional - 1);
                        if (adicional.getPreco() == 0) break;

                        pizzaDoCliente.adicionarAdicionais(adicional);
                        System.out.println("Adicional '" + adicional.getNome() + "' incluído.");

                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Opção de adicional inválida. Tente novamente.");
                    }
                }

                novoPedido.adicionarPizza(pizzaDoCliente);
                System.out.println("Pizza " + pizzaDoCliente.getSabor() + " adicionada ao pedido.");

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Opção de pizza inválida. Tente novamente.");
            }
        }

        while (true) {
            System.out.println("\n--- Adicionar Bebidas ---");
            Cardapio.exibirBebidasDisponiveis();
            System.out.print("Escolha uma BEBIDA pelo NÚMERO (ou 0 para parar de adicionar bebidas): ");
            int escolhaBebida = lerOpcao();

            if (escolhaBebida == 0) break;

            try {
                Bebidas bebidaEscolhida = Cardapio.getBebidasDisponiveis().get(escolhaBebida - 1);
                novoPedido.adicionarBebida(bebidaEscolhida);
                System.out.println(bebidaEscolhida.getNome() + " adicionada.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Opção de bebida inválida. Tente novamente.");
            }
        }

        if (novoPedido.getValorTotal() > 0) {
            todosOsPedidos.add(novoPedido);
            System.out.println("\nPedido finalizado com sucesso!");

            System.out.println(novoPedido.gerarNotaFiscal());
        } else {
            System.out.println("Nenhum item foi adicionado. Pedido cancelado.");
        }
    }

    private static void verHistoricoPedidos() {
        System.out.println("\n--- HISTÓRICO DE PEDIDOS ---");
        System.out.print("Digite seu TELEFONE para buscar seus pedidos (ex: 999998888): ");
        String telefone = scanner.nextLine();

        boolean encontrouPedidos = false;

        System.out.println("\n--- Seus Pedidos Antigos ---");
        for (Pedido p : todosOsPedidos) {
            if (p.getCliente().getTelefone().equals(telefone)) {
                System.out.println(p.gerarNotaFiscal());
                encontrouPedidos = true;
            }
        }

        if (!encontrouPedidos) {
            System.out.println("Nenhum pedido encontrado para o telefone " + telefone);
        }
    }

    private static Cliente buscarOuCadastrarCliente() {
        System.out.print("Digite o telefone do cliente (ex: 999998888): ");
        String telefone = scanner.nextLine();

        for (Cliente c : clientesCadastrados) {
            if (c.getTelefone().equals(telefone)) {
                System.out.println("Cliente encontrado: " + c.getNome());
                return c;
            }
        }
        
        System.out.println("Cliente não encontrado. Vamos cadastrar:");
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o endereço de entrega: ");
        String endereco = scanner.nextLine();

        Cliente novoCliente = new Cliente(nome, telefone, endereco);
        clientesCadastrados.add(novoCliente);
        System.out.println("Cliente " + nome + " cadastrado com sucesso!");
        return novoCliente;
    }
}