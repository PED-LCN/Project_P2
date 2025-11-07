package estrutura;

import java.util.Optional;

public class Adicional extends Produto {

    public Adicional(String nome, double preco) {
        super(nome, (preco <= 0) ? 0 : preco);
    }
    @Override
    public String toString() {
        return String.format("%-25s +R$%.2f", (Object) this.nome, (Object) this.preco);
    }
}
