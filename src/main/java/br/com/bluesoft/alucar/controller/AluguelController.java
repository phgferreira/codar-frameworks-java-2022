package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.controller.dto.AluguelFormDto;
import br.com.bluesoft.alucar.model.Aluguel;
import br.com.bluesoft.alucar.repository.AluguelRepository;
import br.com.bluesoft.alucar.repository.CarroRepository;
import br.com.bluesoft.alucar.repository.ClienteRepository;
import br.com.bluesoft.alucar.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;

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
    public ResponseEntity<Aluguel> insert(@RequestBody AluguelFormDto aluguelFormDto, UriComponentsBuilder uriBuilder) {
        System.out.println(aluguelFormDto);
        Aluguel aluguel = aluguelFormDto.convertToAluguel(clienteRepository, vendedorRepository, carroRepository);
        aluguelRepository.save( aluguel );

        URI uri = uriBuilder.path("/aluguel/{id}").buildAndExpand(aluguel.getAluguelKey()).toUri();
        // Por enquanto estou retornando nulo no body mas em breve colocarei o DTO
        return ResponseEntity.created( uri ).body( null );
    }
}
