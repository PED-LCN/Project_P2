package Estrutura;

import java.time.LocalDate;

public class BancoApp {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Luiz Fernando", "090.769.434-94", LocalDate.of(2006, 12, 17));

        System.out.println("Cliente " + cliente1.getNome() + " criado com sucesso!");
        System.out.println("------------------------------------------");

        System.out.println("Criando uma nova conta para o novo cliente: ");
        Conta contaCliente1 = new Conta(cliente1, "1011", "(81)9 86124600");
        System.out.println("Conta de " + cliente1.getNome() + " criada com sucesso!");
        System.out.println("-------------------------------------------");

        contaCliente1.depositar(500);
        System.out.println("O cliente " + cliente1.getNome() + " de CPF " + cliente1.getCpf() + " Depositou R$ 500.");
        contaCliente1.getSaldo();

        contaCliente1.sacar(600);

        Cliente cliente2 = new Cliente("Lara Alves", "944.349.670-90", LocalDate.of(2006, 9, 27));
        System.out.println("------------------------------------------");

        System.out.println("Cliente " + cliente2.getNome() + " criado com sucesso!");
        System.out.println("------------------------------------------");

        System.out.println("Criando uma nova conta para o novo cliente: ");
        Conta contaCliente2 = new Conta(cliente2, "1011", "(81)9 86124600");
        System.out.println("Conta de " + cliente2.getNome() + " criada com sucesso!");
        System.out.println("-------------------------------------------");

        contaCliente2.depositar(1000);
        contaCliente2.getSaldo();

        contaCliente2.transferir(300, contaCliente1);
        System.out.println("O saldo de Luiz(cliente1) é: ");
        contaCliente1.getSaldo();
        System.out.println("E o saldo de Lara(cliente2) é: ");
        contaCliente2.getSaldo();


    }
}
