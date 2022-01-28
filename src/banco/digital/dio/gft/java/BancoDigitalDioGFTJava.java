/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banco.digital.dio.gft.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mgodi
 */
public class BancoDigitalDioGFTJava {

    public static Pessoa cliente = new Pessoa("1234");
    public static List<Transacoes> transacoes = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
        } else {

            //COloca um saldo inicial
            BancoDigitalDioGFTJava.transacoes.add(new Transacoes(cliente.numeroConta, new Date(), 1, "Dep.Inic.", 100));

            boolean loopContinua = true;

            Scanner leitor = new Scanner(System.in);
            // TODO code application logic here
            do {
                System.out.println("\n\rDigite uma opção:");

                System.out.println("1 - Depositar.");
                System.out.println("2 - Sacar.");
                System.out.println("3 - Extrato movimentações.");

                System.out.println("4 - Sair.");

                int opcao = leitor.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Valor a depositar: ");
                        double valor = leitor.nextDouble();
                        System.out.println(Acoes.depositar(cliente.numeroConta, valor, "Deposito"));
                        break;

                    case 2:
                        System.out.println("Valor a sacar: ");
                        valor = leitor.nextDouble();
                        System.out.println(Acoes.sacar(cliente.numeroConta, valor, "Saque"));
                        break;

                    case 3:
                        System.out.println("Extrato movimentacao: ");
                        System.out.println(Acoes.extrato(cliente.numeroConta));
                        break;

                    case 4:
                        loopContinua = false;
                    default:
                        System.out.println("Opcao invalida.");
                        break;
                }
            } while (loopContinua);

            System.out.println("Bye...");

        }
    }
}
