package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.model.Endereco;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EnderecoRepositoryTest {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Test @DisplayName("Deve listar todos os endereços cadastrados")
    void listAllTest() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        assertTrue( enderecos.size() > 0 );
    }
}