package br.com.bluesoft.alucar.dto;

public class ContaCorrenteDto {

    private String banco;

    private Integer agencia;

    private Integer contaCorrente;

    public ContaCorrenteDto(String banco, Integer agencia, Integer contaCorrente) {
        this.banco = banco;
        this.agencia = agencia;
        this.contaCorrente = contaCorrente;
    }

    public String getBanco() {
        return banco;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Integer getContaCorrente() {
        return contaCorrente;
    }
}
