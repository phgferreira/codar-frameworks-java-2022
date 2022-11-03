package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
