package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.controller.dto.AluguelDetalhadoDto;
import br.com.bluesoft.alucar.controller.dto.AluguelFormDto;
import br.com.bluesoft.alucar.model.Aluguel;
import br.com.bluesoft.alucar.repository.AluguelRepository;
import br.com.bluesoft.alucar.repository.CarroRepository;
import br.com.bluesoft.alucar.repository.ClienteRepository;
import br.com.bluesoft.alucar.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("aluguel")
public class AluguelController {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private CarroRepository carroRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AluguelDetalhadoDto> insert(@RequestBody AluguelFormDto aluguelFormDto, UriComponentsBuilder uriBuilder) {
        System.out.println(aluguelFormDto);
        Aluguel aluguel = aluguelFormDto.convertToAluguel(clienteRepository, vendedorRepository, carroRepository);
        aluguelRepository.save( aluguel );

        URI uri = uriBuilder.path("/aluguel/{id}").buildAndExpand(aluguel.getAluguelKey()).toUri();
        return ResponseEntity.created( uri ).body( new AluguelDetalhadoDto( aluguel ) );
    }

    @GetMapping("{id}")
    public ResponseEntity detail(@PathVariable("id") Integer aluguelKey) {
        Optional<Aluguel> aluguel = aluguelRepository.findById(aluguelKey);
        if (!aluguel.isPresent())
            return ResponseEntity.notFound().build();

        AluguelDetalhadoDto dto = new AluguelDetalhadoDto( aluguel.get() );
        return ResponseEntity.ok( dto );
    }
}
