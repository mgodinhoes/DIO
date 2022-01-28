/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco.digital.dio.gft.java;

/**
 * Armazena dados da conta
 *
 * @author mgodi
 */
public class Conta {

    public String numero;
    public String tipoConta;
    public double saldoInicial;

    //Instancia uma classe conta pelo número da conta
    public Conta(String numeroConta) {

        //Busca na lista de clientes a conta cadastrada
        for (Pessoa listaClientes : Pessoa.listaDadosPessoa) {
            if (listaClientes.numeroConta.equals(numeroConta)) {

                this.numero = listaClientes.numeroConta;
                this.tipoConta = listaClientes.tipoConta;
                break;
            }

        }
        //Saldo inicial para todos os clientes
        this.saldoInicial = 330.45;

    }
}
