package estrutura;

public class Bebidas {
    private String Nome;
    private double preco;
    private int tamanhoMl;

    public Bebidas(String nome, double preco, int tamanho) {
        this.Nome = nome;
        this.preco = preco;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return Nome;
    }

    public double getPreco() {
        return preco;
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