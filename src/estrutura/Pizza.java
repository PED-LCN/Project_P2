package estrutura;

import java.util.ArrayList;

public class Pizza extends Produto {
    private String tamanho;
    private ArrayList<Adicional> ingredientesAdicionais;
    private int quantidade;

    public Pizza(String sabor, String tamanho) {
        super(sabor, precoBaseTamanho(sabor, tamanho));
        this.tamanho = tamanho;
        this.ingredientesAdicionais = new ArrayList<>();

    }
    
    public void adicionarAdicionais(Adicional item){
        this.ingredientesAdicionais.add(item);
        this.preco += item.getPreco();
        System.out.println("Adicional: " + item.getNome() + " Adicionado à Pizza!");
    }
    public int getQuantidade(){
        return this.quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public void diminuirQuantidade(){
        this.quantidade -=1;
    }

    public String getSabor() {
        return this.nome;
    }

    public String getTamanho() {
        return tamanho;
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

    private static double precoBaseTamanho(String sabor, String tamanho){
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

    private static double definirPrecoBase(String sabor) {
        double precoBase;
        switch (sabor.toLowerCase().strip()) {
            case "calabresa","frango com catupiry":
                precoBase = 31.0;
                break;
            case "mussarela","portuguesa":
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
        return String.format("%-24s %-8s R$%.2f", this.nome, this.tamanho, this.preco);
    }
}