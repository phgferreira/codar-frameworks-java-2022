package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.model.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Integer> {
}
