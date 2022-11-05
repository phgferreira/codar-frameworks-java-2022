package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.comissao.CalculadoraComissao;
import br.com.bluesoft.alucar.model.*;
import br.com.bluesoft.alucar.model.projecao.ComissaoProjecao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ComissaoRepositoryTest {

    @Autowired
    private ComissaoRepository comissaoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private AluguelRepository aluguelRepository;

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

        BigDecimal valorComissao = new CalculadoraComissao().calcula(aluguel);

        Comissao comisao = new Comissao(LocalDate.now(), valorComissao, vendedor, aluguel);
        comissaoRepository.save(comisao);
    }

    @Test
    @DisplayName("Deve listar todas as comissões")
    void listAllTest() {
        List<Comissao> comissoes = comissaoRepository.findAll();
        assertTrue( comissoes.size() > 0 );
    }

    @Test @DisplayName("Deve listar as comissões agrupadas por vendedor")
    void listAllGroupedByVendedorTest() {
        List<ComissaoProjecao> projecoes = comissaoRepository.listAllGroupedByAllVendedor();
        ComissaoProjecao projecao = projecoes.get(0);

        assertEquals("Rodrigo Limeira Cachias", projecao.getNome());
        assertEquals(new BigInteger("34378748819"), projecao.getCpf());
        assertEquals(new BigDecimal("19.1"), projecao.getValor());
    }

}