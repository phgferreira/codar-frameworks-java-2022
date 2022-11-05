package br.com.bluesoft.alucar.dto;

import br.com.bluesoft.alucar.model.ContaCorrente;
import br.com.bluesoft.alucar.model.Vendedor;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ComissaoRelatorioDto {

    private String vendedorNome;

    private BigInteger vendedorCpf;

    private BigDecimal valorComissao;

    private ContaCorrente vendedorConta;

    public ComissaoRelatorioDto(Vendedor vendedor, BigDecimal valorComissao) {
        this.vendedorNome = vendedor.getNome();
        this.vendedorCpf = vendedor.getCpf();
        this.vendedorConta = vendedor.getContaCorrente();
        this.valorComissao = valorComissao;
    }

    public String getVendedorNome() {
        return vendedorNome;
    }

    public BigInteger getVendedorCpf() {
        return vendedorCpf;
    }

    public BigDecimal getValorComissao() {
        return valorComissao;
    }

    public ContaCorrente getVendedorConta() {
        return vendedorConta;
    }
}
