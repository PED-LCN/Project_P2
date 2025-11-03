package estrutura;

import java.util.ArrayList;

public class Bebidas {
    private String Nome;
    private double preco;
    private int tamanhoMl;
    private ArrayList<Adicional> adicionais;

    public Bebidas(String nome, double precoBase, int tamanho) {
        this.Nome = nome;
        this.preco = precoBase;
        this.tamanhoMl = tamanho;
        this.adicionais = new ArrayList<>();
    }

    public void adicionarAdicional(Adicional item){
        this.adicionais.add(item);
        this.preco += item.getPreco();
        System.out.println("Adicional: " + item.getNome() + "Adicionado à bebida!");
    }
    public String getNome() {
        return Nome;
    }
    public double getPreco() {
        return preco;
    }
    public ArrayList<Adicional> getAdicionais() {
        return adicionais;
    }
    public String getTamanho() {
        if (this.tamanhoMl >= 1000) {
            double tamanhoLitros = (double) this.tamanhoMl / 1000.0;
            return String.format("%.2f L", tamanhoLitros);
        } else {

            return this.tamanhoMl + " ml";

        }
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}