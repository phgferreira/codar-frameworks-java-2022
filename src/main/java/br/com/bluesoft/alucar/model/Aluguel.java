package br.com.bluesoft.alucar.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Aluguel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aluguelKey;

    private LocalDate dataCriacao;

    private Integer diasAlugado;

    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_key")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "vendedor_key")
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "carro_placa")
    private Carro carro;

    public Aluguel() {
    }

    public Aluguel(Cliente cliente, Vendedor vendedor, Carro carro, int diasAlugado, BigDecimal valorTotal, LocalDate dataCriacao) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.carro = carro;
        this.diasAlugado = diasAlugado;
        this.valorTotal = valorTotal;
        this.dataCriacao = dataCriacao;
    }

    public Integer getAluguelKey() {
        return aluguelKey;
    }

    public void setAluguelKey(Integer aluguelKey) {
        this.aluguelKey = aluguelKey;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Integer getDiasAlugado() {
        return diasAlugado;
    }

    public void setDiasAlugado(Integer diasAlugado) {
        this.diasAlugado = diasAlugado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
