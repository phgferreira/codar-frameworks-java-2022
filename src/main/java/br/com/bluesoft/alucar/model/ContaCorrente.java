package br.com.bluesoft.alucar.model;

public class ContaCorrente {

    private Integer contaCorrenteKey;

    private String banco;

    private Integer agencia;

    private Integer contaCorrente;

    private Vendedor vendedor;

    public Integer getContaCorrenteKey() {
        return contaCorrenteKey;
    }

    public void setContaCorrenteKey(Integer contaCorrenteKey) {
        this.contaCorrenteKey = contaCorrenteKey;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(Integer contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
