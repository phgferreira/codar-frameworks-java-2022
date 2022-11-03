package br.com.bluesoft.alucar.controller.dto;

import br.com.bluesoft.alucar.model.Aluguel;
import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.model.Vendedor;
import br.com.bluesoft.alucar.repository.CarroRepository;
import br.com.bluesoft.alucar.repository.ClienteRepository;
import br.com.bluesoft.alucar.repository.VendedorRepository;

import java.math.BigInteger;
import java.time.LocalDate;

public class AluguelFormDto {

    private String clienteCpf;

    private String vendedorCpf;

    private String carroPlaca;

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
        Vendedor vendedor = vendedorRepository.findByCpf(new BigInteger(this.vendedorCpf));
        Carro carro = carroRepository.findByPlaca(this.carroPlaca);

        Aluguel aluguel = new Aluguel(cliente, vendedor, carro, this.diasAlugado, LocalDate.now());
        return aluguel;
    }
}
