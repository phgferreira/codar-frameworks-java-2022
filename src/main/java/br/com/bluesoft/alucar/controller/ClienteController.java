package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.dto.*;
import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.model.ContaCorrente;
import br.com.bluesoft.alucar.model.Endereco;
import br.com.bluesoft.alucar.model.Vendedor;
import br.com.bluesoft.alucar.repository.ClienteRepository;
import br.com.bluesoft.alucar.repository.ContaCorrenteRepository;
import br.com.bluesoft.alucar.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity insert(@RequestBody @Valid ClienteInsertFormDto clienteInsertFormDto, UriComponentsBuilder uriBuilder) {
        Cliente checkCliente = clienteRepository.findByCpf(clienteInsertFormDto.getCpf());
        if ( checkCliente != null )
            return ResponseEntity.status(409).body( new MensagemDto("Cliente com CPF " + checkCliente.getCpf() + " já foi cadastrado" ) );

        Cliente cliente = clienteInsertFormDto.convertToCliente();
        clienteRepository.save(cliente);
        Endereco endereco = clienteInsertFormDto.getEndereco( cliente );
        enderecoRepository.save(endereco);

        URI uri = uriBuilder.path("/endereco/{id}").buildAndExpand(cliente.getClienteKey()).toUri();
        return ResponseEntity.created( uri ).body( new ClienteDetalhadoDto( cliente ) );
    }
//
//    @PutMapping("{id}")
//    @Transactional
//    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid ClienteUpdateFormDto clienteUpdateFormDto, UriComponentsBuilder uriBuilder) {
//        Cliente cliente = clienteRepository.getReferenceById(id);
//        clienteUpdateFormDto.update( cliente );
//        URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand( cliente.getClienteKey() ).toUri();
//        return ResponseEntity.created( uri ).body( new ClienteDetalhadoDto( cliente ) );
//    }
//
//    @DeleteMapping("{id}")
//    @Transactional
//    public ResponseEntity delete(@PathVariable Integer id) {
//        Cliente cliente = clienteRepository.getReferenceById(id);
//        clienteRepository.delete(cliente);
//        return ResponseEntity.ok(new MensagemDto("Cliente " + cliente.getNome() + " excluído com sucesso"));
//    }
//
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        Cliente cliente = clienteRepository.getReferenceById(id);
        return ResponseEntity.ok( new ClienteDetalhadoDto( cliente ) );
    }

    @GetMapping
    public List<ClienteDetalhadoDto> listAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDetalhadoDto> listaDto = new ArrayList<>();

        clientes.forEach(cliente -> listaDto.add( new ClienteDetalhadoDto(cliente) ));
        return listaDto;
    }
}
