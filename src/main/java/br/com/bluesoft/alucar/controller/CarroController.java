package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.dto.CarroDetalhadoDto;
import br.com.bluesoft.alucar.dto.CarroInsertFormDto;
import br.com.bluesoft.alucar.dto.CarroUpdateFormDto;
import br.com.bluesoft.alucar.dto.MensagemDto;
import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("carro")
public class CarroController {

    @Autowired
    private CarroRepository carroRepository;

    @PostMapping
    @Transactional
    public ResponseEntity insert(@RequestBody @Valid CarroInsertFormDto carroInsertFormDto, UriComponentsBuilder uriBuilder) {
        Optional<Carro> carroOpcional = carroRepository.findById( carroInsertFormDto.getPlaca() );
        if (carroOpcional.isPresent())
            return ResponseEntity.status(409).body( new MensagemDto("Carro de placa " + carroInsertFormDto.getPlaca() + " já foi cadastrado" ) );

        Carro carro = carroInsertFormDto.convertToCarro();
        carroRepository.save(carro);

        URI uri = uriBuilder.path("/carro/{placa}").buildAndExpand(carro.getPlaca()).toUri();
        return ResponseEntity.created( uri ).body( new CarroDetalhadoDto( carro ) );
    }

    @PutMapping("{placa}")
    @Transactional
    public ResponseEntity update(@PathVariable String placa, @RequestBody @Valid CarroUpdateFormDto carroUpdateFormDto, UriComponentsBuilder uriBuilder) {
        Carro carro = carroRepository.getReferenceById(placa);
        carroUpdateFormDto.update( carro );
        return ResponseEntity.ok().body( new CarroDetalhadoDto( carro ) );
    }

    @DeleteMapping("{placa}")
    @Transactional
    public ResponseEntity delete(@PathVariable String placa) {
        Carro carro = carroRepository.getReferenceById(placa);
        carroRepository.delete( carro );
        return ResponseEntity.ok(new MensagemDto("Carro " + carro.getMarca() + " " + carro.getModelo() + " (" + carro.getModelo() + " excluído com sucesso"));
    }

    @GetMapping("{placa}")
    public ResponseEntity findById(@PathVariable String placa) {
        Carro carro = carroRepository.getReferenceById(placa);
        return ResponseEntity.ok( new CarroDetalhadoDto( carro ) );
    }

    @GetMapping
    public List<CarroDetalhadoDto> listAll() {
        List<Carro> carros = carroRepository.findAll();
        List<CarroDetalhadoDto> listaDto = new ArrayList<>();

        carros.forEach(carro -> listaDto.add( new CarroDetalhadoDto(carro) ));
        return listaDto;
    }
}
