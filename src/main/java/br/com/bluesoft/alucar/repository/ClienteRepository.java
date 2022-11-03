package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByCpf(BigInteger cpf);
}
