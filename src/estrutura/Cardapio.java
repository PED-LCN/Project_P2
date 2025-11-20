package estrutura;

import java.util.ArrayList;

public class Cardapio {
    private static final ArrayList <Pizza> pizzasDisponiveis = new ArrayList<>();
    private static final ArrayList <Bebidas> bebidasDisponiveis = new ArrayList<>();
    private static final ArrayList <Adicional> adicionaisDisponiveis = new ArrayList<>();

    static {
// Pizzas pequenas
Pizza mussarelaP = new Pizza("Mussarela", "pequena");
mussarelaP.setQuantidade(3);
pizzasDisponiveis.add(mussarelaP);

Pizza calabresaP = new Pizza("Calabresa", "pequena");
calabresaP.setQuantidade(3); 
pizzasDisponiveis.add(calabresaP);

Pizza frangoP = new Pizza("Frango com Catupiry", "pequena");
frangoP.setQuantidade(3); 
pizzasDisponiveis.add(frangoP);


// Pizzas médias
Pizza mussarelaM = new Pizza("Mussarela", "media");
mussarelaM.setQuantidade(3);
pizzasDisponiveis.add(mussarelaM);

Pizza calabresaM = new Pizza("Calabresa", "media");
calabresaM.setQuantidade(3);
pizzasDisponiveis.add(calabresaM);

Pizza frangoM = new Pizza("Frango com Catupiry", "media");
frangoM.setQuantidade(3);
pizzasDisponiveis.add(frangoM);


// Pizzas grandes
Pizza mussarelaG = new Pizza("Mussarela", "grande");
mussarelaG.setQuantidade(3);
pizzasDisponiveis.add(mussarelaG);

Pizza calabresaG = new Pizza("Calabresa", "grande");
calabresaG.setQuantidade(3);
pizzasDisponiveis.add(calabresaG);

Pizza frangoG = new Pizza("Frango com Catupiry", "grande");
frangoG.setQuantidade(3);
pizzasDisponiveis.add(frangoG);


// Bebidas
Bebidas coca2L = new Bebidas("Coca-Cola", 2000);
coca2L.setQuantidade(5); 
bebidasDisponiveis.add(coca2L);

Bebidas coca1L = new Bebidas("Coca-Cola", 1000);
coca1L.setQuantidade(5);
bebidasDisponiveis.add(coca1L);

Bebidas guarana1_5L = new Bebidas("Guaraná", 1500);
guarana1_5L.setQuantidade(5);
bebidasDisponiveis.add(guarana1_5L);

Bebidas guarana1L = new Bebidas("Guaraná", 1000);
guarana1L.setQuantidade(5);
bebidasDisponiveis.add(guarana1L);

Bebidas fanta1L = new Bebidas("Fanta", 1000);
fanta1L.setQuantidade(5);
bebidasDisponiveis.add(fanta1L);

Bebidas sprite2L = new Bebidas("Sprite", 2000);
sprite2L.setQuantidade(5);
bebidasDisponiveis.add(sprite2L);

Bebidas sprite1L = new Bebidas("Sprite", 1000);
sprite1L.setQuantidade(5);
bebidasDisponiveis.add(sprite1L);

Bebidas agua0_500 = new Bebidas("Água", 500);
agua0_500.setQuantidade(10);
bebidasDisponiveis.add(agua0_500);

Bebidas lata250 = new Bebidas("Lata", 250);
lata250.setQuantidade(10);
bebidasDisponiveis.add(lata250);


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

    public static void exibirPizzasDisponiveis() {
        System.out.println("\n==============================================");
        System.out.println("                CARDÁPIO DE PIZZAS              ");
        System.out.println("==============================================");
        System.out.println("Sabor                      Tamanho    Preço");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < pizzasDisponiveis.size(); i++) {
            System.out.printf("[%d] %s\n", (i+1), pizzasDisponiveis.get(i).toString());
        }
        System.out.println("----------------------------------------------");
    }

    public static void exibirBebidasDisponiveis() {
        System.out.println("\n==============================================");
        System.out.println("              CARDÁPIO DE BEBIDAS ");
        System.out.println("==============================================");
        System.out.println("Bebida                     Tamanho    Preço");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < bebidasDisponiveis.size(); i++) {
            System.out.printf("[%d] %s\n", (i+1), bebidasDisponiveis.get(i).toString());
        }
        System.out.println("----------------------------------------------");
    }

    public static void exibirAdicionaisDisponiveis() {
        System.out.println("\n==============================================");
        System.out.println("             ADICIONAIS EXTRAS ");
        System.out.println("==============================================");
        System.out.println("Adicional                  Custo");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < adicionaisDisponiveis.size(); i++) {
            System.out.printf("[%d] %s\n", (i+1), adicionaisDisponiveis.get(i).toString());
        }
        System.out.println("----------------------------------------------");
    }
}