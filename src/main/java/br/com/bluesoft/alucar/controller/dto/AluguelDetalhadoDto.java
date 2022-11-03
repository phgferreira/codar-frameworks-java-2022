package br.com.bluesoft.alucar.controller.dto;

import br.com.bluesoft.alucar.model.Aluguel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AluguelDetalhadoDto {

    private Integer aluguelKey;

    private LocalDate dataCriacao;

    private Integer diasAlugado;

    private BigDecimal valorTotal;

    private String clienteNome;

    private String vendedorNome;

    private String carroPlaca;

    private String carroModelo;

    public AluguelDetalhadoDto(Aluguel aluguel) {
        this.aluguelKey = aluguel.getAluguelKey();
        this.dataCriacao = aluguel.getDataCriacao();
        this.diasAlugado = aluguel.getDiasAlugado();
        this.valorTotal = aluguel.getValorTotal();
        this.clienteNome = aluguel.getCliente().getNome();
        this.vendedorNome = aluguel.getVendedor().getNome();
        this.carroPlaca = aluguel.getCarro().getPlaca();
        this.carroModelo = aluguel.getCarro().getModelo();
    }

    public Integer getAluguelKey() {
        return aluguelKey;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public Integer getDiasAlugado() {
        return diasAlugado;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public String getVendedorNome() {
        return vendedorNome;
    }

    public String getCarroPlaca() {
        return carroPlaca;
    }

    public String getCarroModelo() {
        return carroModelo;
    }
}
