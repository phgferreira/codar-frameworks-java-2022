package br.com.bluesoft.alucar.dto;

import br.com.bluesoft.alucar.model.Carro;

import java.math.BigDecimal;

public class CarroDetalhadoDto {

    private String placa;

    private String marca;

    private String modelo;

    private String cor;

    private Integer ano;

    private Integer quilometragem;

    private BigDecimal diaria;

    public CarroDetalhadoDto(Carro carro) {
        this.placa = carro.getPlaca();
        this.marca = carro.getMarca();
        this.modelo = carro.getModelo();
        this.cor = carro.getCor();
        this.ano = carro.getAno();
        this.quilometragem = carro.getQuilometragem();
        this.diaria = carro.getDiaria();
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public Integer getAno() {
        return ano;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public BigDecimal getDiaria() {
        return diaria;
    }
}
