package br.com.bluesoft.alucar.model;

import java.math.BigDecimal;

public class Carro {

    private Integer carroKey;

    private String placa;

    private String marca;

    private String modelo;

    private String cor;

    private Integer ano;

    private Integer quilometragem;

    private BigDecimal diaria;

    public Integer getCarroKey() {
        return carroKey;
    }

    public void setCarroKey(Integer carroKey) {
        this.carroKey = carroKey;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }

    public BigDecimal getDiaria() {
        return diaria;
    }

    public void setDiaria(BigDecimal diaria) {
        this.diaria = diaria;
    }
}
