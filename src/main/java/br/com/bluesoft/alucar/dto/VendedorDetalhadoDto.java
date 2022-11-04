package br.com.bluesoft.alucar.dto;

import br.com.bluesoft.alucar.model.ContaCorrente;
import br.com.bluesoft.alucar.model.Vendedor;

import javax.persistence.OneToOne;
import java.math.BigInteger;
import java.time.LocalDate;

public class VendedorDetalhadoDto {

    private Integer vendedorKey;

    private String nome;

    private BigInteger cpf;

    private LocalDate dataAdmissao;

    public VendedorDetalhadoDto(Vendedor vendedor) {
        this.vendedorKey = vendedor.getVendedorKey();
        this.nome = vendedor.getNome();
        this.cpf = vendedor.getCpf();
        this.dataAdmissao = vendedor.getDataAdmissao();
    }

    public Integer getVendedorKey() {
        return vendedorKey;
    }

    public String getNome() {
        return nome;
    }

    public BigInteger getCpf() {
        return cpf;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

}
