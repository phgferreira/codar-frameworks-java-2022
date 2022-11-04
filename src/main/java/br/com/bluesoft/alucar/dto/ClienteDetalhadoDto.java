package br.com.bluesoft.alucar.dto;

import br.com.bluesoft.alucar.model.Cliente;

import java.math.BigInteger;

public class ClienteDetalhadoDto {

    private Integer clienteKey;

    private String nome;

    private BigInteger cpf;

    private String email;

    private BigInteger celular;

    public ClienteDetalhadoDto(Cliente cliente) {
        this.clienteKey = cliente.getClienteKey();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.celular = cliente.getCelular();
    }

    public Integer getClienteKey() {
        return clienteKey;
    }

    public String getNome() {
        return nome;
    }

    public BigInteger getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public BigInteger getCelular() {
        return celular;
    }
}
