package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.controller.dto.AluguelDetalhadoDto;
import br.com.bluesoft.alucar.controller.dto.CarroDetalhadoDto;
import br.com.bluesoft.alucar.controller.dto.CarroFormDto;
import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("carro")
public class CarroController {

    @Autowired
    private CarroRepository carroRepository;

    @PostMapping
    @Transactional
    public ResponseEntity insert( @RequestBody @Valid CarroFormDto carroFormDto, UriComponentsBuilder uriBuilder) {
        Carro carro = carroFormDto.convertToCarro();
        carroRepository.save(carro);

        URI uri = uriBuilder.path("/carro/{id}").buildAndExpand(carro.getPlaca()).toUri();
        return ResponseEntity.created( uri ).body( new CarroDetalhadoDto( carro ) );
    }

    @PutMapping
    public void pudate() {

    }

    @DeleteMapping
    public void delete() {

    }

    @GetMapping("{id}")
    public void findById() {

    }

    @GetMapping
    public void listAll() {

    }
}
