package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.model.Vendedor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class VendedorRepositoryTest {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Test @DisplayName("Deve listar todos os vendedores cadastrados")
    void listAllTest() {
        List<Vendedor> vendedores = vendedorRepository.findAll();
        assertTrue( vendedores.size() > 0 );

    }
}