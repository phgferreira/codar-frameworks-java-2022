package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel, Integer> {
}
