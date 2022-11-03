package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.model.ContaCorrente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ContaCorrenteRepositoryTest {

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    @Test @DisplayName("Deve listar todas as contas correntes")
    void listAllTest() {
        List<ContaCorrente> contas = contaCorrenteRepository.findAll();
        assertTrue( contas.size() > 0 );

    }
}