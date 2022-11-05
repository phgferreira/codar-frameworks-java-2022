package br.com.bluesoft.alucar.dto;

import br.com.bluesoft.alucar.model.ContaCorrente;
import br.com.bluesoft.alucar.model.Vendedor;
import br.com.bluesoft.alucar.model.projecao.ComissaoProjecao;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ComissaoRelatorioDto {

    private String vendedor;

    private BigInteger cpf;

    private BigDecimal valor;

    private ContaCorrenteDto conta;

    public ComissaoRelatorioDto(ComissaoProjecao projecao) {
        this.vendedor = projecao.getNome();
        this.cpf = projecao.getCpf();
        this.valor = projecao.getValor();
        this.conta = new ContaCorrenteDto(projecao.getBanco(), projecao.getAgencia(), projecao.getContaCorrente());
    }

    public String getVendedor() {
        return vendedor;
    }

    public BigInteger getCpf() {
        return cpf;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public ContaCorrenteDto getConta() {
        return conta;
    }
}
