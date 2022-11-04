package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.dto.MensagemDto;
import br.com.bluesoft.alucar.dto.VendedorDetalhadoDto;
import br.com.bluesoft.alucar.dto.VendedorInsertFormDto;
import br.com.bluesoft.alucar.dto.VendedorUpdateFormDto;
import br.com.bluesoft.alucar.model.ContaCorrente;
import br.com.bluesoft.alucar.model.Vendedor;
import br.com.bluesoft.alucar.repository.ContaCorrenteRepository;
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
@RequestMapping("vendedor")
public class VendedorController {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity insert(@RequestBody @Valid VendedorInsertFormDto vendedorInsertFormDto, UriComponentsBuilder uriBuilder) {
        Vendedor checkVendedor = vendedorRepository.findByCpf(vendedorInsertFormDto.getCpf());
        if ( checkVendedor != null )
            return ResponseEntity.status(409).body( new MensagemDto("Vendedor com CPF " + checkVendedor.getCpf() + " já foi cadastrado" ) );

        Vendedor vendedor = vendedorInsertFormDto.convertToVendedor();
        vendedorRepository.save(vendedor);
        ContaCorrente conta = vendedorInsertFormDto.getContaCorrente( vendedor );
        contaCorrenteRepository.save(conta);

        URI uri = uriBuilder.path("/vendedor/{id}").buildAndExpand(vendedor.getVendedorKey()).toUri();
        return ResponseEntity.created( uri ).body( new VendedorDetalhadoDto( vendedor ) );
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid VendedorUpdateFormDto vendedorUpdateFormDto, UriComponentsBuilder uriBuilder) {
        Vendedor vendedor = vendedorRepository.getReferenceById(id);
        vendedorUpdateFormDto.update( vendedor );
        URI uri = uriBuilder.path("/vendedor/{id}").buildAndExpand( vendedor.getVendedorKey() ).toUri();
        return ResponseEntity.created( uri ).body( new VendedorDetalhadoDto( vendedor ) );
    }

//    @DeleteMapping("{id}")
//    @Transactional
//    public ResponseEntity delete(@PathVariable Integer id) {
//        Optional<Vendedor> vendedorOpcional = vendedorRepository.findById(id);
//        if (!vendedorOpcional.isPresent())
//            return ResponseEntity.notFound().build();
//
//        vendedorRepository.delete( vendedorOpcional.get() );
//        return ResponseEntity.ok(new MensagemDto("Vendedor " + vendedorOpcional.get().getNome() + " excluído com sucesso"));
//    }
//
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        Vendedor vendedor = vendedorRepository.getReferenceById(id);
        return ResponseEntity.ok( new VendedorDetalhadoDto( vendedor ) );
    }

    @GetMapping
    public List<VendedorDetalhadoDto> listAll() {
        List<Vendedor> vendedores = vendedorRepository.findAll();
        List<VendedorDetalhadoDto> listaDto = new ArrayList<>();

        vendedores.forEach(vendedor -> listaDto.add( new VendedorDetalhadoDto(vendedor) ));
        return listaDto;
    }
}
