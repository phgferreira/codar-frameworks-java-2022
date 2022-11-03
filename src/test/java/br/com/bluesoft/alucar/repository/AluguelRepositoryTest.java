package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.model.Aluguel;
import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.model.Vendedor;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigInteger;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AluguelRepositoryTest {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private CarroRepository carroRepository;

    private static Integer aluguelKeyTest = 0;

    @Test @DisplayName("Deve cadastrar um aluguel no banco de dados")
    @Order(1)
    void insertTest() {
        Cliente cliente = clienteRepository.findByCpf( new BigInteger("39371890017") );
        assertNotNull( cliente );

        Vendedor vendedor = vendedorRepository.findByCpf( new BigInteger("34378748819") );
        assertNotNull( vendedor );

        Carro carro = carroRepository.findByPlaca("ABC-1234");
        assertNotNull( carro );

        LocalDate dataCriacao = LocalDate.parse("1901-01-01");
        Aluguel aluguel = new Aluguel(cliente, vendedor, carro, 2, dataCriacao);
        aluguelRepository.save(aluguel);
        assertNotNull( aluguel.getAluguelKey() );

        // Guarda para ser usado no teste de delete
        aluguelKeyTest = aluguel.getAluguelKey();
    }

//    @Test @DisplayName("Deve listar todos os alugueis")
//    void listAllTest() {
//
//    }
}