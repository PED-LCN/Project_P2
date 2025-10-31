package estrutura;

import java.util.ArrayList;

public class Cardapio {
    private static final ArrayList <Pizza> pizzasDisponiveis = new ArrayList<>();
    private static final ArrayList <Bebidas> bebidasDisponiveis= new ArrayList<>();

    //adicionar as pizzas que vamos utilizar
    //static{
//        pizzasDisponiveis.add();
//        pizzasDisponiveis.add();
//        pizzasDisponiveis.add();
//        }
//    static{
//        bebidasDisponiveis.add();
//        bebidasDisponiveis.add();
//        bebidasDisponiveis.add();
//    }

    public static ArrayList<Pizza> getPizzasDisponiveis() {
        return pizzasDisponiveis;
    }

    public static Pizza buscarPizzaPorNome(String nome) {
        for (Pizza pizza : pizzasDisponiveis) {
            if (pizza.getSabor().equalsIgnoreCase(nome)) {
                return pizza;
            }
        }
        return null;
    }
}
