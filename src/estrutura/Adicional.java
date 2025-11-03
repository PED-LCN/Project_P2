package estrutura;

public class Adicional {
    private String nome;
    private double preco;

    public Adicional(String nome, double preco) {
        if (preco <= 0){
            this.preco = 0;
        } else {
            this.preco = preco;
        }
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }

    public String toString() {
        return nome + ("R$ " + String.format("%.2f", preco) + ")");
    }
}
