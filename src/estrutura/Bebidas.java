package estrutura;

import java.util.ArrayList;

public class Bebidas {
    private String Nome;
    private String sabor;
    private double preco;
    private int tamanhoMl;
    private ArrayList<Adicional> adicionais;

    public Bebidas(String nome, double precoBase, int tamanho) {
        this.Nome = nome;
        this.sabor = sabor;
        this.preco = preco;
        this.tamanhoMl = tamanho;
        this.adicionais = new ArrayList<>();
    }

    private double getMultiplicadorTamanho() {
        if (this.tamanhoMl<= 250){
            return 1.0;
        } else if( this.tamanhoMl<= 500){
            return 1.5;
        } else if (this.tamanhoMl <= 1000){
            return 2.5;
        }else{
            return 3.5;
        }
    }
    
    public double getPreco() {
        return this.preco * getMultiplicadorTamanho();
    }

    public String getSabor() {
        return sabor;
    }

    public String getNome() {
        return Nome;
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