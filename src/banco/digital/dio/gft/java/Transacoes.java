/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco.digital.dio.gft.java;

import java.util.Date;

/**
 *
 * @author mgodi
 */
public class Transacoes {

    public String numeroConta;
    public Date data;
    public int debitoCredito;
    public String descricao;
    public double valor;

    //Cria uma nova transacao
    public Transacoes(String numeroConta, Date data, int debitoCredito, String descricao, double valor) {
        this.data = data;
        this.debitoCredito = debitoCredito;
        this.descricao = descricao;
        this.numeroConta = numeroConta;
        if (debitoCredito == 0) {
            valor = -valor;
        }
        this.valor = valor;

    }
}
