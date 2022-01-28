/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco.digital.dio.gft.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mgodi
 */
public class Pessoa {

    public String nomePessoa;
    public String tipoPessoa;
    public String numeroConta;
    public String tipoConta;

    public static List<Pessoa> listaDadosPessoa = new ArrayList(Arrays.asList(new Pessoa("1234", "Marcelo Alves Godinho", "Física", "Corrente"), new Pessoa("5678", "Carla Joias ME", "Jurídica", "Poupança")));

    //Construtor padrao
    public Pessoa() {
    }

    //Construtor para inserir um novo cliente
    public Pessoa(String numeroConta, String nomePessoa, String tipoPessoa, String tipoConta) {
        this.nomePessoa = nomePessoa;
        this.tipoPessoa = tipoPessoa;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
    }

    //Constructor modificado para retornar pessoa pelo numero da conta
    public Pessoa(String numeroConta) {
        for (Pessoa pessoa : listaDadosPessoa) {
            if (pessoa.numeroConta.equals(numeroConta)) {
                this.nomePessoa = pessoa.nomePessoa;
                this.tipoPessoa = pessoa.tipoPessoa;
                this.numeroConta = pessoa.numeroConta;  
                break;
            }
        }
    }

    //Insere uma nova pessoa
    public void AddPessoa(String numeroConta, String nomePessoa, String tipoPessoa, String tipoConta) {
        this.nomePessoa = nomePessoa;
        this.tipoPessoa = tipoPessoa;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;

        //Insere um novo cliente
        listaDadosPessoa.add(new Pessoa(numeroConta, nomePessoa, tipoPessoa, tipoConta));
    }

}
