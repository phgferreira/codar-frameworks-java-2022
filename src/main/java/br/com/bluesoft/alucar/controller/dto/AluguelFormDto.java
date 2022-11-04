package br.com.bluesoft.alucar.controller.dto;

import br.com.bluesoft.alucar.model.Aluguel;
import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.model.Vendedor;
import br.com.bluesoft.alucar.repository.CarroRepository;
import br.com.bluesoft.alucar.repository.ClienteRepository;
import br.com.bluesoft.alucar.repository.VendedorRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.NoSuchElementException;

public class AluguelFormDto {

    @NotBlank
    private String clienteCpf;

    @NotBlank
    private String vendedorCpf;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]{3}\\-\\d{4}$")
    private String carroPlaca;

    @NotNull
    private Integer diasAlugado;

    @Override
    public String toString() {
        return "AluguelFormDto{" +
                "clienteCpf='" + clienteCpf + '\'' +
                ", vendedorCpf='" + vendedorCpf + '\'' +
                ", carroPlaca='" + carroPlaca + '\'' +
                ", diasAlugado=" + diasAlugado +
                '}';
    }

    public String getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(String clienteCpf) {
        this.clienteCpf = clienteCpf;
    }

    public String getVendedorCpf() {
        return vendedorCpf;
    }

    public void setVendedorCpf(String vendedorCpf) {
        this.vendedorCpf = vendedorCpf;
    }

    public String getCarroPlaca() {
        return carroPlaca;
    }

    public void setCarroPlaca(String carroPlaca) {
        this.carroPlaca = carroPlaca;
    }

    public Integer getDiasAlugado() {
        return diasAlugado;
    }

    public void setDiasAlugado(Integer diasAlugado) {
        this.diasAlugado = diasAlugado;
    }

    public Aluguel convertToAluguel(ClienteRepository clienteRepository, VendedorRepository vendedorRepository, CarroRepository carroRepository) {
        Cliente cliente = clienteRepository.findByCpf(new BigInteger(this.clienteCpf));
        if (cliente == null)
            throw new NoSuchElementException("Cliente com o CPF " + this.clienteCpf + " não foi encontrado");

        Vendedor vendedor = vendedorRepository.findByCpf(new BigInteger(this.vendedorCpf));
        if (vendedor == null)
            throw  new NoSuchElementException("Vendedor com o CPF " + this.vendedorCpf + " não foi encontrado");

        Carro carro = carroRepository.findByPlaca(this.carroPlaca);
        if (carro == null)
            throw new NoSuchElementException("Carro com a placa " + this.carroPlaca + " não foi encontrado");

        BigDecimal valorTotal = carro.getDiaria().multiply( new BigDecimal(this.diasAlugado) );
        Aluguel aluguel = new Aluguel(cliente, vendedor, carro, this.diasAlugado, valorTotal, LocalDate.now());
        return aluguel;
    }
}
