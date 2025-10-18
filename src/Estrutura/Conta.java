package Estrutura;

public class Conta {
    private String agencia;
    private String numero;
    private double saldo = 0;
    private Cliente titular;

    public Conta(Cliente titular, String agencia, String numero) {
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }
    public Cliente getTitular() {
        return titular;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }
    public boolean sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
        }else{
            System.out.println("Saldo insuficiente!");
            return false;
        }
        return true;
    }
    public boolean transferir(double valor, Conta conta) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            conta.depositar(valor);
        }else {
            System.out.println("Saldo insuficiente!");
            return false;
        }
        return true;
    }
    public void getSaldo() {
        System.out.println("Saldo atual: R$" + this.saldo);
    }

}
