package br.com.bluesoft.alucar.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Comissao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer comissaoKey;

    private LocalDate dataCriacao;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "vendedor_key")
    private Vendedor vendedor;

    @OneToOne
    @JoinColumn(name = "aluguel_key")
    private Aluguel aluguel;

    public Comissao() {
    }

    public Comissao(LocalDate dataCriacao, BigDecimal valor, Vendedor vendedor, Aluguel aluguel) {
        this.dataCriacao = dataCriacao;
        this.valor = valor;
        this.vendedor = vendedor;
        this.aluguel = aluguel;
    }

    public Integer getComissaoKey() {
        return comissaoKey;
    }

    public void setComissaoKey(Integer comissaoKey) {
        this.comissaoKey = comissaoKey;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }
}
