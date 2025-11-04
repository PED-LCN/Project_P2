package estrutura;

public class Adicional {
    private final String nome;
    private final double preco;

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
        return String.format("%-25s +R$%.2f", this.nome, this.preco);
    }


}
