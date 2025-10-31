package Estrutura;

public class Cliente {
    private String nome;
    private String telefone;
    private String endereco;

    Cliente(String nome, String telefone, String endereco ){
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public void atualizarEndereco(String novoEndereco){
        this.endereco = novoEndereco;
    }

    public String getNome() {
        return nome;
    }
}
