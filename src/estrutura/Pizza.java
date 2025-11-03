package estrutura;

import java.util.ArrayList;

public class Pizza {
    private String sabor;
    private String tamanho;
    private double preco;
    private ArrayList<Adicional> ingredientesAdicionais;
    public Pizza(String sabor, String tamanho, double precoBase) {
        if (precoBase <= 0) {
            this.preco = 0;
        }else {
            this.preco = precoBase;
        }
        this.sabor = sabor;
        this.tamanho = tamanho;
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
    public ArrayList<Adicional> getIngredientesAdicionais() {
        return ingredientesAdicionais;
    }

    public void setPrecoBase(double precoBase) {
        this.preco = precoBase;
        for (Adicional item : ingredientesAdicionais) {
            this.preco += item.getPreco();
        }
    }
    private double precoBaseTamanho(String tamanho){
        double precoBase = 20.0;
        switch (tamanho.toLowerCase()) {
            case "pequena":
                precoBase *= 1; 
                break;
            case "média":
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
        double precoBase = precoBaseTamanho(tamanho); 
        switch (sabor.toLowerCase()) {
            case "calabresa":
                precoBase *= 1.1; 
                break;
            case "mussarela":
                precoBase *= 1.1; 
                break;
            case "frango com catupiry":
                precoBase *= 1.3; 
                break;
            case "portuguesa":
                precoBase *= 1.25;
                break;
            default:
                precoBase*=1;
                break;
    }
        return precoBase;
}
    }
    




