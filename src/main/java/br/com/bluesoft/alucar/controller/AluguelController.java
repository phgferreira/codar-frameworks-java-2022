package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.dto.AluguelDetalhadoDto;
import br.com.bluesoft.alucar.dto.AluguelFormDto;
import br.com.bluesoft.alucar.dto.AluguelRelatorioDto;
import br.com.bluesoft.alucar.dto.CarroDetalhadoDto;
import br.com.bluesoft.alucar.model.Aluguel;
import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.repository.AluguelRepository;
import br.com.bluesoft.alucar.repository.CarroRepository;
import br.com.bluesoft.alucar.repository.ClienteRepository;
import br.com.bluesoft.alucar.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
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
    public ResponseEntity<AluguelDetalhadoDto> insert(@RequestBody @Valid AluguelFormDto aluguelFormDto, UriComponentsBuilder uriBuilder) {
        Aluguel aluguel = aluguelFormDto.convertToAluguel(clienteRepository, vendedorRepository, carroRepository);
        aluguelRepository.save( aluguel );

        URI uri = uriBuilder.path("/aluguel/{id}").buildAndExpand(aluguel.getAluguelKey()).toUri();
        return ResponseEntity.created( uri ).body( new AluguelDetalhadoDto( aluguel ) );
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Integer aluguelKey) {
        Optional<Aluguel> aluguel = aluguelRepository.findById(aluguelKey);
        if (!aluguel.isPresent())
            return ResponseEntity.notFound().build();

        AluguelDetalhadoDto dto = new AluguelDetalhadoDto( aluguel.get() );
        return ResponseEntity.ok( dto );
    }

    @GetMapping
    public List<AluguelDetalhadoDto> listAll() {
        List<Aluguel> alugueis = aluguelRepository.findAll();
        List<AluguelDetalhadoDto> listaDto = new ArrayList<>();

        alugueis.forEach(aluguel -> listaDto.add( new AluguelDetalhadoDto(aluguel) ));
        return listaDto;
    }

    @GetMapping("relatorio")
    public List<AluguelRelatorioDto> listRelatorio() {
        List<Aluguel> alugueis = aluguelRepository.findAll();
        List<AluguelRelatorioDto> listaDto = new ArrayList<>();

        alugueis.forEach(aluguel -> listaDto.add( new AluguelRelatorioDto(aluguel) ));
        return listaDto;
    }
}
