package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.model.Carro;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarroRepositoryTest {

    @Autowired
    private CarroRepository carroRepository;

    @Test @DisplayName("Deve listar todos os carros cadastrados")
    void listAllTest() {
        List<Carro> carros = carroRepository.findAll();
        assertTrue( carros.size() > 0 );
    }

}