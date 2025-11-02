package estrutura;

import java.util.ArrayList;

public class Pizza {
    private String sabor;
    private String tamanho;
    private double preco;
    private ArrayList<String> ingredientesAdicionais;

    public Pizza(String sabor, String tamanho, double preco) {
        this.sabor = sabor;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
    public String getSabor() {
        return sabor;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
