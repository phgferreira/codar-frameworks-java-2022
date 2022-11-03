package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.model.Aluguel;
import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.model.Vendedor;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
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

    @BeforeEach
    void beforeEach() {
        Cliente cliente = clienteRepository.findByCpf( new BigInteger("39371890017") );
        Vendedor vendedor = vendedorRepository.findByCpf( new BigInteger("34378748819") );
        Carro carro = carroRepository.findByPlaca("ABC-1234");

        LocalDate dataCriacao = LocalDate.parse("1901-01-01");
        Integer diasAlugado = 2;
        BigDecimal valorTotal = carro.getDiaria().multiply( new BigDecimal(diasAlugado) );

        Aluguel aluguel = new Aluguel(cliente, vendedor, carro, diasAlugado, valorTotal, dataCriacao);
        aluguelRepository.save(aluguel);
        aluguelKeyTest = aluguel.getAluguelKey();
    }

    @Test @DisplayName("Deve listar todos os alugueis")
    void listAllTest() {
        List<Aluguel> alugueis = aluguelRepository.findAll();
        assertTrue( alugueis.size() > 0 );
    }
 st
    @AfterEach
    void afterEach() {
        aluguelRepository.deleteById( aluguelKeyTest );
    }
}