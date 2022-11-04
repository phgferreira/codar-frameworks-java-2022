package br.com.bluesoft.alucar.dto;

import br.com.bluesoft.alucar.model.ContaCorrente;
import br.com.bluesoft.alucar.model.Vendedor;

import java.math.BigInteger;
import java.time.LocalDate;

public class VendedorInsertFormDto {

    private String nome;

    private BigInteger cpf;

    private String contaBanco;

    private Integer contaAgencia;

    private Integer contaNumero;

    public Vendedor convertToVendedor() {
        Vendedor vendedor = new Vendedor(
                this.nome,
                this.cpf,
                LocalDate.now()
        );
        return vendedor;
    }

    public ContaCorrente getContaCorrente(Vendedor vendedor) {
        ContaCorrente conta = new ContaCorrente(
                this.contaBanco,
                this.contaAgencia,
                this.contaNumero,
                vendedor
        );
        return conta;
    }

    @Override
    public String toString() {
        return "VendedorInsertFormDto{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
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
