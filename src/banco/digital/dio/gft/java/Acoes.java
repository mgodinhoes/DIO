/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco.digital.dio.gft.java;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mgodi
 */
public class Acoes {

    //DEPOSITO
    public static String depositar(String numeroConta, double valor, String descricao) {

        boolean achouPessoa = false;

        for (Pessoa pessoa : Pessoa.listaDadosPessoa) {
            //Procura a pessoa
            if (pessoa.numeroConta.equals(numeroConta)) {
                achouPessoa = true;
                break;
            }
        }

        //Caso não ache a pessoa informa o operador
        if (!achouPessoa) {
            return "Conta ou cliente não encontrado.";
        }

        //Insere a transacao na lista de transações
        //1 - opção credito. 0 - opção débito
        BancoDigitalDioGFTJava.transacoes.add(new Transacoes(numeroConta, new Date(), 1, descricao, valor));

        return "Deposito realizado com sucesso.";
    }

    //SAQUE
    public static String sacar(String numeroConta, double valor, String descricao) {

        boolean achouPessoa = false;

        for (Pessoa pessoa : Pessoa.listaDadosPessoa) {
            //Procura a pessoa
            if (pessoa.numeroConta.equals(numeroConta)) {
                achouPessoa = true;
                break;
            }
        }

        //Caso não ache a pessoa informa o operador
        if (!achouPessoa) {
            return "Conta ou cliente não encontrado.";
        }

        double saldo = saldo(numeroConta);

        if (saldo < valor) {
            return String.format("Saldo insuficiente. Disponivel: %.2f", saldo);
        }

        //Insere a transacao na lista de transações
        //1 - opção credito. 0 - opção débito
        BancoDigitalDioGFTJava.transacoes.add(new Transacoes(numeroConta, new Date(), 0, descricao, valor));

        return "Saque realizado com sucesso.";
    }

    //EXTRATO
    public static String extrato(String numeroConta) {

        String ret = "";

        double saldoFinal = 0;

        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

        ret += "Data\t\tTipo\tDescricao\tValor\n\r";
        ret += "---------------------------------------------\n\r";

        for (Transacoes transacao : BancoDigitalDioGFTJava.transacoes) {
            if (transacao.numeroConta == numeroConta) {
                ret += formatoData.format(transacao.data) + "\t" + (transacao.debitoCredito == 0 ? "Debito" : "Credito") + "\t" + String.format("%12s", transacao.descricao) + "\t" + String.format("%7s", String.format("%.2f", transacao.valor)) + "\n\r";
                saldoFinal += transacao.valor;
            }
        }

        ret += String.format("Saldo final: %.2f\n\r", saldoFinal);

        return ret;
    }

    ///Calcula o saldo
    public static double saldo(String numeroConta) {

        double saldo = 0;

        for (Transacoes transacao : BancoDigitalDioGFTJava.transacoes) {
            if (transacao.numeroConta.equals(numeroConta)) {
                saldo += transacao.valor;
            }
        }

        return saldo;

    }
}
