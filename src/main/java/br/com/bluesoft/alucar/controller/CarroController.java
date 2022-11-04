package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.controller.dto.CarroDetalhadoDto;
import br.com.bluesoft.alucar.controller.dto.CarroInsertFormDto;
import br.com.bluesoft.alucar.controller.dto.CarroUpdateFormDto;
import br.com.bluesoft.alucar.controller.dto.ErroDto;
import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
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
            return ResponseEntity.status(409).body( new ErroDto("Carro de placa " + carroInsertFormDto.getPlaca() + " já foi cadastrado" ) );

        Carro carro = carroInsertFormDto.convertToCarro();
        carroRepository.save(carro);

        URI uri = uriBuilder.path("/carro/{id}").buildAndExpand(carro.getPlaca()).toUri();
        return ResponseEntity.created( uri ).body( new CarroDetalhadoDto( carro ) );
    }

    @PutMapping("{placa}")
    @Transactional
    public ResponseEntity pudate(@PathVariable String placa, @RequestBody @Valid CarroUpdateFormDto carroUpdateFormDto, UriComponentsBuilder uriBuilder) {
        Optional<Carro> carroOpcional = carroRepository.findById(placa);
        if (!carroOpcional.isPresent())
            return ResponseEntity.notFound().build();

        Carro carro = carroOpcional.get();
        carroUpdateFormDto.update( carro );

        URI uri = uriBuilder.path("/carro/{id}").buildAndExpand( carro.getPlaca() ).toUri();
        return ResponseEntity.created( uri ).body( new CarroDetalhadoDto( carro ) );
    }

    @DeleteMapping("{placa}")
    @Transactional
    public ResponseEntity delete(@PathVariable String placa) {
        Optional<Carro> carroOpcional = carroRepository.findById(placa);
        if (!carroOpcional.isPresent())
            return ResponseEntity.notFound().build();

        carroRepository.delete( carroOpcional.get() );
        return ResponseEntity.ok(new ErroDto("Carro de placa " + placa + " excluído com sucesso"));
    }

    @GetMapping("{id}")
    public void findById() {

    }

    @GetMapping
    public void listAll() {

    }
}
