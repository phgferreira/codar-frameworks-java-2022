package br.com.bluesoft.alucar.dto;

import br.com.bluesoft.alucar.model.Aluguel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AluguelRelatorioDto {

    private String clienteNome;

    private String carroModelo;

    private String carroPlaca;

    private String vendedorNome;

    private Integer aluguelDiasAlugado;

    private BigDecimal aluguelValorTotal;

    private LocalDate aluguelDataCriacao;

    public AluguelRelatorioDto(Aluguel aluguel) {
        this.clienteNome = aluguel.getCliente().getNome();
        this.carroModelo = aluguel.getCarro().getModelo();
        this.carroPlaca = aluguel.getCarro().getPlaca();
        this.vendedorNome = aluguel.getVendedor().getNome();
        this.aluguelDiasAlugado = aluguel.getDiasAlugado();
        this.aluguelValorTotal = aluguel.getValorTotal();
        this.aluguelDataCriacao = aluguel.getDataCriacao();
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public String getCarroModelo() {
        return carroModelo;
    }

    public String getCarroPlaca() {
        return carroPlaca;
    }

    public String getVendedorNome() {
        return vendedorNome;
    }

    public Integer getAluguelDiasAlugado() {
        return aluguelDiasAlugado;
    }

    public BigDecimal getAluguelValorTotal() {
        return aluguelValorTotal;
    }

    public LocalDate getAluguelDataCriacao() {
        return aluguelDataCriacao;
    }
}
