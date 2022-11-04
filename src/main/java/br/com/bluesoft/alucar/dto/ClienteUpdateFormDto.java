package br.com.bluesoft.alucar.dto;

import br.com.bluesoft.alucar.model.Cliente;

import java.math.BigInteger;

public class ClienteUpdateFormDto {

    private String nome;

    private BigInteger cpf;

    private String email;

    private BigInteger celular;

    private String enderecoRua;

    private Integer enderecoNumero;

    private String enderecoComplemento;

    private String enderecoBairro;

    private String enderecoCidade;

    private String enderecoEstado;

    public void update(Cliente cliente) {
        cliente.setNome( this.nome );
        cliente.setCpf( this.cpf );
        cliente.setEmail( this.email );
        cliente.setCelular( this.celular );
        cliente.getEndereco().setRua( this.enderecoRua );
        cliente.getEndereco().setNumero( this.enderecoNumero );
        cliente.getEndereco().setComplemento( this.enderecoComplemento );
        cliente.getEndereco().setBairro( this.enderecoBairro );
        cliente.getEndereco().setCidade( this.enderecoCidade );
        cliente.getEndereco().setEstado( this.enderecoEstado );
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

    public String getEnderecoRua() {
        return enderecoRua;
    }

    public void setEnderecoRua(String enderecoRua) {
        this.enderecoRua = enderecoRua;
    }

    public Integer getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(Integer enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    public void setEnderecoComplemento(String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
    }

    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    public String getEnderecoCidade() {
        return enderecoCidade;
    }

    public void setEnderecoCidade(String enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }

    public String getEnderecoEstado() {
        return enderecoEstado;
    }

    public void setEnderecoEstado(String enderecoEstado) {
        this.enderecoEstado = enderecoEstado;
    }

}
