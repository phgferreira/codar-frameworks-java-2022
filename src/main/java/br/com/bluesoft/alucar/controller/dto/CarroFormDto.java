package br.com.bluesoft.alucar.controller.dto;

import br.com.bluesoft.alucar.model.Carro;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

public class CarroFormDto {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]{3}\\-\\d{4}$")
    private String placa;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @NotBlank
    private String cor;

    @NotNull
    private Integer ano;

    @NotNull
    private Integer quilometragem;

    @NotNull
    private BigDecimal diaria;

    @Override
    public String toString() {
        return "CarroFormDto{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cor='" + cor + '\'' +
                ", ano=" + ano +
                ", quilometragem=" + quilometragem +
                ", diaria=" + diaria +
                '}';
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

    public Carro convertToCarro() {
        Carro carro = new Carro(
                this.placa,
                this.marca,
                this.modelo,
                this.cor,
                this.ano,
                this.quilometragem,
                this.diaria
        );
        return carro;
    }
}
