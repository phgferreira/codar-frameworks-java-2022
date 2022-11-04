package br.com.bluesoft.alucar.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
public class Vendedor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vendedorKey;

    private String nome;

    private BigInteger cpf;

    private LocalDate dataAdmissao;

    @OneToOne(mappedBy = "vendedor")
    private ContaCorrente contaCorrente;

    public Vendedor() {
    }

    public Vendedor(String nome, BigInteger cpf, LocalDate dataAdmissao) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataAdmissao = dataAdmissao;
    }

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
