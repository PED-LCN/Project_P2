package estrutura;

public abstract class Produto {
    protected String nome;
    protected double preco;
    protected int quantidade;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = 0;
        
    }
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public double getQuantidade() { return  quantidade; }

    public void adicionarestoque(int quantidade) {
        this.quantidade += quantidade;
    }

    public void diminuirEstoque() throws  ProdutoForaDeEstoqueException {
        if (this.quantidade <= 0) {
            throw new ProdutoForaDeEstoqueException(
                    "O produto " + nome + " está fora de estoque."
            );
        }
        this.quantidade -=1;
    }

    @Override
    public String toString() {
        return String.format("%-25s R$%.2f", (Object) this.nome, (Object) this.preco);
    }
}
