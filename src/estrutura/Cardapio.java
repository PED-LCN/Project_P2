package estrutura;

import java.util.ArrayList;

public class Cardapio {
    private static final ArrayList <Pizza> pizzasDisponiveis = new ArrayList<>();
    private static final ArrayList <Bebidas> bebidasDisponiveis = new ArrayList<>();
    private static final ArrayList <Adicional> adicionaisDisponiveis = new ArrayList<>();

    static {
        pizzasDisponiveis.add(new Pizza("Mussarela", "pequena"));
        pizzasDisponiveis.add(new Pizza("Calabresa", "pequena"));
        pizzasDisponiveis.add(new Pizza("Frango com Catupiry", "pequena"));

        pizzasDisponiveis.add(new Pizza("Mussarela", "media"));
        pizzasDisponiveis.add(new Pizza("Calabresa", "media"));
        pizzasDisponiveis.add(new Pizza("Frango com Catupiry", "media"));

        pizzasDisponiveis.add(new Pizza("Mussarela", "grande"));
        pizzasDisponiveis.add(new Pizza("Calabresa", "grande"));
        pizzasDisponiveis.add(new Pizza("Frango com Catupiry", "grande"));

        bebidasDisponiveis.add(new Bebidas("Coca-Cola", 2000));
        bebidasDisponiveis.add(new Bebidas("Coca-Cola", 1000));
        bebidasDisponiveis.add(new Bebidas("Guaraná", 1500));
        bebidasDisponiveis.add(new Bebidas("Fanta", 1000));
        bebidasDisponiveis.add(new Bebidas("Sprite", 2000));
        bebidasDisponiveis.add(new Bebidas("Água", 500));
        bebidasDisponiveis.add(new Bebidas("Lata", 250));

        adicionaisDisponiveis.add(new Adicional("Bacon Extra", 5.00));
        adicionaisDisponiveis.add(new Adicional("Cheddar", 7.50));
        adicionaisDisponiveis.add(new Adicional("Borda de Catupiry", 10.00));
        adicionaisDisponiveis.add(new Adicional("Sem Adicional", 0.00));
    }

    public static ArrayList<Pizza> getPizzasDisponiveis() {
        return pizzasDisponiveis;
    }

    public static ArrayList<Bebidas> getBebidasDisponiveis() {
        return bebidasDisponiveis;
    }

    public static ArrayList<Adicional> getAdicionaisDisponiveis() {
        return adicionaisDisponiveis;
    }

    public static Pizza buscarPizzaPorNome(String nome) {
        for (Pizza pizza : pizzasDisponiveis) {
            if (pizza.getSabor().equalsIgnoreCase(nome)) {
                return pizza;
            }
        }
        return null;
    }
    public static Bebidas buscarBebidaPorNome(String nome) {
        for (Bebidas bebida : bebidasDisponiveis) {
            if (bebida.getNome().equalsIgnoreCase(nome)) {
                return bebida;
            }
        }
        return null;
    }
    public static Adicional buscarAdicionalPorNome(String nome) {
        for (Adicional adicional : adicionaisDisponiveis) {
            if (adicional.getNome().equalsIgnoreCase(nome)) {
                return adicional;
            }
        }
        return null;
    }

    public static void exibirPizzasDisponiveis() {
        System.out.println("\n==============================================");
        System.out.println("                CARDÁPIO DE PIZZAS              ");
        System.out.println("==============================================");
        System.out.println("    Sabor                      Tamanho    Preço");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < pizzasDisponiveis.size(); i++) {
            System.out.printf("%d. %s\n", (i+1), pizzasDisponiveis.get(i).toString());
        }
        System.out.println("----------------------------------------------");
    }

    public static void exibirBebidasDisponiveis() {
        System.out.println("\n==============================================");
        System.out.println("              CARDÁPIO DE BEBIDAS ");
        System.out.println("==============================================");
        System.out.println("    Bebida                     Tamanho    Preço");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < bebidasDisponiveis.size(); i++) {
            System.out.printf("%d. %s\n", (i+1), bebidasDisponiveis.get(i).toString());
        }
        System.out.println("----------------------------------------------");
    }

    public static void exibirAdicionaisDisponiveis() {
        System.out.println("\n==============================================");
        System.out.println("             ADICIONAIS EXTRAS ");
        System.out.println("==============================================");
        System.out.println("    Adicional                  Custo");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < adicionaisDisponiveis.size(); i++) {
            System.out.printf("%d. %s\n", (i+1), adicionaisDisponiveis.get(i).toString());
        }
        System.out.println("----------------------------------------------");
    }
}