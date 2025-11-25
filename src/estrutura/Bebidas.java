package estrutura;

public class Bebidas extends Produto {

    private final int tamanhoMl;
    private int quantidade;

    public Bebidas(String nome, int tamanho) {
        super(nome, precoBaseTamanho(nome, tamanho));
        this.tamanhoMl = tamanho;
    }

    private static double definirPrecoBase(String nome) {
        double precoBase;
        String nomeLower = nome.toLowerCase().strip();

        if (nomeLower.contains("coca")) {
            precoBase = 8.50;
        } else if (nomeLower.contains("fanta") || nomeLower.contains("sprite") || nomeLower.contains("guaraná") || nomeLower.contains("lata")) {
            precoBase = 6.50;
        } else if (nomeLower.contains("água")) {
            precoBase = 2.5;
        } else if (nomeLower.contains("suco")) {
            precoBase = 4.5;
        } else if (nomeLower.contains("vinho")) {
            precoBase = 25.0;
        } else {
            precoBase = 10.0;
        }
        return precoBase;
    }

    private static double precoBaseTamanho(String nome,int tamanho){
        double precoBase = definirPrecoBase(nome);
        switch (tamanho) {
            case 300,250:
                precoBase *= 1.0;
                break;
            case 500:
                precoBase *= 1.20;
                break;
            case 1000:
                precoBase *= 1.30;
                break;
            case 1500:
                precoBase *= 1.45;
                break;
            case 2000:
                precoBase *= 1.55;
                break;
            default:
                precoBase*=1;
                break;
        }
        return precoBase;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public int getTamanho(){
        return tamanhoMl;
    }

    public String getTamanhoParaCliente() {
        if (this.tamanhoMl >= 1000) {
            double tamanhoLitros = (double) this.tamanhoMl / 1000.0;
            return String.format("%.1f L", tamanhoLitros);
        } else {
            return this.tamanhoMl + " ml";
        }
    }

    public double getQuantidade(){
        if (this.tamanhoMl >= 1000) {
            return (this.tamanhoMl / 1000.0);
        } else {
            return this.tamanhoMl;
        }
    }

    public void diminuirQuantidade() throws ProdutoForaDeEstoqueException{
        if (this.quantidade <= 0) {
            throw new ProdutoForaDeEstoqueException(
                    "A bebida '" + this.nome + "' (" + this.tamanhoMl + "ml) está fora de estoque!"
            );
        }
    }

    @Override
    public String toString() {
        return String.format("%-24s %-8s  R$%.2f",  this.nome, getTamanho(), this.preco);
    }
}