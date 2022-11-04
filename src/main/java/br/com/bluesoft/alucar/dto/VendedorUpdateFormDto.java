package br.com.bluesoft.alucar.dto;

import br.com.bluesoft.alucar.model.Vendedor;

import java.math.BigInteger;
import java.time.LocalDate;

public class VendedorUpdateFormDto {

    private String nome;

    private BigInteger cpf;

    private String contaBanco;

    private Integer contaAgencia;

    private Integer contaNumero;

    public void update(Vendedor vendedor) {
        vendedor.setNome( this.nome );
        vendedor.setCpf( this.cpf );
        vendedor.getContaCorrente().setBanco( this.contaBanco );
        vendedor.getContaCorrente().setAgencia( this.contaAgencia );
        vendedor.getContaCorrente().setContaCorrente( this.contaNumero );
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

    public String getContaBanco() {
        return contaBanco;
    }

    public void setContaBanco(String contaBanco) {
        this.contaBanco = contaBanco;
    }

    public Integer getContaAgencia() {
        return contaAgencia;
    }

    public void setContaAgencia(Integer contaAgencia) {
        this.contaAgencia = contaAgencia;
    }

    public Integer getContaNumero() {
        return contaNumero;
    }

    public void setContaNumero(Integer contaNumero) {
        this.contaNumero = contaNumero;
    }

}
