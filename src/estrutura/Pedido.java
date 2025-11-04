package estrutura;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Pizza> pizzasPedidas;
    private List<Bebidas> bebidasPedidas;
    private LocalDateTime dataHoraDoPedido;
    private double valorTotal;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.pizzasPedidas = new ArrayList<>();
        this.bebidasPedidas = new ArrayList<>();
        this.dataHoraDoPedido = LocalDateTime.now();
        this.valorTotal = 0.0;
    }

    public void adicionarPizza(Pizza pizza) {
        this.pizzasPedidas.add(pizza);
        this.valorTotal += pizza.getPreco();
    }

    public void adicionarBebida(Bebidas bebida) {
        this.bebidasPedidas.add(bebida);
        this.valorTotal += bebida.getPreco();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public LocalDateTime getDataHoraDoPedido() {
        return dataHoraDoPedido;
    }

    public String gerarNotaFiscal() {
        StringBuilder nota = new StringBuilder();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm:ss");

        nota.append("\n========================================\n");
        nota.append("          NOTA FISCAL - PIZZARIA         \n");
        nota.append("========================================\n");
        nota.append("Cliente: ").append(this.cliente.getNome()).append("\n");
        nota.append("Telefone: ").append(this.cliente.getTelefone()).append("\n");
        nota.append("Endereço: ").append(this.cliente.getEndereco()).append("\n");
        nota.append("Data do Pedido: ").append(this.dataHoraDoPedido.format(formatador)).append("\n");
        nota.append("----------------------------------------\n");
        nota.append("ITENS PEDIDOS:\n");

        if (pizzasPedidas.isEmpty() && bebidasPedidas.isEmpty()) {
            nota.append("Nenhum item no pedido.\n");
        } else {
            for (Pizza pizza : pizzasPedidas) {
                nota.append(String.format("- Pizza %-15s (Tam: %s) R$%.2f\n",
                        pizza.getSabor(), pizza.getTamanho(), pizza.getPreco()));

                for (Adicional add : pizza.getIngredientesAdicionais()) {
                    if (add.getPreco() > 0) {
                        nota.append(String.format("    -> com %s\n", add.getNome()));
                    }
                }
            }
            for (Bebidas bebida : bebidasPedidas) {
                nota.append(String.format("- Bebida %-14s (%s) R$%.2f\n",
                        bebida.getNome(), bebida.getTamanho(), bebida.getPreco()));
            }
        }

        nota.append("----------------------------------------\n");
        nota.append(String.format("VALOR TOTAL: R$ %.2f\n", this.valorTotal));
        nota.append("========================================\n");

        return nota.toString();
    }
}