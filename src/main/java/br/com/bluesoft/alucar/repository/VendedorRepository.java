package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

    Vendedor findByCpf(BigInteger bigInteger);
}
