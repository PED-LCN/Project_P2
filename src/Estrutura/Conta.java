package Estrutura;

public class Conta {
    private String agencia;
    private String numero;
    private double saldo;
    private Cliente titular;

    public Conta(Cliente titular, String agencia, String numero) {
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
    }
    public Cliente getTitular() {
        return titular;
    }

}
