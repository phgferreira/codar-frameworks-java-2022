package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
}
