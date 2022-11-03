package br.com.bluesoft.alucar.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clienteKey;

    private String nome;

    private BigInteger cpf;

    private String email;

    private BigInteger celular;

    @OneToOne(mappedBy = "cliente")
    private Endereco endereco;

    public Integer getClienteKey() {
        return clienteKey;
    }

    public void setClienteKey(Integer clienteKey) {
        this.clienteKey = clienteKey;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getCelular() {
        return celular;
    }

    public void setCelular(BigInteger celular) {
        this.celular = celular;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
