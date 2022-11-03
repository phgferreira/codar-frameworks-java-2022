package br.com.bluesoft.alucar.model;

import java.math.BigInteger;
import java.time.LocalDate;

public class Vendedor {

    private Integer vendedorKey;

    private String nome;

    private BigInteger cpf;

    private LocalDate dataAdmissao;

    private ContaCorrente contaCorrente;

    public Integer getVendedorKey() {
        return vendedorKey;
    }

    public void setVendedorKey(Integer vendedorKey) {
        this.vendedorKey = vendedorKey;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigInteger getCpf() {
        return cpf;
    }

    public void setCpf(BigInteger cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }
}
