package estrutura;

public class Bebidas {
    private final String Nome;
    private final double preco;
    private final int tamanhoMl;


    public Bebidas(String nome, int tamanho) {
        this.Nome = nome;
        this.preco = precoBaseTamanho(nome,tamanho);
        this.tamanhoMl = tamanho;
    }

    private double definirPrecoBase(String nome) {
        double precoBase;
            switch (nome.toLowerCase().strip()) {
                case "coca" :
                   precoBase = 8.50;
                   break;
                case "fanta", "sprite", "guarana", "lata" :
                   precoBase = 6.50;
                   break;
                case "agua" :
                   precoBase = 2.5;
                   break;
                case "suco" :
                   precoBase = 4.5;
                   break;
                case "vinho" :
                   precoBase = 25.0;
                   break;
                default :
                   precoBase = 10.0;
                   break;
        }
        return precoBase;
    }

    private double precoBaseTamanho(String nome,int tamanho){
        double precoBase = definirPrecoBase(nome);
        switch (tamanho) {
            case 300, 250:
                precoBase *= 1.0;
                break;
            case 500:
                precoBase *= 1.25;
                break;
            case 1000:
                precoBase *= 1.35;
                break;
            case 1500:
                precoBase *= 1.50;
                break;
            case 2000:
                precoBase *= 1.65;
                break;
            default:
                precoBase*=1;
                break;
        }
        return precoBase;
    }
    
    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return Nome;
    }

    public String getTamanho() {
        if (this.tamanhoMl >= 1000) {
            double tamanhoLitros = (double) this.tamanhoMl / 1000.0;
            return String.format("%.2f L", tamanhoLitros);
        } else {

            return this.tamanhoMl + " ml";

        }
    }
    public String toString() {
        return String.format("%-25s (%s) R$%.2f", this.Nome, getTamanho(), this.preco);
    }
}