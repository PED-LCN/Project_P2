package estrutura;

import java.util.ArrayList;

public class Pizza {
    private String sabor;
    private String tamanho;
    private double preco;
    private ArrayList<Adicional> ingredientesAdicionais;

    public Pizza(String sabor, String tamanho) {
        this.sabor = sabor;
        this.tamanho = tamanho;
        this.preco = precoBaseTamanho(tamanho);
        this.ingredientesAdicionais = new ArrayList<>();
    }

    public void adicionarAdicionais(Adicional item){
        this.ingredientesAdicionais.add(item);
        this.preco += item.getPreco();
        System.out.println("Adicional: " + item.getNome() + "Adicionado à Pizza!");
    }

    public double getPreco() {
        return preco;
    }

    public String getSabor() {
        return sabor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public ArrayList<Adicional> getIngredientesAdicionais() {
        return ingredientesAdicionais;
    }

    private double precoBaseTamanho(String tamanho){
        double precoBase = definirPrecoBase(sabor);
        switch (tamanho.toLowerCase().strip()) {
            case "pequena":
                precoBase *= 1.0;
                break;
            case "media":
                precoBase *= 1.5; 
                break;
            case "grande":
                precoBase *= 2; 
                break;
            default:
                precoBase*=1;
                break;
        }
        return precoBase;
    }

    private double definirPrecoBase(String sabor) {
        double precoBase;
        switch (sabor.toLowerCase().strip()) {
            case "calabresa", "frango com catupiry":
                precoBase = 31.0;
                break;
            case "mussarela", "portuguesa":
                precoBase = 29.0;
                break;
            default:
                precoBase = 25.0;
                break;
        }
        return precoBase;
    }

    @Override
    public String toString() {
        return String.format("%-24s %-8s R$%.2f", this.sabor, this.tamanho, this.preco);
    }

}

