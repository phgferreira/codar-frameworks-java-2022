package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.model.Cliente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test @DisplayName("Deve listar todos os clientes cadastrados")
    void listAllTest() {
        List<Cliente> clientes = clienteRepository.findAll();
        assertTrue( clientes.size() > 0 );

    }
}